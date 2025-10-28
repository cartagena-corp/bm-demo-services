package com.demo.demo.db.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "numero_documento")
    private long numeroDocumento;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "password")
    private String password;
}
