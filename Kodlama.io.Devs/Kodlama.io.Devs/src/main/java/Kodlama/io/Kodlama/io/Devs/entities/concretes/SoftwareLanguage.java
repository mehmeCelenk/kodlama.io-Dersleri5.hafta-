package Kodlama.io.Kodlama.io.Devs.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "SoftwareLanguage")
public class SoftwareLanguage {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "softwareLanguage")
    private List<Technology> technologies;
}
