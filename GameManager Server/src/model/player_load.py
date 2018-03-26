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
    
    '''
    returns player score
    @postcondition: none
    @postcondition: none
    @return: player score
    '''  

    def getPlayerScore(self):
        return self._playerScore
    
    '''
    returns player name
    @postcondition: none
    @postcondition: none
    @return: player name
    '''  

    def getPlayerName(self):
        return self._playerName

    '''
    sets player score
    @postcondition: newScore == string
    @postcondition: score is set
    @param newScore: score to set
    '''  

    def setPlayerScore(self, newScore):
        if (not isinstance(newScore, int)):
            raise ValueError("New Score value must be string")
        self._playerScore = newScore
    
    '''
    sets player name
    @postcondition: newName == string newName != None
    @postcondition: Name is set
    @param newName: name to set
    ''' 

    def setPlayerName(self, newName):
        if(newName == None):
            raise ValueError("New name cannot be None")
        if (not isinstance(newName, str)):
            raise ValueError("Name value must be string")
        if(newName == ""):
            raise ValueError("New name cannot be empty")
        self._playerName = newName
    
    '''
    adds player points
    @postcondition: amount == int amount >= 0
    @postcondition: points is added
    @param amount: points to add
    ''' 

    def addPoints(self, amount):
        if (not isinstance(amount, int)):
            raise ValueError("amount value must be int")
        if(amount < 0):
            raise ValueError("Added points cannot be negative")
        self._playerScore = self._playerScore + amount
    
    '''
    removes player points
    @postcondition: amount == int amount >= 0
    @postcondition: points is added
    @param amount: points to remove
    ''' 

    def removePoints(self, amount):
        if (not isinstance(amount, int)):
            raise ValueError("amount value must be int")
        if(amount < 0):
            raise ValueError("Amount removed cannot be negative")
        self._playerScore = self._playerScore - amount
    
    '''
    returns string description of class
    @postcondition: none
    @postcondition: none
    @return: toString
    '''  

    def toString(self):
        return self._playerName + " " + str(self._playerScore) + "pts"
    # TODO COMPARATOR
   
