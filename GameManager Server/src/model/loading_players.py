'''
Created on Mar 1, 2018

@author: Bryan, Caleb, Dallas, Josh
'''
from ctypes.test.test_pickling import name

def __init__(self,name, points ):
    if(name == None):
        raise ValueError('Player name must exist')
    if(name == ""):
        raise ValueError('Player name cannot be empty')
    self._playerName = playerName
    self._playerScore = score
    self._name = name
    self._points = points
    self._toString = (name + " " + points + "pts")

def getPlayerScore(self):
    return score

def getPlayerName(self):
    return name


    