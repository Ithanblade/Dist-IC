import requests

url = 'http://localhost:8080/'

fake_ips = [
    '192.168.3.101',
    '192.168.3.101',
    '192.168.8.102',
    '192.168.7.103',
    '192.168.9.104',
    '192.168.7.103',
    '192.168.8.102',
]

for ip in fake_ips:
    headers = {
        'X-Forwarded-For': ip
    }
    response = requests.get(url, headers=headers)
    print(f'IP simulada: {ip} -> Respuesta: {response.text}')
