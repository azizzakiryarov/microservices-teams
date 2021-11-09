# build image microservices-teams from Docker file

mvn clean install

docker build -f Dockerfile -t azizzakiryarov/microservices-teams:latest .

docker push azizzakiryarov/microservices-teams:latest

kubectl delete deployment.apps/microservices-teams-deployment service/microservices-teams

kubectl apply -f /Users/azizzakiryarov/IdeaProjects/microservices-teams/k8s/base/microservices-teams/deployment.yaml

kubectl apply -f /Users/azizzakiryarov/IdeaProjects/microservices-teams/k8s/base/microservices-teams/service.yaml