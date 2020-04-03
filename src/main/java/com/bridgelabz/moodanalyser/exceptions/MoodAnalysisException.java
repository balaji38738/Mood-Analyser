package com.bridgelabz.moodanalyser.exceptions;

public class MoodAnalysisException extends Exception {

    public enum ExceptionType {
        EMPTY, NULL, CLASS_NOT_FOUND;
    }

    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
