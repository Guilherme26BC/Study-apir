# Study APIr
API Java para estudo de Spring boot

## Client DataBase

## MER
![Imagem_MER](assets/images/img.png)
## Docker

120.0.0.1 = localhost
```
docker pull ubuntu
docker images
docker pull debian
docker run ubuntu
docker run -it ubuntu
docker ps -a
docker ps
docker rm f4d759ee0b78
```

* Repositório Docker Hub

```
hub.docker.com
```
## Instalação

## Variaveis de ambiente
```
export DB_USER=root
export DB_PASSWORD=root_pwd
export DB_SERVER=localhost
export DB_PORT=3306
export DB_DATABASE=devdv
```

## .env
```
cat .env
export $(cat .env | xargs)
```

- Limpar e criar a pasta _/target_
```
mvn clean package
```

- Executar um JAR em /target
```
java -jar target/study-apir-0.0.1-SNAPSHOT.jar
java -jar -Dspring.profiles.active=dev target/study-apir-0.0.1-SNAPSHOT.jar 
java -jar -Dspring.profiles.active=prod target/study-apir-0.0.1-SNAPSHOT.jar 
```

*Configuração do Swagger

    - https://springdoc.org/properties

- application.properties

```
springdoc.swagger-ui.path=/
server.port=9000
```

## Navegação

### Executar a API
-   Executando o __Maven__

```   
mvn spring-boot:run
mvn spring-boot:run -Dspring-boot.run.profiles=dev
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

### Documentação da API (Swagger)
- http://localhost:8080/swagger-ui.html

## Referências
-   https://springdoc.org/
- 

