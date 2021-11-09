package miage.TDClassesInternes;

import java.util.Objects;
import java.util.function.Consumer;

public class Traitement_3 implements Consumer<UE> {

    @Override
    public void accept(UE ue) {
        if (Objects.equals(ue.typeControle, "QCM")){
            ue.rattrapage=true;
        }
    }

}
