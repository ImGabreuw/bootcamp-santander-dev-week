package me.gabreuw.bootcamp_santander_dev_week.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MessageUtils {

    STOCK_ALREADY_EXISTS("Stock already exists in the database"),
    NO_RECORDS_FOUND("No records found");

    @Getter
    private final String message;

}
