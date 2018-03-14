'''
Created on Feb 13, 2018

@author: Dallas Wyant
'''
from model.task_status import TaskStatus

class Task:
    '''
    
    '''
    def __init__(self):
        self.description = ""
        self.status = TaskStatus.ASSIGNED
        self.materials = []
    '''
    Return the description of the task
    
    @return the description of the task
    '''
    def getDescription(self):
        return self.description
    '''
    Return the status of the task
    
    @return the status of the task
    '''
    def getStatus(self):
        return self.status
    
    '''
    Return the materials for the task
    
    @return the materials for the task
    '''
    def getMaterials(self):
        return self.materials
    
    def addMaterial(self):
        