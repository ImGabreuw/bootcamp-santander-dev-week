package me.gabreuw.bootcamp_santander_dev_week.exceptions;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
