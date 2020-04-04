import requests
import json
url = "http://localhost:8080"
url = url + "/api/city" + "?cityName=温州市"
response = requests.get(url).text
text = json.loads(response)
# <class 'list'> <class 'dict'>
print(type(text),type(text[0]))