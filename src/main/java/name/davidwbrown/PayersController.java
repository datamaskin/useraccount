package name.davidwbrown;

import io.micronaut.context.BeanContext;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;

import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/payers")
public class PayersController {
    final BeanContext context = BeanContext.run();
    Payers payers = context.getBean(Payers.class);
    PayerAccountBean account = context.getBean(PayerAccountBean.class);

    @Get(produces = MediaType.TEXT_PLAIN)
    public List<Integer> index() {
        account.init();
        return payers.getPoints();
    }
}
