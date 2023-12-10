package imd.web2.projeto3.petcare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "local")
@Entity(name = "Local")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = Mensagens.NOTNULL)
    @Size(max = 64, message = Mensagens.MAX)
    private String nome;

    @NotNull(message = Mensagens.NOTNULL)
    @Size(max = 64, message = Mensagens.MAX)
    private String descricao;

    @NotNull(message = Mensagens.NOTNULL)
    private Integer capacidade;

    @Size(max = 128, message = Mensagens.MAX)
    private String Endereco;

}
