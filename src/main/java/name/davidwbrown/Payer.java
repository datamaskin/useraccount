package name.davidwbrown;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

import java.text.ParseException;
import java.util.List;

public interface Payer {

    @Get(value = "/add/{name}/params")
    default String getAdd(String name, @QueryValue String points, String date) throws ParseException {
        return name + " " + points + " " + date;
    }
    @Get(value = "/deduct/{name}/params")
    default String getDeduct(String name, @QueryValue String points) {
        return name + " " + points;
    }

    String init() throws ParseException;
    List<Integer> getPoints();
    void setPoints(String points);
    List<String> getDate();
    void setDate(String dateStr) throws ParseException;
    List<String> getName();
    void setName(String name);


}


