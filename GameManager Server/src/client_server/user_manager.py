from model.user_load import User
class ServiceUserManager:
    def __init__(self):
        
        self._activateUsers = {}
        self._loadingUsers()
        
    def _loadUsers(self):
        userloaded1 = User("Jon Snow")
        userloaded2 = User("Cersei")
        userloaded3 = User("Night King")
        
        self._activateUsers[userloaded1.getPlayerId()] = userloaded1
        self._activateUsers[userloaded2.getPlayerId()] = userloaded2
        self._activateUsers[userloaded3.getPlayerId()] = userloaded3
    
    def createUser(self, username):
        status = ""
        usersId = -1
        message = ""
        try:
            load = User(username)
        except ValueError as err:
            status = "fail"
            message = "%s".format(err)
        else:
            self._activateUsers[load.getPlayerId()] = load
            status = "success"
            usersId = load.getPlayerId
        finally:
            return (status, usersId, message)
