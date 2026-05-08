package esprit.candidatms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidats")
public class CandidatRestController {
    public String hello="Hello from candidatsMs";
    @Autowired
    private CandidatService candidatService;

    @RequestMapping("/hello")
    public String sayHello(){
        return hello;
    }

    @GetMapping("/favorites")
    public List<JobDTO> getFavoriteJobs() {
        return candidatService.getFavoriteJobs();
    }
}
