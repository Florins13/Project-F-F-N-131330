mvn clean package

docker build -t springio/gs-spring-boot-docker .

docker run -p 9090:8000 springio/gs-spring-boot-docker