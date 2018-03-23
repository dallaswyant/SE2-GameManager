from unittest import TestCase
from model.player_load import Player
class TestPlayerName(TestCase):
    
    def testValidPlayerName(self):
        player = Player("Surge", 35)
        
        self.assertEqual(35, player.getPlayerScore(), "check for score ")
        
        player2 = Player("Dave", 100)
        self.assertEqual(100, player2.getPlayerScore(), "check for score")
        
        player3 = Player("Kev", 1000000)
        self.assertEqual(1000000, player3.getPlayerScore(), "check for score")
    
    
        
        