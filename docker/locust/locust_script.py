import time
from locust import HttpUser, TaskSet, task

class start(HttpUser):
    min_wait = 5000
    max_wait = 9000

    @task
    def beer_list(self):
        self.client.get("/beers")
