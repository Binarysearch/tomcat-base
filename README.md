# base repo para apis con tomcat

Ejecutar imagen docker de este ejemplo:
```docker run -p 8080:8080 binarysearch/tomcat-base:dev```

Comprobar que se esta ejecutando correctamente
```curl -d '{"name":"Antonio"}' -H "Content-Type: application/json" -X POST http://localhost:8080/example```