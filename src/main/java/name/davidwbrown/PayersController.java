package name.davidwbrown;

import io.micronaut.context.BeanContext;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

import java.text.ParseException;
import java.util.List;


@Controller("/balance")
public class PayersController {

    final BeanContext context = BeanContext.run();
    Payers payer = context.getBean(Payers.class);
    PayerAccountBean account = context.getBean(PayerAccountBean.class);

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() throws ParseException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < payer.getName().size(); i++) {
            sb.append(payer.getName().get(i));
            sb.append(" ");
            sb.append(payer.getPoints().get(i));
            sb.append(" ");
            sb.append(payer.getDate().get(i));
            sb.append(", ");
        }
        return sb.toString();
    }

    @Get(produces = MediaType.TEXT_PLAIN, value = "/add/{+name}/{points}/{+date}")
    String getAdd(String name, @QueryValue String points, @QueryValue String date) throws ParseException {
        return account.getAdd(name, points, date);
    }

    @Get(produces = MediaType.TEXT_PLAIN, value = "/deduct/{+name}/{points}")
    String getDeduct(String name, @QueryValue String points) {
        return account.getDeduct(name, points);
    }

}
