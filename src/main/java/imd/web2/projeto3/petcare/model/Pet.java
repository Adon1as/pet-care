package imd.web2.projeto3.petcare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

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

    @NotNull(message = Mensagem.NOTNULL)
    @NotBlank(message = Mensagem.NOTNULL)
    @Size(max = 64, message = Mensagem.MAX)
    private String Nome;

    @NotNull(message = Mensagem.NOTNULL)
    @NotBlank(message = Mensagem.NOTNULL)
    @Size(max = 32, message = Mensagem.MAX)
    private String especie;

    @NotNull(message = Mensagem.NOTNULL)
    @NotBlank(message = Mensagem.NOTNULL)
    @Size(max = 32, message = Mensagem.MAX)
    private String raca;

    @NotNull(message = Mensagem.NOTNULL)
    @NotBlank(message = Mensagem.NOTNULL)
    @Size(max = 32, message = Mensagem.MAX)
    private String tipoPelo;

    @NotNull(message = Mensagem.NOTNULL)
    @NotBlank(message = Mensagem.NOTNULL)
    @Size(max = 32, message = Mensagem.MAX)
    private String cor;

    @NotNull(message = Mensagem.NOTNULL)
    private Long pesoGramas;

    @NotNull(message = Mensagem.NOTNULL)
    private Long tamanhoCm;

    @Past
    @NotNull(message = Mensagem.NOTNULL)
    private LocalDate nascimento;

    @Size(max = 255, message = Mensagem.MAX)
    private String observacao;

    @Transient
    private Long responsavelId;

    public int getIdade(){
        return Period.between(nascimento, LocalDate.now()).getYears();
    }



}
