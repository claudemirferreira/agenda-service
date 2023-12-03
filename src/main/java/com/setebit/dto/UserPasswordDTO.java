package com.setebit.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserPasswordDTO {

    @NotNull(message = "o id deve ser informado")
    private Integer id;

    @NotNull(message = "o password deve ser informado")
    private String password;

}
