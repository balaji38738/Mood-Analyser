package com.bridgelabz.moodanalyser;

import com.bridgelabz.moodanalyser.exceptions.MoodAnalysisException;

import java.util.Objects;

public class MoodAnalyser {
    String message;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if (this.message.equals(""))
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.EMPTY, "Empty mood");
            if (this.message.contains("sad"))
                return "sad";
            if (this.message.contains("happy") || this.message.contains("any"))
                return "happy";
            return "happy";
        } catch (NullPointerException nullPointerException) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NULL,
                    "Invalid message");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyser that = (MoodAnalyser) o;
        return Objects.equals(message, that.message);
    }

}
