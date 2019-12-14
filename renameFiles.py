import os
import sys

#this program removes numberes from file names in an entire directory
pathName = raw_input("Please type the path the of files you want to rename: ")

num = "0123456789"
def renameFiles():
	os.chdir(pathName)
	#grab files

	fileList = os.listdir(pathName)
	#grabfiles for a windos
	#fileList = os.listdir(r"C:\Users\Folder)
	for fileName in fileList:
		print fileName + " " + fileName.translate(None,num)
		os.rename(fileName, fileName.translate(None, num))
		
renameFiles()


