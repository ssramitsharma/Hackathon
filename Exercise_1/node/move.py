#!/usr/bin/env python
import rospy
from geometry_msgs.msg import Twist
from nav_msgs.msg import Odometry


class get_odom(object):
    #define class variables
    x=0.0    
    y=0.0
    z=0.0
    dist=0.0
    posit=0.0
    
    #constructor::
    '''
    It sets the distance the user wants the bot to move
    '''
    def __init__(self,dist):
        self.dist=dist
        self.get_pos()
        self.y=self.posit
    

     #define get_pos function
    '''
     This is used to get the current coordinates of the bot.
    '''
    def get_pos(self):
        
        message=rospy.wait_for_message("/odom",Odometry,timeout=None)
        self.posit=message.pose.pose.position.y 

    #define movement function
    '''
    This is used to move the bot to the required positions. 
    Agruments:
      vel     -> Velocity with which bot will move.
      direct  -> Direction towards which the bot will move.
    '''
    def move_bot(self,vel,direct):

        self.y=self.y+self.dist                                                 #---- Stores end position
        self.get_pos()                                                          #---- This will update postion variable with current value
        current_y=self.posit                                                    #---- This variable will be used to check the position until the bot reaches the required location
        

        # Creating a Publisher for /cmd_vel so that bot can be moved

        velocity_publisher = rospy.Publisher('/cmd_vel', Twist,queue_size=1)
        twist = Twist()     

        #setting speeds in x,z axes to zero
        twist.linear.x = 0.0
        twist.angular.z = 0.0  

        if (direct=="R"):
           while(current_y>self.y):                                             #if direction is right (-ve direction), move until ccurrent position becomes <=target
               twist.linear.y = vel
               print current_y
               velocity_publisher.publish(twist)
               self.get_pos()
               current_y=self.posit
               twist.linear.y = 0.0
               velocity_publisher.publish(twist)
               pass
           
           
        else:
           while(current_y<self.y):                                             #if direction is left (+ve direction), move until ccurrent position becomes >=target
               twist.linear.y = vel
               print current_y
               velocity_publisher.publish(twist)
               self.get_pos()
               current_y=self.posit
               twist.linear.y = 0.0
               velocity_publisher.publish(twist)
               pass
       



    



def main():
   
    rospy.init_node('move')                                                     #initiating node.
    
    move=raw_input("Do you want to move? (Y or N):  ")                          
    if (move=='Y'):                                                             #proceed if user says 'Y'
        dist=float(raw_input("Do far do want to move? (insert distance):  "))   
        if (dist!=0.0):                                                         #proceed if user enters value other than 0 
            direct=raw_input("Direction? (R or L):  ")
            if (direct=='R'):                 
                    
                #write code to move RIGHT by "dist" distance
                
                #Creating an object of the get_odom class
                bot_odom_r=get_odom(-dist)                                      #passing negative value of dist as direction is right
                print "*******currently at::: ", bot_odom_r.y
                vel_right=-0.1                                                  #passing negative value of velocity as direction is right
                bot_odom_r.move_bot(vel_right,direct)
                print "*******"
            
            elif (direct=='L'):
                #write code to move LEFT by "dist" distance
          
                #Creating an object of the get_odom class
                bot_odom_l=get_odom(dist)
                print "*******currently at::: ", bot_odom_l.y                
                vel_left=0.1
                bot_odom_l.move_bot(vel_left,direct)
            

            else:
                    #DO NOT MOVE
                pass
    else:
        print("Exiting..")
        

if __name__ == '__main__':
    main()