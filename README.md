# validation-as-a-service
PoC of a spring boot application that uses validation rules from external service.

This project is based on [Spring Cloud Function][scf] project.

__IMPORTANT__: Execution of a lambda is done inside of a sandbox. The template is as follows:
```java
import java.util.*;
import java.util.function.*;
import reactor.core.publisher.Flux;

public class %s implements CompilationResultFactory<%s> {
    public %s<%s> getResult() {
        %s
    }
};
```

The rules can be specified in yml property [file][application.yml] or any other mechanism. It might contain the in/out parameters
as well as the body of validation.


Using ```org.springframework.cloud.function.compiler.java.SimpleClassLoader``` the rules are loadeded and compiled only during runtime.


__NOTE__: The functionality might be extended to use js nashorn to provide js functions.


   [scf]: <https://cloud.spring.io/spring-cloud-function/>
   [application.yml]: <https://github.com/bduisenov/validation-as-a-service/blob/master/src/main/resources/application.yml#L2>
