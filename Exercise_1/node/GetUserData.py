#!/usr/bin/env python
import rospy
from std_msgs.msg import *
       
def main():
    
    rospy.init_node('GetUserData')                                                     #initiating node.    
    input_publisher = rospy.Publisher('/input', String,queue_size=10)
    move_publisher = rospy.Publisher('/event_in', String,queue_size=10)   
  
    move=raw_input("Do you want to move? (Y or N):  ")
    rospy.loginfo("Hello"+move)
    move_publisher.publish(move)
    if (move=='Y'):                                                             #proceed if user says 'Y'
            
            dist=float(raw_input("Do far do want to move? (insert distance):  ")) 
            rospy.set_param("/distance", dist)
            if (dist!=0.0):                                                         #proceed if user enters value other than 0 
                direct=raw_input("Direction? (R, L, F or B):  ")
                print (move,direct,dist)
                input_publisher.publish(direct)
                
            else:
                pass
    else:
            print("Exiting..")
    
    

if __name__ == '__main__':
    main()