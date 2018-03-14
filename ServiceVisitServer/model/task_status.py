'''
Created on Feb 13, 2018

@author: Dallas Wyant
'''

from enum import Enum, auto

class TaskStatus(Enum):
    ASSIGNED = auto();
    INCOMPLETE = auto();
    COMPLETE = auto();
    UNNECESSARY = auto();
