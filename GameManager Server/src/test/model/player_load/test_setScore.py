from unittest import TestCase
#from wheel.signatures import assertTrue
#^couldn't get this import to work on my machine, not sure if needed
from model.game_load import Game
from model.player_load import Player

class TestConstructor(TestCase):
    def testSetValidScoreMultiplePlayers(self):
        player = Player("Kin", 300)
        player2 = Player("Jim", -40)
        player3 = Player("Fin", 0)
        player4 = Player("Rin", 1)
        
        
        player.setPlayerScore(50)
        player2.setPlayerScore(-5)
        player3.setPlayerScore(100)
        player4.setPlayerScore(0)
        self.assertEqual(50, player.getPlayerScore(), "check for score")
        self.assertEqual(-5, player2.getPlayerScore(), "check for score")
        self.assertEqual(100, player3.getPlayerScore(), "check for score")
        self.assertEqual(0, player4.getPlayerScore(), "check for score")