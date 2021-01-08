package name.davidwbrown;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/points")
public class UserAccountController {
    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        return "points";
    }
}
