from unittest import TestCase
from model.user_load import User
from model.game_load import Game


class TestAddInProgressGame(TestCase):
        
    def testNoneAddInProgress(self):
        user = User("Neo")
        with self.assertRaises(ValueError):
            user.addCompletedGame(None)
        
    def testAddCompleteGameAlreadyInCompleteGameList(self):
        user = User("Tim")
        game = Game("BioWar", 35)
        game2 = Game("Drue", 10)
        completed = [game, game2]
        user._completedGames = completed
        
        user.addCompletedGame(game)
        self.assertTrue(user._completedGames.__contains__(game), "check contains")
    
    def testAddCompleteGames(self):
        user = User("Tim")
        game = Game("BioWar", 35)
        game2 = Game("Drue", 10)
        
        user.addCompletedGame(game)
        user.addCompletedGame(game2)
        
        self.assertEqual(2, len(user._completedGames), "check for completed games added")
       
    def testAddCompleteGameToCompleteFromInProgressList(self):
        
        user = User("Tim")
        game1 = Game("InfinityWar", 10)
        game2 = Game("BioWar", 5)
        game3 = Game("StarWar", 12)
        game4 = Game("Puzzles", 1)
        
        inProgressGames = [game2, game3]
        user._inProgress = inProgressGames
        user.addCompletedGame(game2)
        self.assertFalse(user._inProgress.__contains__(game2), "check for game2 removed from inProgress")
        self.assertEqual(1, len(user._completedGames), "check for size")
               
        
        
    
        