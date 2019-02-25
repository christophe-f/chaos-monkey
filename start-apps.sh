echo "Starting the beer service"
cd beer-service
./mvnw spring-boot:run &

echo "Starting the client service"
cd ../client-service
./mvnw spring-boot:run &