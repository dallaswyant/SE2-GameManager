from unittest import TestCase
from model.game_load import Game
from model.player_load import Player

class TestGetNumberOfPlayers(TestCase):
    
    def testZeroPlayersInList(self):
        game = Game("Infinity", 6)
        self.assertEqual(0, game.getNumberOfPlayers(), "check for getNum with 0") 
    
    def testgetOnePlayer(self):
        game = Game("Infinity", 6)
        player = Player("Steve", 69)
        game.addPlayer(player)
        self.assertEqual(1, game.getNumberOfPlayers(), "check for getNum with 1")
            

    def testMultiplePlayersThreeInList(self):
        game = Game("Infinity", 5)
        
        player = Player("Sherman", 27)
        player2 = Player("Dorman", 24)
        player3 = Player("Craig", 28)
        
        game.addPlayer(player)
        game.addPlayer(player2)
        game.addPlayer(player3)
        
        self.assertEqual(3,game.getNumberOfPlayers(), "check for getNum with 1")
    