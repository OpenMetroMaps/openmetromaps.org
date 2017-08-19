#!/bin/bash

set -e

./gradlew clean war

rsync -av dynamic/build/libs/openmetromaps-dynamic-0.0.1-production.war \
root@web1.topobyte.de:/opt/tomcat/tomcat-main/rootapps/openmetromaps/ROOT.war
