import time
import webbrowser

break_counter = 0

print "Lets work for 90 minutes using the Pomodoro method. Please take a 5 minute break every 25 minutes"
while (break_counter <=3):
	time.sleep(1500)
	webbrowser.open("http://www.youtube.com/watch?v=4IRdw_Qgwqc")
	break_counter = break_counter + 1
	time.sleep(300)