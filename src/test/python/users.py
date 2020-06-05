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


class User:
    def __init__(self,username,password):
        self.username = username
        self.password = password
    def post(self):
        headers = {'Content-type': 'application/json', 'Accept': 'text/plain'}
        jsonData = json.dumps(self.__dict__)
        response = requests.post("http://localhost:8080/register", json=jsonData, headers=headers)
        print("Status code: ", response.status_code)
        print("Printing Entire Post Request")
        print(json.dumps(response.json(),indent=4, sort_keys=False))


class Request:
    def __init__(self, endpoint, object):
        self.endpoint="http://localhost:8080"+endpoint
        self.object = object
    def post(self):
        print(json.dumps(self.object.__dict__))
        response = requests.post(self.endpoint, json=json.dumps(self.object.__dict__))
        print("Status code: ", response.status_code)
        print("Printing Entire Post Request")
        print(json.dumps(response.json(),indent=4, sort_keys=False))

user1 = User("Mikes","pass")
# Request("/register",user1).post()
user1.post()
