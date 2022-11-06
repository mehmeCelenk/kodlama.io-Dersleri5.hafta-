package Kodlama.io.Kodlama.io.Devs.dataAccsess.abstracts;

import Kodlama.io.Kodlama.io.Devs.entities.concretes.SoftwareLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoftwareLanguageRepository extends JpaRepository<SoftwareLanguage, Integer> {

}
