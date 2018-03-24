from unittest import TestCase
from model.user_load import User
from model.game_load import Game


class TestConstructor(TestCase):
        
    def testNoneUserUsername(self):
        with self.assertRaises(ValueError):
            User(None)
        
    def testEmptyUserUsername(self):
        with self.assertRaises(ValueError):
            User("")
            
    def testValidUserConstructorDefault(self):
        user = User("Tim")
        self.assertEqual("Tim", user.getUsername(), "check for username")
        self.assertEqual([], user.getCompletedGames(), "check for completed games")
        self.assertEqual([], user.getInProgressGames(), "check for in-progress games")
        self.assertEqual("Default Game Name", user.getCurrentGame().toString(), "check for default games")
    
    def testValidUserConstructorWithGames(self):
        user = User("Tim")
        game1 = Game("InfinityWar", 10)
        game2 = Game("BioWar", 5)
        game3 = Game("StarWar", 12)
        game4 = Game("Puzzles", 1)
        
        inProgressGames = [game2, game3]
        user.setInProgressGames(inProgressGames)
        user.addCompletedGame(game1)
        user.setCurrentGame(game4)
        
        self.assertEqual("Tim", user.getUsername(), "check for username")
        self.assertTrue(user.getCompletedGames().__contains__(game1), "check for completed game1")
        self.assertTrue(user.getInProgressGames().__contains__(game2), "check for containing game2 in progress")
        self.assertTrue(user.getInProgressGames().__contains__(game3), "check for game 3 in progress")
        self.assertEqual("Puzzles", user.getCurrentGame().toString(), "check for Puzzles games")
        
        
    
        