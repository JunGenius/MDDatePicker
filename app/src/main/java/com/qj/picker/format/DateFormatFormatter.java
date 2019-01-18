package com.qj.picker.format;


import com.qj.picker.calendarview.CalendarDay;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Format using a {@linkplain DateFormat} instance.
 */
public class DateFormatFormatter implements TitleFormatter {

    private final DateFormat dateFormat;

    /**
     * Format using "LLLL yyyy" for formatting
     */
    public DateFormatFormatter() {
        this.dateFormat = new SimpleDateFormat(
                "LLLL yyyy", Locale.getDefault()
        );

    }

    /**
     * Format using a specified {@linkplain DateFormat}
     *
     * @param format the format to use
     */
    public DateFormatFormatter(DateFormat format) {
        this.dateFormat = format;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CharSequence format(CalendarDay day) {
        return dateFormat.format(day.getDate());
    }
}
