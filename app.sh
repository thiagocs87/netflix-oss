#!/bin/bash
clear
echo "SUBINDO APLICAÇÃO CLICKBUS - TESTE DESENVOLVEDOR BACKEND - THIAGO SANTOS"
echo "************************************************************************"
docker-compose down
docker-compose build --no-cache
docker-compose up -d
echo "************************************************************************"
echo "****************AGUARDANDO SERVIÇO DO MYSQL SUBIR**********************"
sleep 20
./mvnw clean package install
docker cp clickbus-application/target/clickbus-application-1.0-SNAPSHOT.jar clickbus_rest_api:/opt/app/clickbus-application-1.0-SNAPSHOT.jar
echo "************************************************************************"
echo "***********************SUBINDO APLICAÇÃO********************************"
docker exec -d clickbus_rest_api java -Dspring.profiles.active=prod -jar /opt/app/clickbus-application-1.0-SNAPSHOT.jar
sleep 20
echo "************************************************************************"
echo "*****APLICAÇÃO DISPONÍVEL EM http://localhost:8080/swagger-ui.html******"
echo "********************AGORA É SÓ TESTAR :) *******************************"
echo "************************************************************************"
