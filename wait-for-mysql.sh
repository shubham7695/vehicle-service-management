#!/bin/bash

# Hostname of the MySQL container
MYSQL_HOST="mysql"
MYSQL_PORT="3306"

echo "⏳ Waiting for MySQL ($MYSQL_HOST:$MYSQL_PORT)..."

until mysqladmin ping -h"$MYSQL_HOST" --silent; do
    echo "MySQL is unavailable - sleeping"
    sleep 2
done

echo "✅ MySQL is up - starting the app"

exec java -jar app.jar
