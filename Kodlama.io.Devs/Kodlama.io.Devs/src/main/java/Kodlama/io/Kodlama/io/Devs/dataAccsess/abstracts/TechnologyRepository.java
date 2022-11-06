package Kodlama.io.Kodlama.io.Devs.dataAccsess.abstracts;

import Kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
}
