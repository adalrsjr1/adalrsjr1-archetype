# Maven archetype

This archetype bootstrat a SpringBoot project with Groovy support

## Instalation

`mvn clean install`

## Usage

```
maven
mvn archetype:generate \
  -DarchetypeGroupId=com.adalrjsr1.archetype \
  -DarchetypeArtifactId=adalrsjr1-archetype \
  -DarchetypeVersion=1.0-SNAPSHOT \
  -DgroupId=${groupId} \
  -DartifactId=${artifactId} \
  -Dversion=${version} \
  -DinteractiveMode=false
```
