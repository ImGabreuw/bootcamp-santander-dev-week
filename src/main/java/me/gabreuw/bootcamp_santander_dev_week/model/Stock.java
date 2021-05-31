package me.gabreuw.bootcamp_santander_dev_week.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // JPA será responsável por gerar a chave primário | OBS: caso o banco de dados fosse o responsável por gerar a chave primária, então seria: strategy = GenerationType.IDENTITY
    private Long id;

    private String name;
    private Double price;
    private Double variation;
    private LocalDate date;

}
