package esprit.candidatms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidatRestController {
    public String hello="Hello from candidatsMs";

    @RequestMapping("/hello")
    public String sayHello(){
        return hello;
    }
}
