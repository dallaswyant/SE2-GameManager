from unittest import TestCase
from model.user_load import User
from model.game_load import Game


class TestAddInProgressGame(TestCase):
        
    def testNoneAddInProgress(self):
        user = User("Neo")
        with self.assertRaises(ValueError):
            user.addCompletedGame(None)
        
    def testAddInProgressGameAlreadyInCompleteGameList(self):
        user = User("Tim")
        game = Game("BioWar", 35)
        game2 = Game("Drue", 10)
        inProgres = [game, game2]
        user._inProgress = inProgres
        
        user.addInProgressGame(game)
        self.assertTrue(user._inProgress.__contains__(game), "check contains")
    
    def testInProgressGames(self):
        user = User("Tim")
        game = Game("BioWar", 35)
        game2 = Game("Drue", 10)
        
        user.addInProgressGame(game)
        user.addInProgressGame(game2)
        
        self.assertEqual(2, len(user._inProgress), "check for completed games added")
       
    def testAddInProgressFromCompleteGameList(self):
        
        user = User("Tim")
        game1 = Game("InfinityWar", 10)
        game2 = Game("BioWar", 5)
        game3 = Game("StarWar", 12)
        game4 = Game("Puzzles", 1)
        
        complete = [game2, game3]
        user._completedGames = complete
        user.addInProgressGame(game3)
        self.assertFalse(user._completedGames.__contains__(game3), "check for game2 removed from inProgress")
        self.assertEqual(1, len(user._inProgress), "check for size")
               
        
        
    
        