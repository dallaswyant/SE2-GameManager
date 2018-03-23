from unittest import TestCase
from wheel.signatures import assertTrue

class TestSetUsername(TestCase):
    
    def testAddNoneUsername(self):
        user = User("Eddie Murphy")
   
        with self.assertRaises(ValueError):
           user.setUsername(None)
    
    def testAddNoneUsername(self):
        user = User("Eddie Murphy")
   
        with self.assertRaises(ValueError):
           user.setUsername("")
    
    def testValidSetUsername(self):
        user = User("Seth Rogen")
        user.setUsername("Tim Murphy")
        self.assertTrue("Tim Murphy", user.getUsername, "checking for same name")
    
    def testSetUsernameWithNumbers(self):
         user = User("Seth Rogen")
         user.setUsername("1Tim2 Murphy3")
         self.assertTrue("1Tim2 Murphy3", user.getUsername, "checking for same name")
    
        
        

