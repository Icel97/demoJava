package com.example.demojava.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String nowMadagascar() {
        ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of("Indian/Antananarivo"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return dateTime.format(formatter);
    }
}
