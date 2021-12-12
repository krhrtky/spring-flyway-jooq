# The sample App implements type safe SQL by JOOQ & DB version control by Flyway

## Setup

1. DB(PostgreSQL)
    ```shell
    $ docker compose up -d
    ```

2. Migration
    ```shell
    $ ./gradlew flywayMigrate
    ```

3. Build DSL
    ```shell
    $ ./gradlew generateJooq
    ```

4. Insert record
   ```shell
   $ docker-compose run --rm postgres psql -h sample-postgres -U postgres
   ```
   ```sql
   INSERT INTO app_user (id) VALUES (uuid_in(md5(random()::text)::cstring));
   ```

## Run App

1. Start web app
   ```shell
   $ ./gradlew bootRun
   ```
   
2. Request
   ```shell
   $ curl http://localhost:8080
   # id's value
   ```
