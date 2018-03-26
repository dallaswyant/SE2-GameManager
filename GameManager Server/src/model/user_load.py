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
    
    '''
    adds completed game
    @precondition: game != None game == game
    @postcondition: game is completed
    @param game: game to complete 
    '''
        
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
    returns next id
    @precondition: none
    @postcondition: none
    @return: next id
    '''

    def _getNextId(self):
        User._idCounter += 1
        return User._idCounter

    '''
    returns player id
    @precondition: none
    @postcondition: none
    @return: player id
    '''

    def getPlayerId(self):
        return self._playerId
    
    '''
    adds in progress game
    @precondition: game != None game == game
    @postcondition: game is completed
    @param game: game to added to in progress 
    '''

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
    
    '''
    returns completed games
    @precondition: none
    @postcondition: none
    @return: completed games
    '''

    def getCompletedGames(self):
        return self._completedGames
    
    '''
    returns in progress games
    @precondition: none
    @postcondition: none
    @return: in progress games
    '''

    def getInProgressGames(self):
        return self._inProgress
    
    '''
    returns user name
    @precondition: none
    @postcondition: none
    @return: user name
    '''

    def getUsername(self):
        return self._username
    
    '''
    sets user name
    @precondition: username != None username == string username != "" 
    @postcondition: user name is set
    @param username: user name to be set
    '''

    def setUsername(self, username):
        if(username == None):
            raise ValueError("Invalid user name")
        if (not isinstance(username, str)):
            raise ValueError("Must be a string")
        if(username == ""):
            raise ValueError("User name cannot be empty")
        self._username = username
    
    '''
    returns completed game
    @precondition: none
    @postcondition: none
    @return: completed game
    '''

    def getCurrentGame(self):
        return self._currentGame
    
    '''
    sets current game
    @precondition: currGame != None currGame == game
    @postcondition: currentGame is set
    @param currGame: current game to be set
    '''

    def setCurrentGame(self, currGame):
        if (currGame == None):
            raise ValueError("Current game must exist")
        if (not isinstance(currGame, Game)):
            raise ValueError("Must be a Game object")
        self._currentGame = currGame
    
    '''
    sets in progress games
    @precondition: games cannot be empty list games must be list of games
    @postcondition: inProgress is set
    @param games: in progress games list
    '''

    def setInProgressGames(self, games):
        if (not isinstance(games, list)):
            raise ValueError("Must be a list of games")
        self._inProgress = games
        
