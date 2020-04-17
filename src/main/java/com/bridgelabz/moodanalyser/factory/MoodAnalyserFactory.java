package com.bridgelabz.moodanalyser.factory;

import com.bridgelabz.moodanalyser.MoodAnalyser;
import com.bridgelabz.moodanalyser.exceptions.MoodAnalysisException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser getMoodAnalyserObject() {
        try {
            Constructor<?> constructor = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser").
                    getConstructor();
            Object reflectionObject = constructor.newInstance();
            return  (MoodAnalyser) reflectionObject;
        } catch (NoSuchMethodException | InstantiationException |
                IllegalAccessException | InvocationTargetException |
                ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor<?> getMoodAnalyserObject(String className, Class<?> ... param )
            throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            return moodAnalyserClass.getConstructor(param);
        }
        catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND,
                    "Class not found");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.INVALID_CONSTRUCTOR,
                    "No such method");
        }
    }

}
