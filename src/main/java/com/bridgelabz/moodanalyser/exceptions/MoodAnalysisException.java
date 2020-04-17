package com.bridgelabz.moodanalyser.exceptions;

public class MoodAnalysisException extends Exception {

    public enum ExceptionType {
        EMPTY, NULL, CLASS_NOT_FOUND, INVALID_CONSTRUCTOR, NO_SUCH_METHOD;
    }

    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
