package me.gabreuw.bootcamp_santander_dev_week.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class ExceptionResponse implements Serializable {

    private final String message;

}

