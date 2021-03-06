package com.company;
/*
        Create a method called getDurationString with two parameters, first parameter minutes and 2nd parameter seconds.

        You should validate that the first parameter minutes is >= 0.

        You should validate that the 2nd parameter seconds is >= 0 and <= 59.

        The method should return ÅgInvalid valueÅh in the method if either of the above are not true.

        If the parameters are valid then calculate how many hours minutes and seconds equal the minutes and seconds
        passed to this method and return that value as string in format ÅgXXh YYm ZZsÅh where XX represents a number of
        hours, YY the minutes and ZZ the seconds.

        Create a 2nd method of the same name but with only one parameter seconds.

        Validate that it is >= 0, and return ÅgInvalid valueÅh if it is not true.

        If it is valid, then calculate how many minutes are in the seconds value and then call the other overloaded
        method passing the correct minutes and seconds calculated so that it can calculate correctly.

        Call both methods to print values to the console.

        Tips:
        Use int or long for your number data types is probably a good idea.
        1 minute = 60 seconds and 1 hour = 60 minutes or 3600 seconds.
        Methods should be static as we have used previously.

        Bonus:
        For the input 61 minutes output should be 01h 01m 00s, but it is ok if it is 1h 1m 0s (Tip: use if-else)
        Create a new console project and call it SecondsAndMinutesChallenge

 */

public class Main {

    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";

    public static void main(String[] args) {

        String hoursMinutesAndSeconds = getDurationString(65, 9);
        System.out.println(hoursMinutesAndSeconds);
        hoursMinutesAndSeconds = getDurationString(4145);
        System.out.println(hoursMinutesAndSeconds);

        }

    public static String getDurationString(int minutes, int seconds){

        int hours = 0;

        if ((minutes < 0) || (seconds < 0 || seconds > 59)){
            return INVALID_VALUE_MESSAGE;
        }

        if (minutes > 59) {
            hours = minutes / 60;
            minutes = minutes % 60;

            if (hours < 10){
                if (minutes < 10){
                    if (seconds < 10){
                        return "0" + hours + "h " + "0" + minutes + "m " + "0" + seconds + "s";
                    }
                    return "0" + hours + "h " + "0" + minutes + "m " + seconds + "s";
                }
                return "0" + hours + "h " + minutes + "m " + seconds + "s";
            }
        }
        return hours + "h " + minutes + "m " + seconds + "s";

    }

    public static String getDurationString(int seconds){

        int minutes;
        if (seconds < 0) {
            return INVALID_VALUE_MESSAGE;
        }

        minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        String minutesHoursAndSeconds = getDurationString(minutes, remainingSeconds);
        System.out.println(minutesHoursAndSeconds);
        return minutesHoursAndSeconds;

    }
}
