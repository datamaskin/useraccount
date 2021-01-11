package name.davidwbrown;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;

import javax.inject.Singleton;
import javax.validation.constraints.PositiveOrZero;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Singleton
@Introspected
public class PayerAccountBean implements Payer {

//    private final HttpRequest httpRequest;
    @PathVariable
    List<String> name = new ArrayList<>();

    @QueryValue
    @PositiveOrZero
    List<Integer> points = new ArrayList<>();

    @QueryValue
    List<String> dates = new ArrayList<>();

    public PayerAccountBean() {
    }

    public PayerAccountBean(String name, String points, String dates) throws ParseException {
        this.name.add(name);
        this.points.add(Integer.parseInt(points));
        this.dates.add(DateParser.getParsedDate(dates));
    }

    @Override
    public String getAdd(String name, String points, String date) throws ParseException {
        setName(name);
        setPoints(points);
        setDate(date);
        return name + " " + points + " " + date;
    }

    @Override
    public String getDeduct(String name, String points) {
        int index = this.name.indexOf(name);
        Integer val = this.points.get(index);
        Integer deduct = Integer.parseInt(points);
        this.points.set(index, val-deduct);
        return this.name.get(index) + " " + this.points.get(index);
    }

    @Override
    public String init() throws ParseException {
        String strDate = "11/1 2PM";
        String dateResult = DateParser.getParsedDate(strDate);

        setPoints("10");
        setName("David");
        setDate(dateResult);
        return "Initialize Payer Account\n";
    }


    @Override
    public List<Integer> getPoints() {
        return points;
    }

    @Override
    public void setPoints(String points) {
        this.points.add(Integer.parseInt(points));
    }

    @Override
    public List<String> getDate() {
        return dates;
    }

    @Override
    public void setDate(String dateStr) throws ParseException {
        dates.add(DateParser.getParsedDate(dateStr));
    }

    @Override
    public List<String> getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name.add(name);
    }

}
