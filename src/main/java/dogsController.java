import io.javalin.http.Handler;

import java.util.HashMap;
import java.util.Map;

public class dogsController {

    Map<Integer, Dogs> dogs = new HashMap();

        dogs.put(1, new Dogs("hans", 1990));


        dogs.put(2, new Dogs("jens", 1991));


        dogs.put(3, new Dogs("rasmus",  1992));

}

    public Handler getAllDogs () {
        return ctx -> {
            ctx.json(dogs);
        };

    }
