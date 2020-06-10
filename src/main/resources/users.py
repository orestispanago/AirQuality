import requests
import json

user1 = {
    "username": "Mikes",
    "password": "pass"
}

user2 = {
    "username": "Asimakaros",
    "password": "pass"
}
class Request:
    def __init__(self, endpoint,object):
        self.endpoint="http://localhost:8080"+endpoint
        self.object = object
    def post(self):
        # print(json.dumps(self.object.__dict__))
        response = requests.post(self.endpoint, json=self.object.__dict__)
        print("Status code: ", response.status_code)
        print("Printing Entire Post Request")
        print(json.dumps(response.json(),indent=4, sort_keys=False))

class User:
    def __init__(self,username, password):
        self.username = username
        self.password = password
    def post(self):
        Request("/register",self).post()

user3 = User("Mikeroumbas","pass").post()
# Request("/register",user3).post()
