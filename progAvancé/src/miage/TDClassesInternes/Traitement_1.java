package miage.TDClassesInternes;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;

public class Traitement_1 implements Consumer<UE> {

    @Override
    public void accept(UE ue) {
        ue.annee++;
    }

    public static void main(String[] args) {
        ArrayList<UE> listOfUE = new ArrayList<>();
        UE UE_1 = new UE("Prog Avancé", "MIAGE", "Lahire", "QCM", 1980, false);
        UE UE_2 = new UE("Tech Web", "MIAGE", "Buffa", "Projets", 2000, true);
        UE UE_3 = new UE("Algo", "MIAGE", "Kounalis", "Synthése", 1999, false);
        UE UE_4 = new UE("Maths", "MIAGE", "Formenti", "QCM", 1800, true);
        UE UE_5 = new UE("IA", "MIAGE", "Cabrio", "Projets", 2013, true);
        listOfUE.add(UE_1);
        listOfUE.add(UE_2);
        listOfUE.add(UE_3);
        listOfUE.add(UE_4);
        listOfUE.add(UE_5);

        Traitement_1 t = new Traitement_1(); 

        listOfUE.forEach(t); //non statique
        System.out.println(listOfUE);

        class Traitement_1_bis implements Consumer<UE>{

            @Override
            public void accept(UE ue) {
                ue.annee++;
            }
        }

        class Traitement_2_bis implements Consumer<UE>{

            @Override
            public void accept(UE ue) {
                if(Objects.equals(ue.nomEnseignant, "Dupont")){
                    ue.annee++;
                }
            }
        }

        class Traitement_3_bis implements Consumer<UE>{

            @Override
            public void accept(UE ue) {
                if (Objects.equals(ue.typeControle, "QCM")){
                    ue.rattrapage=true;
                }
            }
        }

        Traitement_1_bis t1bis = new Traitement_1_bis();
        //listOfUE.forEach(t1bis); //locale
        //System.out.println(listOfUE);


    }
}
