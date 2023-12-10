package imd.web2.projeto3.petcare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    @NotNull(message = Mensagens.NOTNULL)
    @Size(max = 64, message = Mensagens.MAX)
    private String especialidade;

    @NotNull(message = Mensagens.NOTNULL)
    private Boolean status;
}
