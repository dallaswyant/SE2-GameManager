'''
Created on Mar 5, 2018

@author: Bryan, Caleb, Dallas, Josh
'''
from model.player_load import Player


class Game:

    def __init__(self, name, pointsIncrementValue):
        if(name == None):
            raise ValueError("Name cannot be None")
        if (not isinstance(name, str)):
            raise ValueError("Name value must be string")
        if (name == ""):
            raise ValueError("Name cannot be empty")
        if(pointsIncrementValue == None):
            self._pointsIncrementValue = 1
        if(int(pointsIncrementValue) < 1):
            raise ValueError("Increments cannot be below 1")
        if(not isinstance(pointsIncrementValue, int)):
            raise ValueError("Must be integer")
        self._pointsIncrementValue = pointsIncrementValue
        self._players = []
        self._name = name
        self._isCompleted = False
    
    def addPlayer(self, player):
        if(player == None):
            raise ValueError("Player must exist")
        if(not isinstance(player, Player)):
            raise ValueError("insertion must be a Player object")
        self._players.append(player)
        
    def removePlayer(self, player):
        if(not isinstance(player, Player)):
            raise ValueError("insertion must be a Player object")
        if player not in self._players:
            raise ValueError("List must contain the player")
        self._players.remove(player)
        
    def getNumberOfPlayers(self):
        return len(self._players)
    
    def getCompletedStatus(self):
        return self._isCompleted
    
    def setCompleteStatus(self, status):
        self._isCompleted = status
        
    def toString(self):
        return self._name
    
    def getPlayers(self):
        return self._players
    
    def getPointsIncrementValue(self):
        return self._pointsIncrementValue
         
