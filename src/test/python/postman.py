import json
import requests
import random
import time
from jsons import user, productType, product, soldsensoruser, sensorlocations

class Request:
    def __init__(self, endpoint, dict):
        self.endpoint="http://localhost:8080"+endpoint
        self.dict = dict
    def post(self):
        response = requests.post(self.endpoint, json=self.dict)
        print("Status code: ", response.status_code)
        # print("Printing Entire Post Request")
        # print(json.dumps(response.json(),indent=4, sort_keys=False))

def post_chain():
    Request("/register",user).post()
    Request("/product-types",productType).post()
    Request("/products",product).post()
    for i in range(1, (len(sensorlocations)+1)):
        Request("/soldsensoruser",soldsensoruser).post()
    for j in sensorlocations:
        Request("/sensorlocation",j).post()

def random_measurement(sensorLocationId):
    pm = {
        "sensorLocation":{
        "id":sensorLocationId,
            "soldSensor":{
                "id":sensorLocationId,
                    "user": {
                        "id": 1
                    }
            },
        },
        "pm1": sensorLocationId+12+random.uniform(2, 5),
        "pm25": sensorLocationId+3+random.uniform(2, 7)
    }
    print(pm.get("sensorLocation").get("id"),pm.get("pm1"), pm.get("pm25"))
    return pm


try:
    post_chain()
    for i in range(1000):
        for sensorLocationId in range(1, (len(sensorlocations)+1)):
            Request("/pm",random_measurement(sensorLocationId)).post()
        time.sleep(3)

except KeyboardInterrupt:
    print("\nExiting nicely...")
