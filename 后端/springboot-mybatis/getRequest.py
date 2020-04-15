import requests
import json
if __name__ == '__main__':
    url = "http://localhost:8002"
    url = url + "/api/logs"
    response = requests.get(url).text
    text = json.loads(response)
    # <class 'list'> <class 'dict'>
    print(type(text),type(text[0]))
    print(text)