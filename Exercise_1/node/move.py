#!/usr/bin/env python
import rospy
from geometry_msgs.msg import Twist
from nav_msgs.msg import Odometry


class get_odom(object):
    x=0.0    
    y=0.0
    z=0.0
    dist=0.0
    posit=0.0
    
    #constructor::
    def __init__(self,dist):
        self.dist=dist
        self.get_pos()
        self.y=self.posit
    
     #define get_pos function
    def get_pos(self):
        
        message=rospy.wait_for_message("/odom",Odometry,timeout=None)
        self.posit=message.pose.pose.position.y 

    #define movement function
    def move_bot(self,vel,direct):

        self.y=self.y+self.dist       #----Stores end position
        self.get_pos()
        current_y=self.posit              #----Stores the staring position
        
        velocity_publisher = rospy.Publisher('/cmd_vel', Twist,queue_size=1)
        twist = Twist()     
        twist.linear.x = 0.0
        twist.angular.z = 0.0  
        if (direct=="R"):
           while(abs(current_y)<abs(self.y)):
               twist.linear.y = vel
               print current_y
               velocity_publisher.publish(twist)
               self.get_pos()
               current_y=self.posit
               twist.linear.y = 0.0
               velocity_publisher.publish(twist)
               pass
           
           
        else:
           while(current_y<self.y):
               twist.linear.y = vel
               print current_y
               velocity_publisher.publish(twist)
               self.get_pos()
               current_y=self.posit
               twist.linear.y = 0.0
               velocity_publisher.publish(twist)
               pass
       



    



def main():
   
    rospy.init_node('move')        
    
    move=raw_input("Do you want to move? (Y or N):  ")
    if (move=='Y'):
        dist=float(raw_input("Do far do want to move? (insert distance):  "))
        if (dist>0):
            direct=raw_input("Direction? (R or L):  ")
            if (direct=='R'):                 
                    
                #write code to move RIGHT by "dist" distance
                bot_odom_r=get_odom(-dist)
                print "*******currently at::: ", bot_odom_r.y
                vel_right=-0.1
                bot_odom_r.move_bot(vel_right,direct)
                print "*******"
            
            elif (direct=='L'):
                #write code to move LEFT by "dist" distance
          
                bot_odom_l=get_odom(dist)
                print "*******currently at::: ", bot_odom_l.y                
                vel_left=0.1
                bot_odom_l.move_bot(vel_left,direct)
            

           # else:
                    #DO NOT MOVE
    else:
        print("Exiting..")
        
       
    
'''
    rate = rospy.Rate(10)
   
   while not rospy.is_shutdown():
        #rospy.logwarn("Running the node, time {}".format(rospy.get_time()))
        rate.sleep()
    pass
'''
   

if __name__ == '__main__':
    main()