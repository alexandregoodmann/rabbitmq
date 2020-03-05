sudo docker-compose down

sudo docker rm $(sudo docker ps -aq)

sudo docker rmi $(sudo docker images -aq)

sudo docker-compose up
