'''
Created on Feb 13, 2018

@author: Dallas Wyant
'''
import sys
from model.task import Task

def main(arguments):
    task = Task()
    
    task.addMaterials("splitter")
    
    print(task.getDescription())
    print(task.getStatus())
    print(task.getMaterials())
    
if(__name__ == "__main__"):
    main(sys.argv)