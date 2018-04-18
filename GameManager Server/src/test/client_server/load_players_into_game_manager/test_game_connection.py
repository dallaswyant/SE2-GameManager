from client_server.user_manager import ServiceUserManager
from unittest import TestCase
from client_server import constants

class TestCreateUserManager(TestCase):
    def testUsernameNone(self):
        manager = ServiceUserManager()
        
        statusResult, idResult, messageResult = manager.createUser(None)
        
        self.assertEqual(constants.FAIL_STATUS, statusResult, "checking status")
        self.assertEqual(constants.FAIL_ID, idResult, "checking id")
      
    def testValidUser(self):
        manager = ServiceUserManager()
        statusResult, idResult, messageResult = manager.createUser("Jon")
        
        
        self.assertEqual(constants.SUCCESS_STATUS, statusResult, "checking status")
        self.assertNotEqual(constants.FAIL_ID, idResult, "checking id")
        self.assertEqual(constants.SUCCESS_MESSAGE, messageResult, "checking message")
        