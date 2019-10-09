git clone https://github.com/Binarysearch/piros.git &&

cd piros &&

mvn install &&

cd .. &&

rm -R -f ./piros/ &&

mvn clean compile &&

(docker network create --attachable develop_network || true ) &&

(docker container rm postgres-database -f || true) &&
docker build --rm -f ./postgres/Dockerfile -t postgres-database:latest . &&
docker run -d -p 5432:5432 --name=postgres-database --network=develop_network --network-alias=db postgres-database:latest &&

(docker container rm tomcat-server -f || true) &&
docker build --build-arg api_version_arg=dev --rm -f Dockerfile -t tomcat-server:latest . &&
docker run -p 8080:8080 --name=tomcat-server --network=develop_network tomcat-server:latest
