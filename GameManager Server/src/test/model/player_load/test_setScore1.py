from unittest import TestCase
#from wheel.signatures import assertTrue
#^couldn't get this import to work on my machine, not sure if needed
from model.game_load import Game
from model.player_load import Player

class TestConstructor(TestCase):
    def testSetValidScoreMultiplePlayers(self):
        player = Player("Kin", 300)
        player.setPlayerScore(50)
        self.assertEqual(50, player.getPlayerScore(), "check for score")