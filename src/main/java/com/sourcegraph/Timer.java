package com.sourcegraph;

import io.reactivex.Observable;
import org.joda.time.DateTime;

import java.util.concurrent.TimeUnit;

public class Timer {

    /**
     * Start the timer!
     */
    public void start() {
        Observable.interval(3, TimeUnit.SECONDS)
                .map(__ -> DateTime.now())
                .map(Timer::formatTimeMessage)
                .forEach(System.out::println);
    }

    /**
     * helper for formatting DateTime objects
     * @param dateTime: the date that you want formatted
     * @return the formatted date
     */
    private static String formatTimeMessage(DateTime dateTime) {
        return String.format(
                "The time is %d:%02d:%02d",
                dateTime.hourOfDay().get(),
                dateTime.minuteOfHour().get(),
                dateTime.secondOfMinute().get()
        );
    }
}
