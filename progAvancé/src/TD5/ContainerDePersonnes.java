package TD5;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;

public class ContainerDePersonnes {
    ArrayList<Personne> listPersonnes = new ArrayList<>();
    Vaccin rootVaccin;
    Personne rootPersonne;

    ContainerDePersonnes(){
        Vaccin v1 = new Vaccin(new Date(13012021), "pfizer");
        rootVaccin = v1;
        PersonneVaccinee p1 = new PersonneVaccinee("kun", "ary", 21);
        rootPersonne = p1;
        p1.addVaccin(v1);

        Vaccin v2 = new Vaccin(new Date(12122021), "moderna");
        PersonneVaccinee p2 = new PersonneVaccinee("maissa", "axel", 44);
        p2.addVaccin(v2);

        Vaccin v3 = new Vaccin(new Date(14032021), "astrazeneca");
        PersonneVaccinee p3 = new PersonneVaccinee("khaldi", "djade", 67);
        p3.addVaccin(v3);

        listPersonnes.add(p1);
        listPersonnes.add(p2);
        listPersonnes.add(p3);
    }

    public void lambdaMethod(Boolean print){
        //Lambda
        this.listPersonnes.forEach((Personne pers) -> {
            PersonneVaccinee vaccinee = (PersonneVaccinee) pers;
            if(print){
                System.out.println("-------- AVANT -------------");
                vaccinee.display();
            }
            vaccinee.ajusterEfficacite();
            if(print){
                System.out.println("-------- APRES -------------");
                vaccinee.display();
            }
        });
    }

    @Override
    public String toString() {
        return "ContainerDePersonnes{" +
                "listPersonnes=" + listPersonnes +
                '}';
    }

    public void sauveurPersonnes(String nomFichier) throws IOException {
        FileOutputStream f = new FileOutputStream(nomFichier);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(rootPersonne);
        o.writeObject(rootVaccin);
        o.writeObject(listPersonnes);
        f.flush();
        f.close();
    }

    public void restaurerPersonnes(String nomFichier) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(nomFichier);
        ObjectInputStream o = new ObjectInputStream(f);
        rootPersonne = (Personne) o.readObject();
        rootVaccin = (Vaccin) o.readObject();
        listPersonnes = (ArrayList<Personne>) o.readObject();
        for (Personne pers : listPersonnes){
            PersonneVaccinee vaccinee = (PersonneVaccinee) pers;
            vaccinee.display();
        }
        f.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ContainerDePersonnes test = new ContainerDePersonnes();
        //LAMBDA
        //True pour voir les resultats
        test.lambdaMethod(false);

        test.sauveurPersonnes("resultatTD.txt");
        test.restaurerPersonnes("resultatTD.txt");
    }
}
