#a turtle that draws a circle made of squares
import turtle

def drawCircleSquared():
	window = turtle.Screen()
	window.bgcolor("green")
	#turtle characteristics
	pencil = turtle.Turtle()
	pencil.shape("turtle")
	pencil.color("yellow")
	pencil.speed(10)
	
	#drawing shape
	j=0
	while (j<72):
		i=0
		while (i<4):
			pencil.forward(100)
			pencil.right(90)
			i=i+1
		pencil.right(5)
		j=j+1
	

	window.exitonclick()

drawCircleSquared()