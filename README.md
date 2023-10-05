# codegame

Requisitos tener instalado docker con docker compose

git clone https://github.com/alfredjava/codegame.git

```bash 
## Ejecutar dentro de la carpeta codegame
git clean install
```
## Ejecutar dentro de la carpeta codegame
```bash
docker-compose up -d
```
Lenvantara primer microservicio account
```bash
mvn spring-boot:run -pl account
```
Lenvantara segundo microservicio client
```bash
mvn spring-boot:run -pl client
```

## Ejecutar pruebas postman
[devsu.postman_collection.json](devsu.postman_collection.json)
