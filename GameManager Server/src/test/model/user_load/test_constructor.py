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
            
    def testValidUserConstructorName(self):
        user = User("Tim")
        self.assertEqual("Tim", user.getUsername(), "check for username")
        
        
        
        