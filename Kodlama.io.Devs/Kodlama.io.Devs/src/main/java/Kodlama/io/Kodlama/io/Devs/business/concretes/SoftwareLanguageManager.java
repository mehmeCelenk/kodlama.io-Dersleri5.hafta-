package Kodlama.io.Kodlama.io.Devs.business.concretes;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.SoftwareLanguageService;
import Kodlama.io.Kodlama.io.Devs.business.requests.softwareLanguageRequests.CreateSoftwareLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.softwareLanguageRequests.DeleteSoftwareLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.softwareLanguageRequests.UpdateSoftwareLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.response.softwareLanguageResponses.GetAllSoftwareLanguageResponse;
import Kodlama.io.Kodlama.io.Devs.business.response.softwareLanguageResponses.GetByIdSoftwareLanguageResponse;
import Kodlama.io.Kodlama.io.Devs.dataAccsess.abstracts.SoftwareLanguageRepository;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.SoftwareLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SoftwareLanguageManager implements SoftwareLanguageService {
    private SoftwareLanguageRepository softwareLanguageRepository;


    public SoftwareLanguageManager(SoftwareLanguageRepository softwareLanguageRepository) {
        this.softwareLanguageRepository = softwareLanguageRepository;
    }


    @Override
    public List<GetAllSoftwareLanguageResponse> getAll() {
        List<SoftwareLanguage> softwareLanguages = softwareLanguageRepository.findAll();
        List<GetAllSoftwareLanguageResponse> softwareLanguageResponses = new ArrayList<>();

        for (SoftwareLanguage softwareLanguage: softwareLanguages) {
            GetAllSoftwareLanguageResponse response = new GetAllSoftwareLanguageResponse();
            response.setName(softwareLanguage.getName());

            softwareLanguageResponses.add(response);
        }
        return softwareLanguageResponses;
    }

    @Override
    public void update(int id, UpdateSoftwareLanguageRequest updateSoftwareLanguageRequest) {
        if(!updateSoftwareLanguageRequest.getName().isEmpty()){
            SoftwareLanguage softwareLanguage = softwareLanguageRepository.findById(id).get();

            softwareLanguage.setName(updateSoftwareLanguageRequest.getName());
            softwareLanguageRepository.save(softwareLanguage);
        }
    }

    @Override
    public void delete(DeleteSoftwareLanguageRequest deleteSoftwareLanguageRequest) {
        softwareLanguageRepository.deleteById(deleteSoftwareLanguageRequest.getId());
    }

    @Override
    public void save(CreateSoftwareLanguageRequest createSoftwareLanguageRequest) {
        if(softwareLanguageExistValidator(createSoftwareLanguageRequest) && softwareLanguageExistValidator(createSoftwareLanguageRequest)){
            SoftwareLanguage softwareLanguage = new SoftwareLanguage();

            softwareLanguage.setName(createSoftwareLanguageRequest.getName());
            softwareLanguageRepository.save(softwareLanguage);
        }
    }

    @Override
    public GetByIdSoftwareLanguageResponse getById(int id) {
       SoftwareLanguage softwareLanguages = softwareLanguageRepository.findById(id).get();
       GetByIdSoftwareLanguageResponse response = new GetByIdSoftwareLanguageResponse();
       response.setName(softwareLanguages.getName());

       return response;
    }

    private boolean softwareLanguageExistValidator(CreateSoftwareLanguageRequest createSoftwareLanguageRequest){
        for(SoftwareLanguage tempSoftwareLanguage : softwareLanguageRepository.findAll()){
            if(tempSoftwareLanguage.getName().equalsIgnoreCase(createSoftwareLanguageRequest.getName())){
                System.out.println("Hatalı giriş aynı yazılım dili tekrar edemez !");
                return false;
            }
        }
        return true;
    }
}
