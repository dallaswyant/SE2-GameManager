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
    
    '''
    adds player
    @precondition: player != none player must be player
    @postcondition: player is added
    @param player: player to add
    '''

    def addPlayer(self, player):
        if(player == None):
            raise ValueError("Player must exist")
        if(not isinstance(player, Player)):
            raise ValueError("insertion must be a Player object")
        self._players.append(player)
       
    '''
    removes player
    @precondition: player != none player must be player
    @postcondition: player is removed
    @param player: player to remove
    ''' 

    def removePlayer(self, player):
        if(not isinstance(player, Player)):
            raise ValueError("insertion must be a Player object")
        if player not in self._players:
            raise ValueError("List must contain the player")
        self._players.remove(player)

    '''
    returns number of players
    @postcondition: none
    @postcondition: none
    @return: number of players
    '''    

    def getNumberOfPlayers(self):
        return len(self._players)
    
    '''
    returns completed status
    @postcondition: none
    @postcondition: none
    @return: status
    '''  

    def getCompletedStatus(self):
        return self._isCompleted
    
    '''
    sets completed status
    @postcondition: status != none
    @postcondition: status 
    @param status: status to set
    ''' 

    def setCompleteStatus(self, status):
        self._isCompleted = status
      
    '''
    returns string description of class
    @postcondition: none
    @postcondition: none
    @return: toString
    '''  

    def toString(self):
        return self._name
    
    '''
    returns players
    @postcondition: none
    @postcondition: none
    @return: players
    '''

    def getPlayers(self):
        return self._players
    
    '''
    returns points increment
    @postcondition: none
    @postcondition: none
    @return: point increment value
    '''

    def getPointsIncrementValue(self):
        return self._pointsIncrementValue
         
