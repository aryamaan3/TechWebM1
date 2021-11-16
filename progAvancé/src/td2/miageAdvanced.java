package td2;

import java.lang.annotation.*;

enum Completude{
    partiel,
    complet,
    finalise
}


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface miageAdvanced {
    public Completude etatCompletude() default Completude.partiel;
    public boolean tested() default false;
    public boolean automatisation() default false;
}
