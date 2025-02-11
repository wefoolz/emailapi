#!/bin/bash

# Install Maven
apt-get update
apt-get install -y maven

# Run the Maven build
mvn clean package -DskipTests
