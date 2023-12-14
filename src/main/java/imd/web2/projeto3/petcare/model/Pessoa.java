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

    @NotNull(message = Mensagem.NOTNULL)
    @NotBlank(message = Mensagem.NOTNULL)
    @Size(max = 64, message = Mensagem.MAX)
    private String nome;

    @NotNull(message = Mensagem.NOTNULL)
    @NotBlank(message = Mensagem.NOTNULL)
    @Size(max = 128, message = Mensagem.MAX)
    private String contato;

    @NotNull(message = Mensagem.NOTNULL)
    @NotBlank(message = Mensagem.NOTNULL)
    @Size(max = 128, message = Mensagem.MAX)
    private String endereco;
}
