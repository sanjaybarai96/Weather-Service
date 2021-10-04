# Weather-Service

Payload

1) To get current weather info
url: http://localhost:8080/weather?cityName=Mumbai
method:GET
Response:{
    "data": {
        "lon": 72.8479,
        "weatherInfo": [
            {
                "date": "2021-10-04",
                "dateTime": 1633329000,
                "maxTemp": 32.99,
                "description": "light rain",
                "minTemp": 27.42
            }
        ],
        "lat": 19.0144
    },
    "status": true
}

2)To get weather info for 3 days
url: http://localhost:8080/weather/forecast?cityName=Bomdila
method: GET
Response: {
    "data": {
        "lon": 92.4,
        "weatherInfo": [
            {
                "date": "2021-10-04",
                "dateTime": 1633325400,
                "maxTemp": 16.63,
                "description": "light rain",
                "minTemp": 11.76
            },
            {
                "date": "2021-10-05",
                "dateTime": 1633411800,
                "maxTemp": 17.19,
                "description": "moderate rain",
                "minTemp": 13.02
            },
            {
                "date": "2021-10-06",
                "dateTime": 1633498200,
                "maxTemp": 18.63,
                "description": "light rain",
                "minTemp": 12.11
            }
        ],
        "lat": 27.25
    },
    "status": true
}