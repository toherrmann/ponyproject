package de.il.torsten.zf.binding;

import de.il.torsten.pony.DateTimeFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class DateTimeFormatTest {

    @Test
    void formatDate() {
        LocalDate date = LocalDate.of(2025, 5, 30);
        String pattern = DateTimeFormat.DF_102.formatPattern;
        String formatted = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        Assertions.assertEquals("20250530", formatted);
    }

    @Test
    void formatDateTime() {
        ZoneId zone = ZoneId.of("Europe/Berlin");
        ZonedDateTime dateTime = ZonedDateTime.of(2025, 5, 30, 10, 30, 0, 0, zone);
        String pattern = DateTimeFormat.DF_205.formatPattern;
        String formatted = DateTimeFormatter.ofPattern(pattern).format(dateTime);
        Assertions.assertEquals("202505301030" + dateTime.getOffset().toString().replace(":", ""), formatted);

    }
}
