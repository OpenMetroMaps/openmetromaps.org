#!/bin/bash

set -e

./gradlew clean war

su -c 'cp dynamic/build/libs/openmetromaps-dynamic-0.0.1-production.war \
/opt/tomcat/tomcat-main/rootapps/openmetromaps/ROOT.war'
