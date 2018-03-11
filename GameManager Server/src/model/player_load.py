'''
Created on Mar 1, 2018

@author: Bryan, Caleb, Dallas, Josh
'''
class Player:
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
    
    def setPlayerScore(self, newScore):
        score = newScore
    
    def setPlayerName(self, newName):
        name = newName
    
    def getPoints(self):
        return points
    
    def setPoints(self, newPoints):
        points = newPoints
    
    def getName(self):
        return name
    
    def setName(self, newName):
        if(newName == None):
            raise ValueError("New name cannot be None")
        if(newName == ""):
            raise ValueError("New name cannot be empty")
        name = newName
    
    def addPoints(self, amount):
        if(amount < 0):
            raise ValueError("Added points cannot be negative")
        points = self._points + amount
    
    def removePoints(self, amount):
        if(amount < 0):
            raise ValueError("Amount removed cannot be negative")
        points = self._points - amount
    
    def toString(self):
        return name + " " + points + "pts"
    #TODO COMPARATOR
        