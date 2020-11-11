package org.cap.apps.freelancerapp.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
@Component
public class DateUtil {
	private final String pattern="dd-MM-yy";

    public LocalDate toLocalDate(String dateText, String pattern){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern(pattern);
        LocalDate localDate=LocalDate.parse(dateText,formatter);
        return localDate;
    }

    public LocalDate localDate(String dateText){
        return toLocalDate(dateText,pattern);
    }

    public String toDateText(LocalDate date, String pattern){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern(pattern);
        String text=date.format(formatter);
        return text;
    }


    public String toDateText(LocalDate date) {
        return toDateText(date,pattern);
    }


}
