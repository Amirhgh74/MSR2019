package readability;

import model.Score;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@RestController
public class IndexController {


    @RequestMapping(value = "/quality", method = RequestMethod.POST, produces = "application/json")
    public HashMap<String, Double> index(@RequestBody Map<String, String> payload) {

        String origin = payload.get("origin");
        String edit = payload.get("edit");

        HashMap<String, Double> result = new HashMap<String, Double>();

        double scoreOrigin = raykernel.apps.readability.eval.Main.getReadability(origin);
        double scoreEdit = raykernel.apps.readability.eval.Main.getReadability(edit);


        result.put("originScore", scoreOrigin);
        result.put("editScore", scoreEdit);


        return result;
    }

}