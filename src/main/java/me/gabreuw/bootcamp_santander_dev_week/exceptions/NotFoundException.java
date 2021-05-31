package me.gabreuw.bootcamp_santander_dev_week.exceptions;

import me.gabreuw.bootcamp_santander_dev_week.util.MessageUtils;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND.getMessage());
    }
}
