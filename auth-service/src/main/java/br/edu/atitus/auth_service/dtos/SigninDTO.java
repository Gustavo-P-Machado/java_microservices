package br.edu.atitus.auth_service.dtos;

import br.edu.atitus.auth_service.entities.UserType;

public record SigninDTO(String email, String password) {

}
