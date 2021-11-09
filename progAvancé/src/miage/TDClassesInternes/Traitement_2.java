package miage.TDClassesInternes;

import java.util.Objects;
import java.util.function.Consumer;

public class Traitement_2 implements Consumer<UE> {

    @Override
    public void accept(UE ue) {
        if(Objects.equals(ue.nomEnseignant, "Lahire")){
            ue.annee++;
        }
    }
    public static void main(String[] args) {

    }
}

