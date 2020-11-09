## Tech Stack

  * Java 8
  * Spring Boot 2.3.3
  * JUnit 4.12
  * Mockito 2.23
  * Lombok
  * Swagger 2.7.0 (Useful for REST API test)
  * Apache Maven 3.6.3
  * Spring Data JPA
  * PostgreSQL
  * Docker version 19.03.13

## Running the application

Docker Images (TAG - springbootapp & TAG - postgres): 

```bash
https://hub.docker.com/r/vikramk1612/zoomanagement
```
Pull docker image: 

```bash
docker pull
```
To compose container (docker-compose.yml file present on project workspace ): 

```bash
docker-compose up
```

To start application (Post 9081 & DB 5432): 

```bash
http://localhost:9081/swagger-ui.html#
```
## Testing

```bash
mvnw clean test
```
# API Documentation

Swagger2 documentation is available.

```
http://localhost:9081/swagger-ui.html#
```

## Java Documentation

```
zooAssessmentEurail/doc/index.html
```

## Improvements to make
```
- Maven can be replaced with Gradle.
- DB queries performance can be optimise with index.
- Swagger not used fully.
- Test classes for Room Entity
- Lombok use may be improved.
- Constants and enum to improve readability.
- Validator can be improve for Java beans, input and dto.
```
