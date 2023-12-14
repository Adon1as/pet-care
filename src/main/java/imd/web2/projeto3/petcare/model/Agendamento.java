package imd.web2.projeto3.petcare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "agendamento")
@Entity(name = "Agendamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Future
    private LocalDateTime data;

    @NotNull
    @OneToOne
    private Pet pet;

    @NotNull
    @OneToOne
    private Servico servico;

    @NotNull
    @OneToOne
    private Funcionario funcionario;

    @NotNull
    @OneToOne
    private Local local;

    @Size(max = 255, message = Mensagem.MAX)
    private String observacao;
}
