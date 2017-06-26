#!/bin/bash

set -e

./gradlew clean war

scp dynamic/build/libs/openmetromaps-dynamic-0.0.1-production.war \
root@web1.topobyte.de:/tmp/openmetromaps.war

ssh root@web1.topobyte.de mv /tmp/openmetromaps.war \
/opt/tomcat/tomcat-main/rootapps/openmetromaps/ROOT.war
