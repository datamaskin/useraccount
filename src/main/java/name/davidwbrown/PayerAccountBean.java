package name.davidwbrown;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;

import javax.inject.Singleton;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.net.http.HttpRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Singleton
@Introspected
public class PayerAccountBean implements Payer {

    private final HttpRequest httpRequest;
    @PathVariable private List<String> name;

    @QueryValue
    @PositiveOrZero
    List<Integer> points = new ArrayList<>();

    @QueryValue
    @FutureOrPresent
    List<SimpleDateFormat> sdf = Collections.singletonList(new SimpleDateFormat());

    public PayerAccountBean(HttpRequest httpRequest, String name, @PositiveOrZero String points, @FutureOrPresent SimpleDateFormat sdf) {
        this.httpRequest = httpRequest;
        this.name.add(name);
        this.points.add(Integer.parseInt(points));
        this.sdf.add(sdf);
    }

    @Override
    public String init() {
        points.add(Integer.parseInt("10"));
        setPoints(points);
        return "Initialize Payer Account";
    }

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    @Override
    public List<Integer> getPoints() {
        return points;
    }

    @Override
    public void setPoints(List<Integer> points) {
        this.points = points;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(String name) {
        this.name.add(name);
    }

    public SimpleDateFormat getSdf() {
        return sdf.get(0);
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf.add(sdf);
    }

    @Override
    public SimpleDateFormat getDate() {
        return sdf.get(0);
    }

    @Override
    public void setDate(SimpleDateFormat sdf) {
        this.sdf.add(sdf);
    }

}
