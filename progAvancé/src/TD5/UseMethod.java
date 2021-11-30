package TD5;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(UseMethods.class)
public @interface UseMethod {
    String nomMethode();
    int nombreParametres();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface UseMethods {
    UseMethod[] value();
}
