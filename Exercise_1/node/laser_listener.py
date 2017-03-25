#!/usr/bin/env python
import rospy
from amr_msgs.msg import Ranges
from geometry_msgs.msg import Twist



def sonar_callback(msg):      
    global velocity_publisher
    left, right = msg.ranges[3].range, msg.ranges[4].range
    twist = Twist()     

    if (left<=0.05 and right<=0.05):
        twist.linear.x = 0.0
        twist.linear.y = 0.0
        twist.angular.z = 0.0

    elif (left<=0.5 and left>0.05):
        twist.linear.x = 0.05
        twist.linear.y = 0.0
        twist.angular.z = -0.05
        
    elif (right<=0.5 and right>0.05):
        twist.linear.x = 0.05
        twist.linear.y = 0.0
        twist.angular.z = 0.05
 

    velocity_publisher.publish(twist)


'''
    twist.linear.x = (left+right)/2*0.5
    twist.linear.y = 0.0
    twist.angular.z = (left-right)
'''    
    

def main():
       
    rospy.init_node('controller')    
    rospy.Subscriber('/sonar_pioneer', Ranges, sonar_callback)
    global velocity_publisher    
    velocity_publisher = rospy.Publisher('/cmd_vel', Twist)
    
    rate = rospy.Rate(10)

    while not rospy.is_shutdown():
        #rospy.logwarn("Running the node, time {}".format(rospy.get_time()))
        rate.sleep()
    pass

if __name__ == '__main__':
    main()