#!/bin/bash
set -e #CASO QUALQUER ERRO ELE PARA O SCRIPT (EXIR !=0)

#CRIAR PRODUTOS
HTTP_STATUS=$(curl -X 'POST' \
        'http://localhost:9000/api/v3/produtos' \
        -o produto_create.json \
        -w "%{http_code}"\
        -H 'accept: */*' \
        -H 'Content-Type: application/json' \
        -d '{ "nome": "Uva" }' )
        
echo "Status HTTP POST: $HTTP_STATUS"

if [ "$HTTP_STATUS" -ne 201 ]; then 
    echo "ERRO ao processar dados da API de produtos"
    exit 1 
fi

#LISTAR TODOS OS PRODUTOS
HTTP_STATUS=$(curl -X 'GET' \
                    'http://localhost:9000/api/v3/produtos'\
                        -o product_list.json \
                        -w "%{http_code}" \
                        -H 'accept: */* ')

echo "Status HTTP: $HTTP_STATUS"
if [ "$HTTP_STATUS" -ne 200 ]; then 
    echo "ERRO ao processar dados da API de produtos"
    exit 1 
fi