docker-compose down
docker rm -f $(docker ps -aq )
docker rmi consumer-rabbitmq_consumer 

mvn clean install
docker-compose up