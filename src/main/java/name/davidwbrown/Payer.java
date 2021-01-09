package name.davidwbrown;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public interface Payer {

    List<Integer> points = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat();
    String user = "";
    String init();
    List<Integer> getPoints();
    void setPoints(List<Integer> points);
    SimpleDateFormat getDate();
    void setDate(SimpleDateFormat sdf);
}


