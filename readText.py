def readText():
	lyrics = open("monsterExplicit.txt")
	song = lyrics.read()
	print song
	lyrics.close()
	print len("Zia")

readText()