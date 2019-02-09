User service



Requirements
* Java 8+ (The default is current using Java 11)
* Docker (You can run your own Redis)
* Lombok - I use Lombok in this example to eliminate the boilerplate code for constructors and so-called "data class" methods (accessors/mutators, equals(), toString(), & hashCode())




Run Redis
```
   sudo docker-compose up
``` 

Run Prometheus
```
   docker run redis
``` 


Run Grafana
```
   docker run redis
``` 




Run the app
```
   mvn springBoot:run
``` 


http://localhost:8080/actuator/prometheus

http://localhost:8500/ui