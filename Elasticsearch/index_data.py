import requests

ELASTIC_URL = "http://localhost:9200"
INDEX_NAME = "estudiantes"

docs = [
    {"nombre": "Juan Pérez", "edad": 20, "carrera": "Ingeniería Informática"},
    {"nombre": "María Gómez", "edad": 22, "carrera": "Medicina"},
    {"nombre": "Luis Rodríguez", "edad": 19, "carrera": "Derecho"},
    {"nombre": "Ana Martínez", "edad": 21, "carrera": "Arquitectura"},
    {"nombre": "Carlos Sánchez", "edad": 23, "carrera": "Economía"},
    {"nombre": "Lucía Fernández", "edad": 20, "carrera": "Psicología"},
    {"nombre": "Pedro Ramírez", "edad": 24, "carrera": "Administración"},
    {"nombre": "Sofía Torres", "edad": 22, "carrera": "Biología"},
    {"nombre": "Diego López", "edad": 21, "carrera": "Ingeniería Civil"},
    {"nombre": "Valentina Ruiz", "edad": 20, "carrera": "Comunicación"}
]

requests.put(f"{ELASTIC_URL}/{INDEX_NAME}")

for i, doc in enumerate(docs):
    res = requests.post(f"{ELASTIC_URL}/{INDEX_NAME}/_doc/{i+1}", json=doc)
    print(res.json())
