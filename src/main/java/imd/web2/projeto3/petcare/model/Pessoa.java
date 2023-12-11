package imd.web2.projeto3.petcare.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = Mensagens.NOTNULL)
    @NotBlank(message = Mensagens.NOTNULL)
    @Size(max = 64, message = Mensagens.MAX)
    private String nome;

    @NotNull(message = Mensagens.NOTNULL)
    @NotBlank(message = Mensagens.NOTNULL)
    @Size(max = 128, message = Mensagens.MAX)
    private String contato;

    @NotNull(message = Mensagens.NOTNULL)
    @NotBlank(message = Mensagens.NOTNULL)
    @Size(max = 128, message = Mensagens.MAX)
    private String endereco;
}
