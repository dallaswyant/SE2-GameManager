from unittest import TestCase
from model.game_load import Game
from model.player_load import Player


class TestConstructor(TestCase):
    def testGameNameNone(self):
        with self.assertRaises(ValueError):
            game = Game(None, 3)
            game.toString()
    
    def testGameNameEmpty(self):
        with self.assertRaises(ValueError):
            game = Game("", 3)
            game.toString()
    
    def testGameIncrementEmpty(self):
        with self.assertRaises(ValueError):
            game = Game("Game1", "")
            game.getPointsIncrementValue()
    
    def testGameIncrementAtZero(self):
        with self.assertRaises(ValueError):
            game = Game("Game1", 0)
            game.getPointsIncrementValue()  
    
    def testGameIncrementBelowOne(self):
        with self.assertRaises(ValueError):
            game = Game("Game1", -5)
            game.getPointsIncrementValue()
            
    def  testGameName(self):
        game = Game("Game0", 3)
        self.assertEqual("Game0", game.toString(), "check for name")
    
    def testGameNameNotEqual(self):
        game = Game("Game1.5", 8)
        self.assertIsNot("Game0", game.toString(),"check Game0 is not Game1.5")
        
    def testGameIncremenetAboveOne(self):
        game = Game("Game1", 3)
        self.assertEqual(3, game.getPointsIncrementValue(), "check increment")
    
    def testGameIncremenetAtOne(self):
        game = Game("Game1", 1)
        self.assertEqual(1, game.getPointsIncrementValue(), "check for increment at 1") 
    
    def testGamePlayerSizeZeroPlayersEmptyList(self):
        game = Game("Infinity", 2)
        self.assertEqual([], game.getPlayers(), "check for 0 players")
    
    def testGamePlayerSizeWithPlayerObjectSize(self):
        game = Game("Project", 2)
        player = Player("APlayer", 40)
        
        game.addPlayer(player)
        self.assertTrue(player in game.getPlayers(), "check for player")
        
    def testGamePlayerSizeZeroPlayers(self):
        game = Game("Infinity", 2)
        self.assertEqual(0, game.getNumberOfPlayers(), "check for 0 players")   
   
    def testGamePlayerSizeOnePlayer(self):
        game = Game("Game3", 6)
        player = Player("Dobbins", 12)
        game.addPlayer(player)
        self.assertEqual(1,game.getNumberOfPlayers(), "check for 1 player")
    
    def testGamePlayerSizeMultiplePlayers(self):
        game = Game("Game3", 6)
        player = Player("Dobbins", 12)
        player2 = Player("Hogwart", 8)
        player3 = Player("Tiffany", 2)
        
        game.addPlayer(player)
        game.addPlayer(player2)
        game.addPlayer(player3)
        self.assertEqual(3,game.getNumberOfPlayers(), "check for 1 player")
    
    def testGameSetToDefaultStatus(self):
        game = Game("Game1", 4)
        self.assertFalse(game.getCompletedStatus(), "check for Status default")
    
            
  