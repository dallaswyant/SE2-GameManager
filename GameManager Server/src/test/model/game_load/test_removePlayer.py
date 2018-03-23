from unittest import TestCase
from wheel.signatures import assertTrue
from model.game_load import Game
from model.player_load import Player

class TestAddPlayer(TestCase):
    
    def testRemovePlayerNotInList(self):
        game = Game("Infinity", 6)
        player = Player("Steve", 69)
        with self.assertRaises(ValueError):
            game.removePlayer(player)
    
    def testRemovePlayerNone(self):
        game = Game("Infinity", 6)
        
        with self.assertRaises(ValueError):
            game.removePlayer(None)
            
    def testAddAndRemoveOnePlayer(self):
        game = Game("Infinity", 5)
        player = Player("Sherman", 27)
        game.addPlayer(player)
        game.removePlayer(player)
        
        self.assertEqual(0,game.getNumberOfPlayers(), "check remove a player")
    
    def testMultiplePlayersRemoveOne(self):
        game = Game("Infinity", 5)
        
        player = Player("Sherman", 27)
        player2 = Player("Dorman", 24)
        player3 = Player("Craig", 28)
        
        game.addPlayer(player)
        game.addPlayer(player2)
        game.addPlayer(player3)
        
        game.removePlayer(player2)
        
        self.assertEqual(2,game.getNumberOfPlayers(), "check 2/3 players")
    
    def testMultiplePlayersRemoveThree(self):
        game = Game("Infinity", 5)
        
        player = Player("Sherman", 27)
        player2 = Player("Dorman", 24)
        player3 = Player("Sherman", 28)
        player4 = Player("Sherman", 29)
        
        game.addPlayer(player)
        game.addPlayer(player2)
        game.addPlayer(player3)
        game.addPlayer(player4)
        
        game.removePlayer(player)
        game.removePlayer(player3)
        game.removePlayer(player4)
        
        self.assertEqual(1,game.getNumberOfPlayers(), "check for 3 players removed")
        
    