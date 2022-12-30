# build image microservices-teams from Docker file

mvn clean install

docker build -f Dockerfile -t azizzakiryarov/microservices-teams:latest .

docker push azizzakiryarov/microservices-teams:latest