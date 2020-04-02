package com.bridgelabz.moodanalyser;

public class MoodAnalyser {

    public String analyseMood(String message) {
        if (message.contains("sad"))
            return "sad";
        if (message.contains("happy"))
            return "happy";
        return "Invalid mood";
    }
}
