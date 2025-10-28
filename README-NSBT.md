# SDK Demo NSBT - Java 21 / Spring Boot / Maven

## Instrucciones para instalar localmente

1. Descarga los archivos:
   - demo-nsbt-sdk-1.0.3.jar
   - demo-nsbt-sdk-1.0.3.pom

2. Instálalos en tu repositorio Maven local ejecutando:

   mvn install:install-file -Dfile=demo-nsbt-sdk-1.0.3.jar -DpomFile=demo-nsbt-sdk-1.0.3.pom

3. En el pom.xml de tu proyecto agrega la dependencia:

```xml
   <dependency>
     <groupId>com.nsbt.demo</groupId>
     <artifactId>demo-nsbt-sdk</artifactId>
     <version>1.0.3</version>
   </dependency>
```

4. Compila tu proyecto y usa las clases del SDK normalmente.


📍Nota:
Si el SDK tiene dependencias externas, Maven las resolverá automáticamente a partir del .pom