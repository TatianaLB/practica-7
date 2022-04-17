package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder

@Table("ROPA")
public class prendaModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Column("IDPRENDA") @Id
    int idPrenda;
    private @Column("DESCRIPCION")
    String descripcion;
    private @Column("EXISTENCIAS")
    int existencias;

}
