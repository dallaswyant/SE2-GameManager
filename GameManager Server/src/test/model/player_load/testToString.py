from unittest import TestCase
from model.player_load import Player


class TestConstructor(TestCase):
    
    def testInvalidNoneName(self):
        with self.assertRaises(ValueError):
            player = Player(None, 38)
            player.getPlayerName()
    
    def testInvalidNoPoints(self):
        with self.assertRaises(ValueError):
            player = Player("Craig", "")
            player.getPlayerScore()
    
    def testInvalidPointsString(self):
        with self.assertRaises(ValueError):
            player = Player('Doug', "hey")
            player.getPlayerScore()
            
    def testValidPlayerConstructor(self):

        player = Player("Kim", 39)
        self.assertEqual("Kim", player.getPlayerName(), "Check for name")
        self.assertEqual(39, player.getPlayerScore(), "check for score")
    
    def testValidPlayerConstructorWithZeroScore(self):
        
        player = Player("Kim", 0)
        self.assertEqual("Kim", player.getPlayerName(), "Check for name")
        self.assertEqual(0, player.getPlayerScore(), "check for score")
    
    def testValidPlayerConstructorWithNegativeScore(self):

        player = Player("Kim", -50)
        self.assertEqual("Kim", player.getPlayerName(), "Check for name")
        self.assertEqual(-50, player.getPlayerScore(), "check for score")
    
        
    