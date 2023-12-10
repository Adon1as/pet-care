package imd.web2.projeto3.petcare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = Mensagens.NOTNULL)
    @Size(max = 64, message = Mensagens.MAX)
    private String Nome;

    @NotNull(message = Mensagens.NOTNULL)
    @Size(max = 32, message = Mensagens.MAX)
    private String especie;

    @NotNull(message = Mensagens.NOTNULL)
    @Size(max = 32, message = Mensagens.MAX)
    private String raca;

    @NotNull(message = Mensagens.NOTNULL)
    @Size(max = 32, message = Mensagens.MAX)
    private String tipoPelo;

    @NotNull(message = Mensagens.NOTNULL)
    @Size(max = 32, message = Mensagens.MAX)
    private String cor;

    @NotNull(message = Mensagens.NOTNULL)
    private Long pesoGramas;

    @NotNull(message = Mensagens.NOTNULL)
    private Long tamanhoCm;

    @NotNull(message = Mensagens.NOTNULL)
    private LocalDate nascimento;

    @Size(max = 255, message = Mensagens.MAX)
    private String observacao;

    public int getIdade(){
        return nascimento.compareTo(LocalDate.now());
    }

}
