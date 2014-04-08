#!/bin/sh
cd $CI_HOME/arkanoid
mvn install:install-file -DgroupId=com.uqbar -DartifactId=vainilla -Dversion=0.0.4 -Dpackaging=jar -Dfile=../vainilla/classes/artifacts/vainilla_jar/vainilla.jar
