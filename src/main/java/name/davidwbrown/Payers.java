package name.davidwbrown;

import io.micronaut.core.annotation.Introspected;

import javax.inject.Singleton;
import java.text.ParseException;
import java.util.List;

@Singleton
@Introspected
public class Payers {
    private Payer payer;

    public Payers(Payer payer) {
        this.payer = payer;
    }

    String init() throws ParseException {
        return payer.init();
    }

    List<Integer> getPoints() {
        return payer.getPoints();
    }

    List<String> getName() {
        return payer.getName();
    }

    List<String> getDate() {
        return payer.getDate();
    }

    void setPoints(String points) {
        payer.setPoints(points);
    }
    void setName(String name) {
        payer.setName(name);
    }
    void setDate(String date) throws ParseException {
        payer.setDate(date);
    }
}
