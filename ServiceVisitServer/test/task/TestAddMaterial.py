'''
Created on Feb 13, 2018

@author: Dallas Wyant
'''
from unittest import TestCase
from model.task import Task

class TestAddMaterial(TestCase):
    def setup(self):
        pass
    def tearDown(self):
        pass
    def testValidMaterial(self):
        task = Task();
        task.addMaterial("splitter")
        self.assertEqual("splitter",task.getMaterials()[0], "checking material was added")
        