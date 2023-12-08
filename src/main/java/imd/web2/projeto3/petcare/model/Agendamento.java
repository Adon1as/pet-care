package imd.web2.projeto3.petcare.model;

import jakarta.persistence.*;
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
    private LocalDateTime data;
    @OneToOne
    private Pet pet;
    @OneToOne
    private Servico servico;
    @OneToOne
    private Funcionario funcionario;
    @OneToOne
    private Local local;
    private String observacao;
}
