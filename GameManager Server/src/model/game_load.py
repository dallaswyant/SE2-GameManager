'''
Created on Mar 5, 2018

@author: Bryan, Caleb, Dallas, Josh
'''

class Game:
    def _init_(self, name):
        if(name == None):
            raise ValueError("Name cannot be None")
        if(name == ""):
            raise ValueError("Name cannot be empty")
        
        self._pointsIncrementValue = 1
        self._players = []
        self._name = name
        self._isCompleted = False
    
    @classmethod
    def game(cls, name, pointsIncrementValue):
        if(name == None):
            raise ValueError("Name cannot be None")
        if(name == ""):
            raise ValueError("Name cannot be empty")
        self._players = []
        self._name = name
        self._isCompleted = False
        self._pointsIncrementValue = pointsIncrementValue
    
    def addPlayer(self, player):
        if(player == None):
            raise ValueError("Player must exist")
        self._players.append(player)
        
    def removePlayer(self, player):
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
        
        
         