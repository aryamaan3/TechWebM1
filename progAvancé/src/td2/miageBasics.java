package td2;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface miageBasics {
    public String nom();
    public String prenom();
    public int annee();
    public String module();
    public int td();
}
