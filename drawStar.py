#a turtle draws an outline of a star 
import turtle

def drawStar():
	window = turtle.Screen()
	window.bgcolor("blue")
	#turtle characteristics
	pencil = turtle.Turtle()
	pencil.shape("turtle")
	pencil.color("white")
	pencil.speed(2)
	
	#drawing shape
	i=0
	while (i<5):
		pencil.right(-72)
		pencil.forward(100)
		pencil.right(144)
		pencil.forward(100)
		i=i+1
	

	window.exitonclick()

drawStar()