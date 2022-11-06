package Kodlama.io.Kodlama.io.Devs.business.concretes;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.DeleteTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.response.technologyResponses.GetAllTechnologyResponse;
import Kodlama.io.Kodlama.io.Devs.dataAccsess.abstracts.SoftwareLanguageRepository;
import Kodlama.io.Kodlama.io.Devs.dataAccsess.abstracts.TechnologyRepository;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.SoftwareLanguage;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TechnologyManager implements TechnologyService {
    private TechnologyRepository technologyRepository;
    private SoftwareLanguageRepository softwareLanguageRepository;

    public TechnologyManager(TechnologyRepository technologyRepository, SoftwareLanguageRepository softwareLanguageRepository) {
        this.technologyRepository = technologyRepository;
        this.softwareLanguageRepository = softwareLanguageRepository;
    }

    @Override
    public List<GetAllTechnologyResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        List<GetAllTechnologyResponse> responses = new ArrayList<>();

        for (Technology technology: technologies) {
            GetAllTechnologyResponse response = new GetAllTechnologyResponse();

            response.setName(technology.getName());
            response.setLanguageName(technology.getSoftwareLanguage().getName());

            responses.add(response);
        }
        return responses;
    }

    @Override
    public void save(CreateTechnologyRequest createTechnologyRequest) {
        Technology technology = new Technology();

        SoftwareLanguage softwareLanguage = softwareLanguageRepository.findById(createTechnologyRequest.getSoftwareLanguageId()).get();

        technology.setName(createTechnologyRequest.getName());
        technology.setSoftwareLanguage(softwareLanguage);

        technologyRepository.save(technology);
    }

    @Override
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
        technologyRepository.deleteById(deleteTechnologyRequest.getId());
    }

    @Override
    public void update(int id, UpdateTechnologyRequest updateTechnologyRequest) {
        Technology technology = technologyRepository.findById(id).get();

        SoftwareLanguage softwareLanguage = softwareLanguageRepository.findById(updateTechnologyRequest.getSoftwareLanguageId()).get();

        technology.setName(updateTechnologyRequest.getName());
        technology.setSoftwareLanguage(softwareLanguage);

        technologyRepository.save(technology);
    }
}
