# Devops Pragma Practica
Aplicativo encargado de realizar CRUD de particpantes expuesto en un API Rest.

# Tecnologias usadas
* SpringBoot 2.1.4.RELEASE
* Swagger 2.7.0
* Jacoco 0.8.3
* Maven 4.0.0
* Java 1.8
* SonarQube 2.4
* Docker


## Prerequisitos
* Ambiente desarrollo:
```
Instalacion de Docker 
```
```
Importar el proyecto como un maven project
```
```
Ir al paquete src/main/resources y poner la ruta de data source segun se requiera
```

## Instalación

crear variable de entorno de nombre HOST
```
HOST = 'valor sera el host que aloja la base de datos'
```
```
Importar proyecto a IDE de preferencia
```
Si se desea cambiar el "profile (dev, prod)" se debe cambiar en el .yml
```
spring:
  profiles:
    active: prod ó dev
```
Ubicarse en la carpeta raiz del proyecto y ejecutar el siguiente comando por consola

```
mvn install
```
```
agregar el .jar generado a la carpeta raiz donde se va  ejecutar el DockerFile
```
## Ejecución

Para ejecucion sin Docker con el respectivo "profile" (prod, dev), 
ubicado en la carpeta target del proyecto lanzar el comando
```
$java -jar -Dspring.profiles.active=[profile] kudoDevOps-0.0.1-SNAPSHOT.jar
```
Para ejecucion con Docker
```
Ubicarse en la carpeta donde esta ubicado el DockerFile
```
```
Para crear la imagen correr por consola el comando docker build -t kudoimage .
```
Para crear el contenedor e iniciarlo correr por consola el comando 
```
docker run -it -p 8090:8090 --name kudoapp kudoimage
```
## Guia pruebas unitarias usando Mocks

[Guia Mocks](https://drive.google.com/open?id=12XvWdjHzYEiFR9Ezb6YFfu2ztcxZGYoi)
