package com.springjwt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name = "users")
public class User {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_USUARIO")
    @SequenceGenerator(sequenceName = "S_USUARIO", allocationSize = 1, name = "S_USUARIO")
    @Id
    @Column(name = "USU_ID")
    private Long id;

    @Column(name = "USU_NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "USU_EMAIL", length = 100)
    private String email;

    @Column(name = "USU_PASSWORD", length = 200, nullable = false)
    private String password;

}
