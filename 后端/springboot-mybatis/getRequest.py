import requests
import json
if __name__ == '__main__':
    url = "http://localhost:8081"
    url = url + "/api/city" + "?cityName=温岭市"
    response = requests.get(url).text
    text = json.loads(response)
    # <class 'list'> <class 'dict'>
    print(type(text),type(text[0]))
    print(text)