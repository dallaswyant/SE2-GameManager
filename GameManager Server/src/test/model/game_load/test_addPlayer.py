from unittest import TestCase
from wheel.signatures import assertTrue
from model.game_load import Game
from model.player_load import Player

class TestAddPlayer(TestCase):
    
    def testAddNonePlayerToGame(self):
        game = Game("Infinity", 6)
        with self.assertRaises(ValueError):
            game.addPlayer(None)
    
    def testAddOnePlayerToGame(self):
        game = Game("Infinity", 5)
        player = Player("Sherman", 27)
        game.addPlayer(player)
        
        self.assertEqual(1,game.getNumberOfPlayers(), "check for 1 player in game")
    
    def testMultiplePlayers(self):
        game = Game("Infinity", 5)
        
        player = Player("Sherman", 27)
        player2 = Player("Dorman", 24)
        player3 = Player("Craig", 28)
        
        game.addPlayer(player)
        game.addPlayer(player2)
        game.addPlayer(player3)
        
        self.assertEqual(3,game.getNumberOfPlayers(), "check for 3 player in game")
    
    def testMultiplePlayersWithSameNames(self):
        game = Game("Infinity", 5)
        
        player = Player("Sherman", 27)
        player2 = Player("Dorman", 24)
        player3 = Player("Sherman", 28)
        player4 = Player("Sherman", 29)
        
        game.addPlayer(player)
        game.addPlayer(player2)
        game.addPlayer(player3)
        game.addPlayer(player4)
        
        self.assertEqual(4,game.getNumberOfPlayers(), "check for 3 player in game same name")
    
    def testMultiplePlayersWithSameIncrements(self):
        game = Game("Infinity", 5)
        
        player = Player("Sherman", 27)
        player2 = Player("Dorman", 27)
        player3 = Player("Sherman", 27)
        player4 = Player("Sherman", 27)
        
        game.addPlayer(player)
        game.addPlayer(player2)
        game.addPlayer(player3)
        game.addPlayer(player4)
        
        self.assertEqual(4,game.getNumberOfPlayers(), "check for 3 player in game same increments")
        