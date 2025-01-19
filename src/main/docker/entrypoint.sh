#!/bin/bash

# Start PostgreSQL
service postgresql start

# Initialize the database (only on the first run)
su - postgres -c "psql -c \"CREATE USER $POSTGRES_USER WITH PASSWORD '$POSTGRES_PASSWORD';\""
su - postgres -c "psql -c \"CREATE DATABASE $POSTGRES_DB;\""
su - postgres -c "psql -c \"GRANT ALL PRIVILEGES ON DATABASE $POSTGRES_DB TO $POSTGRES_USER;\""

# Start the Quarkus application
java -jar /deployments/quarkus-run.jar

