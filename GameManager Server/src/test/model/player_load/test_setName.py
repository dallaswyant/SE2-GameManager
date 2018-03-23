from unittest import TestCase
#from wheel.signatures import assertTrue
#^couldn't get this import to work on my machine, not sure if needed
from model.game_load import Game
from model.player_load import Player

class TestSetName(TestCase):
    def testSetInvalidNoneName(self):
        player = Player("Jun", 49)
        with self.assertRaises(ValueError):
            player.setPlayerName(None)
            
    
    def testSetInvalidEmptyName(self):
        player = Player("Jun", 49)
        with self.assertRaises(ValueError):
            player.setPlayerName("")
            
    def testSetValidNamesMultiplePlayers(self):
        player = Player("Kin", 300)
        player2 = Player("Jim", -40)
        player3 = Player("Fin", 0)
        player4 = Player("Rin", 1)
        
        
        player.setPlayerName("Ken")
        player2.setPlayerName("Jen")
        player3.setPlayerName("Fen")
        player4.setPlayerName("Ren")
        self.assertEqual("Ken", player.getPlayerName(), "check for name")
        self.assertEqual("Jen", player2.getPlayerName(), "check for name")
        self.assertEqual("Fen", player3.getPlayerName(), "check for name")
        self.assertEqual("Ren", player4.getPlayerName(), "check for name")