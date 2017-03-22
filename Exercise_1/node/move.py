#!/usr/bin/env python
import rospy
from geometry_msgs.msg import Twist
from nav_msgs.msg import Odometry


class get_odom(object):
    
    #constructor::
    def __init__(self,dist):
        self.x=0.0
        self.y=0.0
        self.z=0.0
        self.dist=dist
        self.subs=rospy.Subscriber('/odom',Odometry,get_pos)



    #define get_pos function
    def get_pos(self.msg):
        self.y=msg.pos.pos.position.y
        self.y=self.y+self.dist

    #define movement function
    def move_bot(slef):
        rospy

    



def main():
    # flag=0
    rospy.init_node('move')        
    velocity_publisher = rospy.Publisher('/cmd_vel', Twist)
    twist = Twist()     
    move=raw_input("Do you want to move? (Y or N):  ")
    dist=raw_input("Do far do want to move? (insert distance):  ")
    
    twist.linear.x = 0.0
    twist.linear.y = 0.0
    twist.angular.z = 0.0
    
    if (move=='Y' and dist>0):
        direct=raw_input("Direction? (R or L):  ")
        if (direct=='R'):
            #write code to move RIGHT by "dist" distance

            twist.linear.x = 0.0    
            twist.linear.y = 0.2
            twist.angular.z = 0.0
            
            rospy.spin():
            






            # flag=1
        elif (direct=='L'):
            #write code to move LEFT by "dist" distance









            # flag=1
        else:
            #DO NOT MOVE

            twist.linear.x = 0.0
            twist.linear.y = 0.0
            twist.angular.z = 0.0
            # flag=0;

        # if (flag==1):
        #     velocity_publisher.publish(twist)

    rate = rospy.Rate(10)
    while not rospy.is_shutdown():
        #rospy.logwarn("Running the node, time {}".format(rospy.get_time()))
        rate.sleep()
    pass

if __name__ == '__main__':
    main()