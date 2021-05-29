package me.gabreuw.bootcamp_santander_dev_week.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class StockDTO implements Serializable {

    private Long id;

    private String name;
    private Double price;
    private Double variation;
    private LocalDate date;

}
