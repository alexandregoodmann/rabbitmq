docker-compose down

docker rmi rabbitmq_consumer
docker rmi rabbitmq_publisher

cd consumer-rabbitmq/
mvn clean package -DskipTests=true
cd ..

cd publisher-rabbitmq/
mvn clean package -DskipTests=true
cd ..

docker-compose up