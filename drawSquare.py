#a turtle draws an outline of a star 
import turtle

def drawFractals():
	window = turtle.Screen()
	window.bgcolor("red")
	#turtle characteristics
	pencil = turtle.Turtle()
	pencil.shape("turtle")
	pencil.color("yellow")
	pencil.speed(2)
	
	#drawing shape
	i=0
	while (i<3):
		pencil.right(60)
		pencil.forward(100)

		i=i+1
	

	window.exitonclick()

drawStar()