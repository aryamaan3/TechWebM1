package td2;
/**
 * @author Michel Buffa + modification Philippe Lahire
 * Inspir� par la classe Reflectiontest.java de
 * Cay S. Horstmann & Gary Cornell, publi�e dans le livre Core Java, Sun Press
 */

import miage.TDClassesInternes.UE;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse {

    @miageAdvanced(etatCompletude = Completude.complet)
    public static void analyseClasse(String nomClasse, boolean innerCl) throws ClassNotFoundException {
        // R�cup�ration d'un objet de type Class correspondant au nom pass� en param�tres
        Class cl = Class.forName(nomClasse);


        afficheEnTeteClasse(cl, innerCl);

        System.out.println();
        afficheInnerClasses(cl, innerCl);

        System.out.println();
        afficheAttributs(cl, innerCl);

        System.out.println();
        afficheConstructeurs(cl, innerCl);

        System.out.println();
        afficheMethodes(cl, innerCl);

        System.out.println();
        afficheAnnotations(cl, innerCl);

        // L'accolade fermante de fin de classe !
        System.out.println("}");
    }


    /**
     * Retourne la classe dont le nom est pass� en param�tre
     */
    @miageAdvanced(etatCompletude = Completude.finalise)
    public static Class getClasse(String nomClasse) throws ClassNotFoundException {
        return Class.forName(nomClasse).getDeclaringClass();
    }

    /**
     * Cette m�thode affiche par ex "public class C1 extends C2 implements I1, I2 {"
     */
    @miageAdvanced(etatCompletude = Completude.finalise, tested = true)
    public static void afficheEnTeteClasse(Class cl, boolean innerCl) {
        //  Affichage du modifier et du nom de la classe
        if (innerCl) {
            System.out.print("    ");
        }
        System.out.print(Modifier.toString(cl.getModifiers()) + " class " + cl.getSimpleName());

        // R�cup�ration de la superclasse si elle existe (null si cl est le type Object)
        Class supercl;
        if (cl.getSuperclass() != null) {
            supercl = cl.getSuperclass();
            if (supercl != cl) { // On ecrit le "extends " que si la superclasse est non nulle et diff�rente de Object
                System.out.print(" extends class " + supercl.getSimpleName());
            }
        }
        System.out.print(" implements ");

        for (int i = 0; i < cl.getInterfaces().length; i++) { // Affichage des interfaces que la classe implemente
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(cl.getInterfaces()[i].getSimpleName());
        }

        // Accolade ouvrante de d�but de classe
        System.out.print(" {\n");
    }

    /**
     * Cette m�thode affiche les classes imbriqu�es statiques ou pas
     * A faire apr�s avoir fait fonctionner le reste
     */
    @miageAdvanced(etatCompletude = Completude.finalise, tested = true, automatisation = true)
    public static void afficheInnerClasses(Class cl, boolean innerCl) throws ClassNotFoundException {
        if (cl.getDeclaredClasses().length > 0) {
            if (innerCl) {
                System.out.print("    Inner Classes : ");
            }
            System.out.println("Inner Classes : ");
            for (int i = 0; i < cl.getDeclaredClasses().length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                //System.out.println(cl.getDeclaredClasses()[i].getSimpleName());
                analyseClasse(cl.getDeclaredClasses()[i].getName(), true);
            }
            System.out.println();
        }
        else{
            System.out.println("No inner classes found");
        }
    }

    @miageAdvanced(etatCompletude = Completude.complet, automatisation = true)
    public static void afficheAttributs(Class cl, boolean innerCl) {
        if (innerCl) {
            System.out.print("    ");
        }
        if(cl.getDeclaredFields().length > 0) {
            System.out.print("Class Attributes : ");
            for (int i = 0; i < cl.getDeclaredFields().length; i++) {
                if (innerCl) {
                    System.out.print("    ");
                }
                System.out.print(cl.getDeclaredFields()[i].getType().getSimpleName() + " " + cl.getDeclaredFields()[i].getName());
                if (i < cl.getDeclaredFields().length - 1) {
                    System.out.print(", ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("No Class attributes found");
        }
    }

    @miageAdvanced(etatCompletude = Completude.complet)
    public static void afficheConstructeurs(Class cl, boolean innerCl) {
        if (innerCl) {
            System.out.print("    ");
        }
        if(cl.getDeclaredConstructors().length > 0) {
            System.out.println("Class Constructors : ");
            for (int i = 0; i < cl.getDeclaredConstructors().length; i++) {
                if (innerCl) {
                    System.out.print("    ");
                }
                System.out.print(cl.getDeclaredConstructors()[i]);
                if (i < cl.getDeclaredConstructors().length - 1) {
                    System.out.print(", ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("No constructors found");
        }
    }

    @miageAdvanced(etatCompletude = Completude.finalise, tested = true, automatisation = true)
    public static void afficheMethodes(Class cl, boolean innerCl) {
        if (innerCl) {
            System.out.print("    ");
        }
        if(cl.getDeclaredMethods().length > 0) {
            System.out.println("Class Methods : ");
            for (int i = 0; i < cl.getDeclaredMethods().length; i++) {
                if (innerCl) {
                    System.out.print("    ");
                }
                System.out.print(cl.getDeclaredMethods()[i]);
                if (i < cl.getDeclaredMethods().length - 1) {
                    System.out.print(", ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("No Methods found");
        }
    }

    @miageAdvanced(etatCompletude = Completude.complet)
    public static void afficheAnnotations(Class cl, boolean innerCl) {
        if (innerCl) {
            System.out.print("    ");
        }
        if(cl.getDeclaredAnnotations().length > 0) {
            System.out.print("Class Annotations : ");
            int i = 0;
            for (Annotation ann : cl.getDeclaredAnnotations()) {
                System.out.print(ann.annotationType().getName());
                if (i < cl.getDeclaredAnnotations().length - 1) {
                    System.out.print(", ");
                }
                i++;
            }
            System.out.println();
        }
        else{
            System.out.println("No annotations found");
        }
    }

    /* Facultatif au moins dans un premier temps */
/* tester le programme en passant un nom de classe complet en param�tre 
     Modifier la m�thode "main" en cons�quence
*/
    public static String litChaineAuClavier() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static void main(String[] args) {
        boolean ok = false;

        while (!ok) {
            try {
                System.out.print("Entrez le nom d'une classe (ex : java.lang.annotation.Retention): ");
                String nomClasse = litChaineAuClavier();

                analyseClasse(nomClasse, false);
                ok = true;
            } catch (ClassNotFoundException e) {
                System.out.println("Classe non trouv�e.");
            } catch (IOException e) {
                System.out.println("Erreur d'E/S!");
            }
        }
    }
}

