import requests;

url = "http://localhost:8080/contato"

response = requests.get(url)

if response.status_code == 200:
    data = response.json()

    for contato in data:
        print(f"Codigo:{contato['codigo']}, Nome:{contato['nome']}")

else:
    print(f"Erro ao acessar a API:{response.status_code}")