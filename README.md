## Create and Deploy Spring Boot Todo App to Google Cloud Run
Spring Boot Todo App to deploy Google Cloud Run


### Requirements
- PostgreSQL database

### How to run
1. `export SPRING_DATASOURCE_URL=...` The format should be `jdbc:postgresql://<host>:<port>/<db>`. You can easily create PostgreSQL database for free [here](https://rapidapp.io)
2. `export SPRING_DATASOURCE_USERNAME=...`
1. `export SPRING_DATASOURCE_PASSWORD=...`
2. `gcloud run deploy ...` Read [article](https://docs.rapidapp.io/blog/create-and-deploy-spring-boot-todo-app-to-google-cloud-run) for more info.