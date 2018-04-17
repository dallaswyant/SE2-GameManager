from unittest import TestCase
from model.game_load import Game
from model.player_load import Player

class TestPointsIncrementValue(TestCase):
    def testPoingsIncreBelowOne(self):
        
        with self.assertRaises(ValueError):
            game = Game("Infinity", 0)
            game.getPointsIncrementValue()
            
    def testPointIncrementMultipleGames(self):
        game = Game("Infinity", 5)
        game2 = Game("BioWar", 25)
        game3 = Game("Monopoly", 15)
        
        self.assertEqual(5, game.getPointsIncrementValue())
        self.assertEqual(25, game2.getPointsIncrementValue())
        self.assertEqual(15, game3.getPointsIncrementValue())
    
    def testPointIncrementMultipleGamesHighIncrements(self):
        game = Game("Infinity", 500)
        game2 = Game("BioWar", 60000)
        game3 = Game("Monopoly", 700000000000)
        
        self.assertEqual(500, game.getPointsIncrementValue())
        self.assertEqual(60000, game2.getPointsIncrementValue())
        self.assertEqual(700000000000, game3.getPointsIncrementValue())