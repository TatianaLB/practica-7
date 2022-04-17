package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("TIENDA")
public class tiendaModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Column("IDTIENDA") @Id
    int idTienda;
    private @Column("NOMBRE")
    String nombre;
    private @Column("CIUDAD")
    String ciudad;
    private @Column("DIRECCION")
    String direccion;
    private @Column("TELEFONO")
    String telefono;
    private @Column("HORARIO")
    String horario;
}
