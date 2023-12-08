package imd.web2.projeto3.petcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "pet")
@Entity(name = "Pet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Nome;
    private String especie;
    private String raca;
    private String tipoPelo;
    private String cor;
    private Long pesoGramas;
    private Long tamanhoCm;
    private LocalDate nacimento;
    private String observacao;

}
