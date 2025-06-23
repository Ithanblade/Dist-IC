import requests

ELASTIC_URL = "http://localhost:9200"
INDEX_NAME = "estudiantes"

query = {
    "query": {
        "match": {
            "carrera": "Psicología"
        }
    }
}

res = requests.get(f"{ELASTIC_URL}/{INDEX_NAME}/_search", json=query)
print(res.json())
