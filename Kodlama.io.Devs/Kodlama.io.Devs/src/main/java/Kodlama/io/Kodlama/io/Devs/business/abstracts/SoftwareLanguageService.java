package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import Kodlama.io.Kodlama.io.Devs.business.requests.softwareLanguageRequests.CreateSoftwareLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.softwareLanguageRequests.DeleteSoftwareLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.softwareLanguageRequests.UpdateSoftwareLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.response.softwareLanguageResponses.GetAllSoftwareLanguageResponse;
import Kodlama.io.Kodlama.io.Devs.business.response.softwareLanguageResponses.GetByIdSoftwareLanguageResponse;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.SoftwareLanguage;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SoftwareLanguageService {
    List<GetAllSoftwareLanguageResponse> getAll();

    void update(int id, UpdateSoftwareLanguageRequest updateSoftwareLanguageRequest);
    void delete(DeleteSoftwareLanguageRequest deleteSoftwareLanguageRequest);

    void save(CreateSoftwareLanguageRequest createSoftwareLanguageRequest);

    GetByIdSoftwareLanguageResponse getById(int id);
}
