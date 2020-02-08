docker-compose down

docker rmi rabbitmq_consumer

cd consumer-rabbitmq/
mvn clean package -DskipTests=true
cd ..

