from unittest import TestCase
from model.user_load import User
from model.game_load import Game


class TestAddCompletedGames(TestCase):
        
    def testNoneUserUsername(self):
        user = User("Tim")
        with self.assertRaises(ValueError):
            user.addCompletedGame(None)
        
    def testEmptyUserUsername(self):
        user = User("Tim")
        game1 = Game("InfinityWar", 10)
        user.addCompletedGame(game1)
        user.addCompletedGame(game1)
        self.assertTrue(user.getCompletedGames().__contains__(game1), "check for same game added")
       
            
            
    def testValidUserConstructorDefault(self):
        user = User("Tim")
        self.assertEqual("Tim", user.getUsername(), "check for username")
        self.assertEqual([], user.getCompletedGames(), "check for completed games")
        self.assertEqual([], user.getInProgressGames(), "check for in-progress games")
        self.assertEqual("Default Game Name", user.getCurrentGame().toString(), "check for default games")
    
    def testValidUserConstructorWithGames(self):
        user = User("Tim")
        game1 = Game("InfinityWar", 10)
        user.addCompletedGame(game1)
        self.assertTrue(user.getCompletedGames().__contains__(game1), "check for added completed game")
        