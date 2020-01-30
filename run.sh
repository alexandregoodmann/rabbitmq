cd consumer-rabbitmq/
mvn clean package -DskipTests=true
cd ..

cd publisher-rabbitmq/
mvn clean package -DskipTests=true
cd ..

docker-compose up