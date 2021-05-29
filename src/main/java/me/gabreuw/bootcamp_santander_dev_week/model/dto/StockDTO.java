package me.gabreuw.bootcamp_santander_dev_week.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class StockDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    @DecimalMin(value = "0.00") // valor mínimo aceito
    @Digits(integer = 6, fraction = 2) // número deve conter no máximo 6 casas antes da vírgula e 2 casas depois da vírgula (999999.99)
    private Double price;

    @NotNull
    @Digits(integer = 3, fraction = 2) // número deve conter no máximo 3 casas antes da vírgula e 2 casas depois da vírgula (999.99)
    private Double variation;

    @NotNull
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd/MM/yyyy"
    )
    private LocalDate date;

}
