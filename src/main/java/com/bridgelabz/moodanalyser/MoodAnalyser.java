package com.bridgelabz.moodanalyser;

import com.bridgelabz.moodanalyser.exceptions.MoodAnalysisException;

public class MoodAnalyser {
    String message;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if (this.message.contains("sad"))
                return "sad";
            if (this.message.contains("happy") || this.message.contains("any"))
                return "happy";
            return "Invalid mood";
        }
        catch (NullPointerException e) {
            throw new MoodAnalysisException("Invalid message");
        }
    }
}
