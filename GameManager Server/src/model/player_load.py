'''
Created on Mar 1, 2018

@author: Bryan, Caleb, Dallas, Josh
'''


class Player:

    def __init__(self, name, points):
        if(name == None):
            raise ValueError('Player name must exist')
        if (not isinstance(name, str)):
            raise ValueError("Name value must be string")
        if(name == ""):
            raise ValueError('Player name cannot be empty')
        if(not isinstance(points, int)):
            raise ValueError("points must be ints")
        self._playerName = name
        self._playerScore = points
        self._toString = (name + " " + str(points) + "pts")
    
    def getPlayerScore(self):
        return self._playerScore
    
    def getPlayerName(self):
        return self._playerName
    
    def setPlayerScore(self, newScore):
        if (not isinstance(newScore, int)):
            raise ValueError("New Score value must be string")
        self._playerScore = newScore
    
    def setPlayerName(self, newName):
        if(newName == None):
            raise ValueError("New name cannot be None")
        if (not isinstance(newName, str)):
            raise ValueError("Name value must be string")
        if(newName == ""):
            raise ValueError("New name cannot be empty")
        self._playerName = newName
    
    def addPoints(self, amount):
        if (not isinstance(amount, int)):
            raise ValueError("amount value must be int")
        if(amount < 0):
            raise ValueError("Added points cannot be negative")
        self._playerScore = self._playerScore + amount
    
    def removePoints(self, amount):
        if (not isinstance(amount, int)):
            raise ValueError("amount value must be int")
        if(amount < 0):
            raise ValueError("Amount removed cannot be negative")
        self._playerScore = self._playerScore - amount
    
    def toString(self):
        return self._playerName + " " + str(self._playerScore) + "pts"
    # TODO COMPARATOR
   
