""" dictionaries can be used in postmap application"""

user = {
    "username": "mikes",
    "password": "pass"
}

productType = {
    "type": "Product type 1"
}

product = {
    "name": "Carbon monoxide sensor CO1000",
    "description": "Give your next sensor project a nose for gasses with the Adafruit MiCS-5524 Gas Sensor Breakout. This breakout makes it easy to use this nice sensor from SGX Sensortech. The MiCS-5524 is a robust MEMS sensor for indoor carbon monoxide and natural gas leakage detection, it's suitable also for indoor air quality monitoring; breath checker and early fire detection.;Please note: This sensor is sensitive to CO ( ~ 1 to 1000 ppm), Ammonia (~ 1 to 500 ppm), Ethanol (~ 10 to 500 ppm), H2 (~ 1 - 1000 ppm), and Methane / Propane / Iso-Butane (~ 1,000++ ppm). However, it can't tell you which gas it has detected.;This breakout board is not for any safety, medical or finished product usage. We're selling it for hobby education & experimentation and don't guarantee it for any other purpose! All gas sensors require calibration for precision output.;Using it is easy: Power it with 5 VDC and read the analog voltage off of the output pin. When gasses are detected, the analog voltage will increase in proportion of detected gas. When powered, the heater draws about 25-35mA. You can use the EN pin to power it off (pull it high to 5V to turn off) to conserve energy. Just make sure to wait a second after turning the heater on to make sure its all heated before taking readings.;Each order comes with one assembled and tested MiCS-5524 breakout and a bit of header. You'll need to do some light soldering to attach the header on - or you can use just plain wires.",
    "technicalDetails":"Range of measurement: 0.3 to 1.0, 1.0 to 2.5, 2.5 to 10 μm;Effective Range: 0 to 500 μg/m3;Maximum Range: ≥1000 μg/m3;Resolution: 1 μg/m3;Standard Volume: 0.1L;DC Power Supply: Typ:5.0 / Min:4.5 / Max: 5.5V;Active Current: ≤100 mA;Standby Current: ≤200 μA;Working Temperature Range: -10 to +60 ℃;Working Humidity Range: 0 to 99%;Storage Temperature Range: -40 to +80 ℃;Sensor Module Dimensions: 50 x 38 x 21mm;Weight (incl. cable and adapter): 42.2g;",
    "imageUrl": "https://www.fondriest.com/media/catalog/product/cache/ae8a6bc677e17d25017855202e90e7e0/r/m/rm_young_43502_lg.jpg",
    "manualUrl":"https://cdn-shop.adafruit.com/product-files/3686/plantower-pms5003-manual_v2-3.pdf",
    "productType": {
        "id": 1
    },
    "price": "249.99"
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
sensorlocations = [
{
    "soldSensor":{
        "id":1,
            "user": {
                "id": 1
            }
    },
	"lat":"37.985965",
	"lon":"23.734634"
}
,
{
    "soldSensor":{
        "id":2,
            "user": {
                "id": 1
            }
    },
	"lat":"37.980071",
	"lon":"23.733279"
}
,
{
    "soldSensor":{
        "id":3,
            "user": {
                "id": 1
            }
    },
	"lat":"37.980207",
	"lon":"23.740622"
}
,
{
    "soldSensor":{
        "id":4,
            "user": {
                "id": 1
            }
    },
	"lat":"37.974828",
	"lon":"23.735554"
}
,
{
    "soldSensor":{
        "id":5,
            "user": {
                "id": 1
            }
    },
	"lat":"37.975263",
	"lon":"23.732132"
}
,
{
    "soldSensor":{
        "id":6,
            "user": {
                "id": 1
            }
    },
	"lat":"37.972637",
	"lon":"23.730599"
}
,
{
    "soldSensor":{
        "id":7,
            "user": {
                "id": 1
            }
    },
	"lat":"37.971030",
	"lon":"23.748937"
}
,
{
    "soldSensor":{
        "id":8,
            "user": {
                "id": 1
            }
    },
	"lat":"38.013003",
	"lon":"23.785947"
}
,
{
    "soldSensor":{
        "id":9,
            "user": {
                "id": 1
            }
    },
	"lat":"37.932419",
	"lon":"23.936025"
}
,
{
    "soldSensor":{
        "id":10,
            "user": {
                "id": 1
            }
    },
	"lat":"37.925920",
	"lon":"23.935990"
}
,
{
    "soldSensor":{
        "id":11,
            "user": {
                "id": 1
            }
    },
	"lat":"37.963858",
	"lon":"23.719669"
}
,
{
    "soldSensor":{
        "id":12,
            "user": {
                "id": 1
            }
    },
	"lat":"37.959738",
	"lon":"23.710387"
}
]
pm_measurement = {
    "sensorLocation":{
        "id":1,
            "soldSensor":{
                "id":1,
                    "user": {
                        "id": 1
                    }
            },
    },
    "pm1": "23.666",
    "pm25": "1.45"
}
