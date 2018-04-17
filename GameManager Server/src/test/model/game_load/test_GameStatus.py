from unittest import TestCase
from model.game_load import Game
from model.player_load import Player

class TestGameStatuss(TestCase):
    
    def testDefaultCompletedStatus(self):
        game = Game("Warlord", 5)
        game2 = Game("NeoCraft", 2)
        game3 = Game("Matrix", 100)
        self.assertFalse(game.getCompletedStatus(), "check for default false")
        self.assertFalse(game2.getCompletedStatus(), "check for default false")
        self.assertFalse(game3.getCompletedStatus(), "check for default false")
    
    def testMultipleGamesWithDifferentStatus(self):
        game = Game("Warlord", 5)
        game2 = Game("NeoCraft", 2)
        game3 = Game("Matrix", 100)
        game4 = Game("SkyGame", 200)
        
        game2.setCompleteStatus(True)
        game4.setCompleteStatus(True)
        self.assertFalse(game.getCompletedStatus(), "check for default false")
        self.assertTrue(game2.getCompletedStatus(), "check for true")
        self.assertFalse(game3.getCompletedStatus(), "check for default false")
        self.assertTrue(game4.getCompletedStatus(), "check for true")
        