from unittest import TestCase
from src.model.user_load import User


class TestConstructor(TestCase):
        
    def testNoneUserUsername(self):
        with self.assertRaises(ValueError):
            User(None)
        
    def testEmptyUserUsername(self):
        with self.assertRaises(ValueError):
            User("")
            
    def testValidUserConstructor(self):
        user = User("Tim")
        self.assertEqual("Tim", user.getUsername, "check for name")
        assert not user.getCompletedGames()
        assert not user.getInProgressGames()
        self.assertEqual("Default Game Name", user.getCurrentGame(), "check for default game name")