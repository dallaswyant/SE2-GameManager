from unittest import TestCase
from wheel.signatures import assertTrue
from model.game_load import Game
from model.player_load import Player

class TestConstructor(TestCase):
    def testSetValidScoreMultiplePlayers(self):
        player = Player("Kin", 300)
        self.assertEqual(50, player.setPlayerScore(50), "check for score")