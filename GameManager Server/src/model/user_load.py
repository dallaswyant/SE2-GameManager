from model.game_load import Game
'''
Created on Mar 1, 2018

@author: Bryan, Dallas, Josh, Caleb
@version: spring 2018
'''
class User:
    '''TODO
    username: if '''
    def __init__(self, username) :
        if(username == None):
            raise ValueError("username cannot be none")
        if(username == ""):
            raise ValueError("username cannot be empty")
        
        self._username = username
        self._completedGames = []
        self._inProgress = []
        self._currentGame = Game("Default Game Name", 1)
    
    def addCompletedGame(self, game):
        if(game == None):
            raise ValueError("Game must exist")
        if(game in self._completedGames):
            self._completedGames.remove(game)
        if(game in self._inProgress):
            self._inProgress.remove(game)
        #TODO getcompleted status
        self._completedGames.append(game)
    
    def getCompletedGames(self):
        return self._completedGames
    
    def getInProgressGames(self):
        return self._inProgress
    
    def getUsername(self):
        return self._username
    
    def setUsername(self, username):
        if(username == None):
            raise ValueError("Invalid username")
        if(username == ""):
            raise ValueError("Username cannot be empty")
        self._username = username
    
    def getCurrentGame(self):
        return self._currentGame
    
    def setCurrentGame(self, currGame):
        if (currGame == None):
            raise ValueError("Current game must exist")
        self._currentGame = currGame
    
    def setInProgressGames(self, games):
        self._inProgress = games
    
    
    
    
        