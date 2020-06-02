import time
import json
import requests

user = {
    "username": "mikes",
    "password": "pass"
}

productType = {
    "type": "Product type 1"
}

product = {
	"name":"product name",
	"description":"descr",
	"imageUrl":"imageurl",
	"productTypeId":"1",
	"price":"12.4"
}
soldsensoruser = {
    "product": {
        "id": "1"
    },
    "register": "0",
    "user": {
        "id": 1
    }
}
sensorlocation = {
	"lat":"23.14",
	"lon":"41.6"
}
pm = {
    "pm1": "23.666",
    "pm25": "1.45",
    "timestamp": "2020-06-02T00:06:44.186+0000"
}

class Request:
    def __init__(self, endpoint, dict):
        self.endpoint="http://localhost:8080"+endpoint
        self.dict = dict
    def post(self):
        response = requests.post(self.endpoint, json=self.dict)
        print("Status code: ", response.status_code)
        print("Printing Entire Post Request")
        print(json.dumps(response.json(),indent=4, sort_keys=False))

Request("/register",user).post()
Request("/producttype",productType).post()
Request("/products",product).post()
Request("/soldsensoruser",soldsensoruser).post()
Request("/sensor/sensorlocation",sensorlocation).post()
Request("/pm/1",pm).post()

# post_json(productType)
# post_json(product)
# post_json(soldsensoruser)
# post_json(sensorlocation)

# start = time.time()
# for i in range(1000):
#     requests.post('http://localhost:8080/pm/1', json=pm)
# print(time.time()-start)
