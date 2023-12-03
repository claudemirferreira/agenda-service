package com.setebit.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserDTO {

    @NotNull(message = "o nome deve ser informado")
    private String name;

    @NotNull(message = "o login deve ser informado")
    private String login;

    @NotNull(message = "o email deve ser informado")
    @Email(message = "email invalido")
    private String email;

}
