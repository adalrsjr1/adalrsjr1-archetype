# Maven archetype

This archetype bootstrat a SpringBoot project with Groovy support

## Instalation

`mvn clean install`

## Usage

### Creating Project

```
mvn archetype:generate \
  -DarchetypeGroupId=com.adalrjsr1.archetype \
  -DarchetypeArtifactId=adalrsjr1-archetype \
  -DarchetypeVersion=1.0-SNAPSHOT \
  -DgroupId=${groupId} \
  -DartifactId=${artifactId} \
  -Dversion=${version} \
  -DinteractiveMode=false
```

### Running Project

- `mvn clean install spring-boot:repackage`

- `mvn clean spring-boot:run`

- `mvn clean test`


## Known Issues

1. AOP tracing tracks down only public methods
2. The first run must be `mvn clean spring-boot:run` even if using eclipse. From 2nd run onwards, it is possible to run by using eclipse
3. When into eclipse, the project must be run by using mvn when a change is made on `*.tracing` package
