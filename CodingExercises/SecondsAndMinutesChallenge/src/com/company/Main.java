package com.company;

public class Main {

    public static void main(String[] args) {

        String hoursMinutesAndSeconds = getDurationString(309, 8);
        System.out.println(hoursMinutesAndSeconds);
        hoursMinutesAndSeconds = getDurationString(4145);
        System.out.println(hoursMinutesAndSeconds);

        }

    public static String getDurationString(int minutes, int seconds){

        int hours = 0;

        if ((minutes < 0) || (seconds < 0 || seconds > 59)){
            return "Invalid Value";
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
            return "Invalid Value";
        }

        minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        String minutesHoursAndSeconds = getDurationString(minutes, remainingSeconds);
        System.out.println(minutesHoursAndSeconds);
        return minutesHoursAndSeconds;

    }
}
