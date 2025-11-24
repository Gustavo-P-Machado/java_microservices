package br.edu.atitus.auth_service.dtos;

import br.edu.atitus.auth_service.entities.UserType;

public record SignupDTO(String name,
                        String email,
                        String password,
                        String phoneNumber,
                        String address,
                        UserType type) {

}
