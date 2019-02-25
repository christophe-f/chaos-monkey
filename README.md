# DEMO Chaos Monkey for Spring Boot

This is a demo for GrafanaCon LA 2019 

## Requirements
* Java 8+
* Docker & Docker Compose
* Lombok (if you are running in an IDE)

## Run the demo 

### Start docker compose

Docker compose will start locally a Consul, Redis, Prometheus & Grafana instances

```
   sudo docker-compose up
``` 

### Run the client & beer service apps
```
   ./start-apps.sh
``` 

## Check that everything is running fine
* [Consul](http://localhost:8500/ui)
* [Prometheus](http://localhost:9090/service-discovery)
* [Grafana](http://localhost:3000)

## Import the Grafana Dashboard
Login to Grafana and go to Dashboards -> Manage -> Import page. Then import the dashboard ID `9845` or the JSON located in the Grafana folder of this project.


## Run an experiment

### Enable Chaos Monkey
```
    curl -X POST http://localhost:8081/actuator/chaosmonkey/enable
```

### Set the assault
```
    curl -X POST \
      http://localhost:8081/actuator/chaosmonkey/assaults \
      -H 'Content-Type: application/json' \
      -d ' {
        "level": 10,
        "latency_range_start": 2000,
        "latency_range_end": 5000,
        "latency_active": false,
        "exceptions_active": false
        }'
```


Thanks to the [Open Beer Database](https://data.opendatasoft.com/explore/dataset/open-beer-database%40public-us/table/) for providing a great list of beers.  
