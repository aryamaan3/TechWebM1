package td4;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Promotion2020 {

    ArrayList<Etudiant> etudiants = new ArrayList<>();
    Etudiant rootEtudiant;
    Adresse rootAdresse;
    Etudiant e1 = new Etudiant("Maissa", "Axel", 23, new Date(), "0901");
    Etudiant e2 = new Etudiant("Burel", "Paul", 21, new Date(), "0902");
    Etudiant e3 = new Etudiant("Khaldi", "Djade", 20, new Date(), "0903");
    Etudiant e4 = new Etudiant("Kunwar", "Ary", 22, new Date(), "0904");

    public Promotion2020(){
        Adresse a1 = new Adresse("Valbonne", "Rte des dollines", 2400, true);
        e1.setAdresse(a1);
        etudiants.add(e1);
        rootEtudiant = e1;
        rootAdresse = a1;

        Adresse a2 = new Adresse("Verdansk", "rue verdansk", 27, true);
        e2.setAdresse(a2);
        etudiants.add(e2);

        Adresse a3 = new Adresse("Nice", "jean medecin", 69, true);
        e3.setAdresse(a3);
        etudiants.add(e3);

        Adresse a4 = new Adresse("Nice", "Impasse saint laurent", 14, true);
        e4.setAdresse(a4);
        etudiants.add(e4);
    }

    @Override
    public String toString() {
        return "Promotion2020{" + "\n" +
                ", e1=" + e1 + "\n" +
                ", e2=" + e2 + "\n" +
                ", e3=" + e3 + "\n" +
                ", e4=" + e4 +
                '}';
    }

    public void saveEtudiants(String filename) throws IOException {
        FileOutputStream f = new FileOutputStream(new File(filename));
        ObjectOutputStream o = new ObjectOutputStream(f);
        for (Etudiant e : etudiants){
            e.writeObject(o);
        }
        //TODO
        //use root etudiant to keep same order when retrieveing
        o.close();
        f.close();
    }

    public void retrieveEtudiants(String filename) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(new File(filename));
        ObjectInputStream o = new ObjectInputStream(f);
        ArrayList<Etudiant> etd = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            etd.add((Etudiant) o.readObject());
        }
        System.out.println(etd);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Promotion2020 promo = new Promotion2020();
        promo.retrieveEtudiants("exercice1Etudiants.txt");
    }
}
