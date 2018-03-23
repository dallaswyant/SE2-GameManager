from unittest import TestCase
#from wheel.signatures import assertTrue
#^couldn't get this import to work on my machine, not sure if needed
from model.game_load import Game
from model.player_load import Player

class TestToString(TestCase):
    def testValidToString(self):
        player = Player("Kin", 300)
        player2 = Player("Jim", -40)
        player3 = Player("Fin", 0)
        player4 = Player("Rin", 1)
        
        result1 = player.getPlayerName() + " " + str(player.getPlayerScore()) + "pts"
        result2 = player2.getPlayerName() + " " + str(player2.getPlayerScore()) + "pts"
        result3 = player3.getPlayerName() + " " + str(player3.getPlayerScore()) + "pts"
        result4 = player4.getPlayerName() + " " + str(player4.getPlayerScore()) + "pts"
        
        self.assertEqual(result1, player.toString(), "check for toString")
        self.assertEqual(result2, player2.toString(), "check for toString")
        self.assertEqual(result3, player3.toString(), "check for toString")
        self.assertEqual(result4, player4.toString(), "check for toString")
        
    