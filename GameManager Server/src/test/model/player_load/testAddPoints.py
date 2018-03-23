from unittest import TestCase
#from wheel.signatures import assertTrue
#^couldn't get this import to work on my machine, not sure if needed
from model.game_load import Game
from model.player_load import Player

class TestAddPoints(TestCase):
    def testAddPointsBelowZeroNegativeOne(self):
        player = Player("Jun", 49)
        with self.assertRaises(ValueError):
            player.addPoints(-1)
            
    def testAddPointsBelowZeroNegativeHundred(self):
        player = Player("Jun", 49)
        with self.assertRaises(ValueError):
            player.addPoints(-100)
     
    def testValidAddPointsMultiplePlayers(self):
        player = Player("Kin", 300)
        player2 = Player("Jim", -40)
        player3 = Player("Fin", 0)
        player4 = Player("Rin", 1)
        
        
        player.addPoints(50)
        player2.addPoints(10)
        player3.addPoints(100)
        player4.addPoints(0)
        self.assertEqual(350, player.getPlayerScore(), "check for valid added points")
        self.assertEqual(-30, player2.getPlayerScore(), "check for valid added points")
        self.assertEqual(100, player3.getPlayerScore(), "check for valid added points")
        self.assertEqual(1, player4.getPlayerScore(), "check for valid added points")