package com.bridgelabz.moodanalyser;

public class MoodAnalyser {
    String message;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() {
        if (this.message.contains("sad"))
            return "sad";
        if (this.message.contains("happy") || this.message.contains("any"))
            return "happy";
        return "Invalid mood";
    }
}
