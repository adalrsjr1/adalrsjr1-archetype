#!/bin/bash

mvn archetype:generate \
  -DarchetypeGroupId=com.adalrsjr1.archetype \
  -DarchetypeArtifactId=adalrsjr1-archetype \
  -DarchetypeVersion=1.0-SNAPSHOT \
  -DgroupId=com.adalrsjr1.app \
  -DartifactId=app \
  -Dversion=1.0-SNAPSHOPT \
  -DinteractiveMode=false
