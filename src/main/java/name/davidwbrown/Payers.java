package name.davidwbrown;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class Payers {
    private final Payer payer;

    public Payers(Payer payer) {
        this.payer = payer;
    }

    String init() {
        return payer.init();
    }

    List<Integer> getPoints() {
        return payer.getPoints();
    }

    void setPoints(List<Integer> points) {
        payer.setPoints(points);
    }
}
