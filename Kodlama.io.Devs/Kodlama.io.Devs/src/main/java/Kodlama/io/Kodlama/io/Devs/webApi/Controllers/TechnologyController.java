package Kodlama.io.Kodlama.io.Devs.webApi.Controllers;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.DeleteTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.response.technologyResponses.GetAllTechnologyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
    TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/getAll")
    public List<GetAllTechnologyResponse> getAll(){
        return this.technologyService.getAll();
    }

    @PostMapping("/save")
    public void save(CreateTechnologyRequest createSoftwareLanguageTeTechnologyRequest){
        this.technologyService.save(createSoftwareLanguageTeTechnologyRequest);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest){
        this.technologyService.delete(deleteTechnologyRequest);
    }

    @PutMapping("/update")
    public void update(int id, UpdateTechnologyRequest updateTechnologyRequest){
        this.technologyService.update(id, updateTechnologyRequest);
    }
}
