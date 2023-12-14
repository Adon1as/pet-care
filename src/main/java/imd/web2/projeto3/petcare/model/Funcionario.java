package imd.web2.projeto3.petcare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "funcionario")
@Entity(name = "Funcionario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends Pessoa {

    @NotNull(message = Mensagem.NOTNULL)
    @NotBlank(message = Mensagem.NOTNULL)
    @Size(max = 64, message = Mensagem.MAX)
    private String especialidade;

    @NotNull(message = Mensagem.NOTNULL)
    private Boolean status;
}
