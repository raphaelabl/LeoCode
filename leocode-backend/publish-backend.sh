mvn clean package -DskipTests
docker build -f src/main/docker/Dockerfile.jvm -t ghcr.io/musikfreunde/leocode-backend:27.0 .
docker push ghcr.io/musikfreunde/leocode-backend:27.0