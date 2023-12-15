package imd.web2.projeto3.petcare.DTO;

import imd.web2.projeto3.petcare.model.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
