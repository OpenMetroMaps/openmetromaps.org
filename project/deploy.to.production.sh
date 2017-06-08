#!/bin/bash

set -e

./gradlew clean war

scp dynamic/build/libs/openmetromaps-dynamic-0.0.1-production.war \
root@topobyte.de:/tmp/openmetromaps.war

ssh root@topobyte.de mv /tmp/openmetromaps.war \
/opt/tomcat/apache-tomcat-8.0.33-other/webapps/openmetromaps/ROOT.war
