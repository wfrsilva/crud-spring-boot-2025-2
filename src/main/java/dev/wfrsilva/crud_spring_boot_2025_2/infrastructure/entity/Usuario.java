package dev.wfrsilva.crud_spring_boot_2025_2.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "usuario")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "email", unique = true )
    private String email;

    @Column (name = "nome")
    private String nome;

        
}//Usuario
