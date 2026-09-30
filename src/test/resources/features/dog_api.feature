# language: pt
Funcionalidade: Validação dos endpoints da Dog API

  Contexto:
    Dado que a URL base da Dog API é "https://dog.ceo/api"

  Cenário: Validar a lista de todas as raças
    Quando eu faço uma requisição GET para "/breeds/list/all"
    Então o código de status da resposta deve ser 200
    Então o status da API deve ser "success"
    Então a resposta deve conter uma lista não vazia em "message.hound"

  Cenário: Validar imagens por raça conhecida "hound"
    Quando eu faço uma requisição GET para "/breed/hound/images"
    Então o código de status da resposta deve ser 200
    Então o status da API deve ser "success"
    Então a resposta deve conter uma lista não vazia em "message"

  Cenário: Validar imagem aleatória
    Quando eu faço uma requisição GET para "/breeds/image/random"
    Então o código de status da resposta deve ser 200
    Então o status da API deve ser "success"
    Então a mensagem da resposta deve ser uma URL de imagem válida
