from model.game_load import Game
'''
Created on Mar 1, 2018

@author: Bryan, Dallas, Josh, Caleb
@version: spring 2018
'''


class User:
    _idCounter = 0
    '''TODO
    username: if '''

    def __init__(self, username) :
        if(username == None):
            raise ValueError("user name cannot be none")
        if (not isinstance(username, str)):
            raise ValueError("name value must be string")
        if(username == ""):
            raise ValueError("user name cannot be empty")
        
        self._username = username
        self._completedGames = []
        self._inProgress = []
        self._currentGame = Game("Default Game Name", 1)
        self._playerId = self._getNextId()
    
    def addCompletedGame(self, game):
        if(game == None):
            raise ValueError("Game must exist")
        if (not isinstance(game, Game)):
            raise ValueError("Must be a game object")
        if(game in self._completedGames):
            self._completedGames.remove(game)
        if(game in self._inProgress):
            self._inProgress.remove(game)
        self._completedGames.append(game)

    '''
    Determines the next id to be used
    '''

    def _getNextId(self):
        User._idCounter += 1
        return User._idCounter
    
    '''
    Get the id for the player
    
    @return the id for the player
    '''

    def getPlayerId(self):
        return self._playerId
    
    def addInProgressGame(self, game):
        if(game == None):
            raise ValueError("Game must exist")
        if (not isinstance(game, Game)):
            raise ValueError("Must be a game object")
        if(game in self._completedGames):
            self._completedGames.remove(game)
        if(game in self._inProgress):
            self._inProgress.remove(game)
        self._inProgress.append(game)
    
    def getCompletedGames(self):
        return self._completedGames
    
    def getInProgressGames(self):
        return self._inProgress
    
    def getUsername(self):
        return self._username
    
    def setUsername(self, username):
        if(username == None):
            raise ValueError("Invalid user name")
        if (not isinstance(username, str)):
            raise ValueError("Must be a string")
        if(username == ""):
            raise ValueError("User name cannot be empty")
        self._username = username
    
    def getCurrentGame(self):
        return self._currentGame
    
    def setCurrentGame(self, currGame):
        if (currGame == None):
            raise ValueError("Current game must exist")
        if (not isinstance(currGame, Game)):
            raise ValueError("Must be a Game object")
        self._currentGame = currGame
    
    def setInProgressGames(self, games):
        if (not isinstance(games, list)):
            raise ValueError("Must be a list of games")
        self._inProgress = games
    
        
