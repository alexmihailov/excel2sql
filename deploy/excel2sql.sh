#!/bin/bash
#
#

JAR_FILE=/home/alex/Documents/projects/excel2sql/deploy/assemble/excel2sql-0.0.1-SNAPSHOT.jar
CONFIG_FILE=/home/alex/Documents/projects/excel2sql/deploy/config/application.properties

java -jar $JAR_FILE --spring.config.location=file:$CONFIG_FILE
