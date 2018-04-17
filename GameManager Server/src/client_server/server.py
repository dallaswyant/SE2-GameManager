import zmq
import json
from client_server.user_manager import ServiceUserManager
from client_server import constants

class Server:
        
    def __init__(self):
        self._userManager = ServiceUserManager()
        
        
    def _handleRequest(self, message):
        if (message["op"] == "create user"):
            status, usersId, message = self._userManager.createUser(message["Username"])
            response = {constants.KEY_STATUS:status, constants.KEY_SERVICE_ID:usersId, constants.KEY_MESSAGE:message}
            return response
        if (message["op"] == "get games"):
            return self._userManager.getGames()
    
    def run(self):
        context = zmq.Context()
        socket = context.socket(zmq.REP)
        socket.bind(constants.SERVER_LOCATION)
        
        request = json.loads(socket.recv_string())
        while request != "exit":
            response = self._handleRequest(request)
            socket.send_string(json.dumps(response))
            request = json.loads(socket.recv_string())
        
if(__name__ == "__main__"):
    Server().run()