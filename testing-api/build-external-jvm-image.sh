rm -rf target
mvn -Dquarkus.package.type=uber-jar -DskipTests verify
docker build -t ghcr.io/musikfreunde/testing-api:31.0 .
