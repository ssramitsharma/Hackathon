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
    posit_x=0.0
    posit_y=0.0
    posit_z=0.0
    
    #constructor::
    '''
    It sets the distance the user wants the bot to move
    '''
    def __init__(self,dist):
        self.dist=dist
        self.get_pos()
        self.x=self.posit_x
        self.y=self.posit_y
        self.z=self.posit_z
    

     #define get_pos function
    '''
     This is used to get the current coordinates of the bot.
    '''
    def get_pos(self):
        
        message=rospy.wait_for_message("/odom",Odometry,timeout=None)
        self.posit_x=message.pose.pose.position.x 
        self.posit_y=message.pose.pose.position.y
        self.posit_z=message.pose.pose.position.z

    #define movement function
    '''
    This is used to move the bot to the required positions. 
    Agruments:
      vel     -> Velocity with which bot will move.
      direct  -> Direction towards which the bot will move.
    '''
    def move_bot(self,vel,direct):

        # Creating a Publisher for /cmd_vel so that bot can be moved
        velocity_publisher = rospy.Publisher('/cmd_vel', Twist,queue_size=1)

        #Creating an object of Twist class to publish twist data        
        twist = Twist()     

        #setting speeds in x,z axes to zero
        twist.linear.y = 0.0        
        twist.linear.x = 0.0
        twist.angular.z = 0.0  

        if (direct=="R"):
           self.y=self.y-self.dist                                              #---- Stores end position (-ve as direction is 'right')        
           self.get_pos()                                                       #---- This will update postion variable with current value
           current_y=self.posit_y                                               #---- This variable will be used to check the position until the bot reaches the required location
           while(current_y>self.y):                                             #if direction is right (-ve direction), move until ccurrent position becomes <=target
               twist.linear.y = -vel
               print current_y
               velocity_publisher.publish(twist)
               self.get_pos()
               current_y=self.posit_y
               twist.linear.y = 0.0
               velocity_publisher.publish(twist)
               pass
           
           
        elif (direct=="L"):
           self.get_pos()                                                       #---- This will update postion variable with current value
           current_y=self.posit_y                                               #---- This variable will be used to check the position until the bot reaches the required location
           self.y=self.y+self.dist                                              #---- Stores end position
           while(current_y<self.y):                                             #if direction is left (+ve direction), move until ccurrent position becomes >=target
               twist.linear.y = vel
               print current_y
               velocity_publisher.publish(twist)
               self.get_pos()
               current_y=self.posit_y
               twist.linear.y = 0.0
               velocity_publisher.publish(twist)
               pass

        elif (direct=="F"):
           self.get_pos()                                                       #---- This will update postion variable with current value
           current_x=self.posit_x                                               #---- This variable will be used to check the position until the bot reaches the required location
           self.x=self.x+self.dist                                              #---- Stores end position
           while(current_x<self.x):                                             #if direction is Forward (+ve direction), move until ccurrent position becomes >=target
               twist.linear.x = vel
               print current_x
               velocity_publisher.publish(twist)
               self.get_pos()
               current_x=self.posit_x
               twist.linear.x = 0.0
               velocity_publisher.publish(twist)
               pass
            
        elif (direct=="B"):
           self.get_pos()                                                       #---- This will update postion variable with current value
           current_x=self.posit_x                                               #---- This variable will be used to check the position until the bot reaches the required location
           self.x=self.x-self.dist                                              #---- Stores end position
           while(current_x>self.x):                                             #if direction is Backward (-ve direction), move until ccurrent position becomes <=target
               twist.linear.x = -vel
               print current_x
               velocity_publisher.publish(twist)
               self.get_pos()
               current_x=self.posit_x
               twist.linear.x = 0.0
               velocity_publisher.publish(twist)
               pass

        else:
            pass
       
def main():
   
    rospy.init_node('move')                                                     #initiating node.
    move='Y'
    while(move=='Y'):
        move=raw_input("Do you want to move? (Y or N):  ")                          
        if (move=='Y'):                                                             #proceed if user says 'Y'
            dist=float(raw_input("Do far do want to move? (insert distance):  "))   
            if (dist!=0.0):                                                         #proceed if user enters value other than 0 
                direct=raw_input("Direction? (R, L, F or B):  ")
                bot_odom=get_odom(dist)                                             #passing value of distance
                vel=0.1                                                             #passing negative value of velocity as direction is right
                bot_odom.move_bot(vel,direct)
            else:
                pass
        else:
            print("Exiting..")
    pass

if __name__ == '__main__':
    main()