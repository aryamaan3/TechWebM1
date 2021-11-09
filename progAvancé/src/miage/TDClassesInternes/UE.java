package miage.TDClassesInternes;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;

public class UE {
    String nom, nomDiplome, nomEnseignant, typeControle;
    public Integer annee;
    Boolean rattrapage;
    addAnnee add;
    UE(String nom, String nomDiplome, String nomEnseignant, String typeControle, Integer annee, Boolean rattrapage){
        this.nom = nom;
        this.nomDiplome = nomDiplome;
        this.nomEnseignant = nomEnseignant;
        this.typeControle = typeControle;
        this.annee = annee;
        this.rattrapage = rattrapage;
        add = new addAnnee();
    }


    class addAnnee implements Consumer<UE> {

        @Override
        public void accept(UE ue) {
            ue.annee ++;
        }

    }

    class traitement2 implements Consumer<UE> {
        @Override
        public void accept(UE ue) {
            if(Objects.equals(ue.nomEnseignant, "Dupont")){
                ue.annee++;
            }
        }
    }

    class traitement3 implements Consumer<UE>{
        @Override
        public void accept(UE ue) {
            if (Objects.equals(ue.typeControle, "QCM")){
                ue.rattrapage=true;
            }
        }
    }

    @Override
    public String toString() {
        return "UE{" +
                "nom='" + nom + '\'' +
                ", nomDiplome='" + nomDiplome + '\'' +
                ", nomEnseignant='" + nomEnseignant + '\'' +
                ", typeControle='" + typeControle + '\'' +
                ", annee=" + annee +
                ", rattrapage=" + rattrapage +
                '}' + '\n';
    }

    public static void main(String[] args) {

        ArrayList <UE> listOfUE = new ArrayList<>();
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

        //listOfUE.forEach((n) -> n.annee++); //lambda

        //STATIC
        //add static to addAnnee
        //addAnnee t = new addAnnee();
        //listOfUE.forEach(t)

        //Traitement_2 t2 = new Traitement_2();
        Traitement_3 t = new Traitement_3();




        listOfUE.forEach(t);
        System.out.println(listOfUE);

    }
}
