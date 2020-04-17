package com.bridgelabz.moodanalyser;

import com.bridgelabz.moodanalyser.exceptions.MoodAnalysisException;
import com.bridgelabz.moodanalyser.factory.MoodAnalyserFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserTest {
    private MoodAnalyser moodAnalyser;

    @Test
    public void givenMessage_whenSad_shouldReturnSad() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        moodAnalyser = new MoodAnalyser("I am in sad mood");
        Class<?> cls = moodAnalyser.getClass();
        Method methodObject = cls.getDeclaredMethod("analyseMood");
        String mood = (String) methodObject.invoke(moodAnalyser);
        Assert.assertEquals("sad", mood);
    }

    @Test
    public void givenMessage_whenHappy_shouldReturnHappy() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        moodAnalyser = new MoodAnalyser("I am in happy mood");
        Class<?> cls = moodAnalyser.getClass();
        Method methodObject = cls.getDeclaredMethod("analyseMood");
        String mood = (String) methodObject.invoke(moodAnalyser);
        Assert.assertEquals("happy", mood);
    }

    @Test
    public void givenMessage_whenAny_shouldReturnHappy() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        moodAnalyser = new MoodAnalyser("I am in any mood");
        Class<?> cls = moodAnalyser.getClass();
        Method methodObject = cls.getDeclaredMethod("analyseMood");
        String mood = (String) methodObject.invoke(moodAnalyser);
        Assert.assertEquals("happy", mood);
    }

    @Test
    public void givenMessage_whenNull_shouldThrowMoodAnalysisException() {
        try {
            moodAnalyser = new MoodAnalyser(null);
            String mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysisException moodAnalysisException) {
            Assert.assertEquals("Invalid message", moodAnalysisException.getMessage());
        }
    }

    @Test
    public void givenMessage_whenEmpty_shouldThrowMoodAnalysisException() {
        try {
            moodAnalyser = new MoodAnalyser("");
            String mood = moodAnalyser.analyseMood();
        }catch (MoodAnalysisException moodAnalysisException) {
            Assert.assertEquals("Empty mood", moodAnalysisException.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyser_whenProper_shouldReturnObject() {
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.getMoodAnalyserObject();
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        Assert.assertEquals(moodAnalyser, moodAnalyserObject);
    }

    @Test
    public void givenMoodAnalyser_whenImProper_shouldThrowMoodAnalysisException() {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getMoodAnalyserObject("CroodAnalyser");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND, e.type);
        }
    }

    @Test
    public void givenMoodAnalyser_whenInvalidConstructor_shouldThrowNoSuchMethodException() {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getMoodAnalyserObject("com.bridgelabz." +
                    "moodanalyser.MoodAnalyser", Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.INVALID_CONSTRUCTOR, e.type);
        }
    }
}
