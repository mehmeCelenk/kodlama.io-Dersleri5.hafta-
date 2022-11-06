package Kodlama.io.Kodlama.io.Devs.webApi.Controllers;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.SoftwareLanguageService;
import Kodlama.io.Kodlama.io.Devs.business.requests.softwareLanguageRequests.CreateSoftwareLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.softwareLanguageRequests.DeleteSoftwareLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.softwareLanguageRequests.UpdateSoftwareLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.response.softwareLanguageResponses.GetAllSoftwareLanguageResponse;
import Kodlama.io.Kodlama.io.Devs.business.response.softwareLanguageResponses.GetByIdSoftwareLanguageResponse;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.SoftwareLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/SoftwareLanguage")
public class SoftwareLanguageController {
    private SoftwareLanguageService softwareLanguageService;


    public SoftwareLanguageController(SoftwareLanguageService softwareLanguageService) {
        this.softwareLanguageService = softwareLanguageService;
    }

    @GetMapping("/getall")
    public List<GetAllSoftwareLanguageResponse> getAll(){
        return softwareLanguageService.getAll();
    }

    @PutMapping("/update")
    public void update(@RequestBody int id, UpdateSoftwareLanguageRequest updateSoftwareLanguageRequest){
        softwareLanguageService.update(id, updateSoftwareLanguageRequest);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteSoftwareLanguageRequest deleteSoftwareLanguageRequest){
       softwareLanguageService.delete(deleteSoftwareLanguageRequest);
    }

    @GetMapping("/getbyid/{id}")
    public GetByIdSoftwareLanguageResponse getById(@RequestParam int id){
        return  softwareLanguageService.getById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody CreateSoftwareLanguageRequest createSoftwareLanguageRequest){
       softwareLanguageService.save(createSoftwareLanguageRequest);
    }


}
