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
        
        
        
        
        