# DEMO Chaos Monkey for Spring Boot

This is a demo using Chaos Monkey for Spring Boot to demonstrate chaos engineering at the app level.

The provided `docker-compose` will start Prometheus and Grafana to observe what's happening when failures and exceptions are injected into the app.

This demo was originally used at GrafanaCon LA 2019, various JUGs and Enterprise demos.  

## Requirements
* Docker
* Docker Compose

## Run the demo 

### 1. Start docker-compose

Docker  will start containers for Redis, Prometheus, Grafana, Locust and the 2 Spring Boot applications.

```shell
cd script
./start-containers.sh
``` 

### 2. Verify that the containers are running
* Prometheus is running at [http://localhost:9090](http://localhost:9090) 
* Grafana is running  at [http://localhost:3000](http://localhost:3000)
* Locust is running at [http://localhost:8089](http://localhost:8089)

### 3. Import the Grafana Dashboard

You need to import manually the dashboard.

Log in to Grafana (admin/admin) and go to Dashboards -> Manage -> Import page. Then upload the JSON file located in the `/docker/grafana/dashboards` folder of this project.

The Prometheus Datasource is set up automatically.


### 4. Simulate user traffic

Open the [Locust Dashboard](http://localhost:8089), add 50 users and click on the `Start swarming` button.

### 5. Run an experiment

#### 5.1 Enable Chaos Monkey

```shell
./enable-cmsb.sh
``` 

#### 5.2 Set the assault
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

#### 5.3 Check Grafana Dashboard


#### 5.4 Fix and restart

Update the code and restart the client

```shell
./restart-client.sh
``` 

#### 5.4 Check Grafana Dashboard


### 6. Stop everything

Run the following script to stop and clean up all the containers.

```shell
./stop-containers.sh
``` 

Thanks to the [Open Beer Database](https://data.opendatasoft.com/explore/dataset/open-beer-database%40public-us/table/) for providing a great list of beers.  
