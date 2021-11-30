package TD5;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

public class PersonneVaccineeIntrospection {

    PersonneVaccineeIntrospection(){

    }

    /**
     * return a list containing methods
     * that call more than "nombre" methods inside
     * of class personne vacinne
     * @param nombre of methods that a method should call
     * @return array of methods
     */
    ArrayList<String> methodesAppelees(int nombre){
        PersonneVaccinee test = new PersonneVaccinee("ary", "kun", 67);
        Vaccin v = new Vaccin(new Date(12122021), "test");
        test.addVaccin(v);
        Class<?> cl = test.getClass();
        Method[] methods = cl.getDeclaredMethods();
        ArrayList<String> list = new ArrayList<>();
        for (Method method : methods){
            Annotation[] aOfM = method.getDeclaredAnnotationsByType(UseMethod.class);
            if(aOfM.length >= nombre) {
                list.add(method.toString());
            }
        }

        return list;
    }

    public static void main(String[] args) {
        PersonneVaccineeIntrospection test = new PersonneVaccineeIntrospection();
        System.out.println(test.methodesAppelees(1));
        System.out.println("-------");
        System.out.println(test.methodesAppelees(2));
    }
}
