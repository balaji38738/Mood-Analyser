package com.bridgelabz.moodanalyser;

import com.bridgelabz.moodanalyser.exceptions.MoodAnalysisException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest {
    private MoodAnalyser moodAnalyser;

    @Test
    public void givenMessage_whenSad_shouldReturnSad() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser("I am in sad mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("sad", mood);
    }

    @Test
    public void givenMessage_whenHappy_shouldReturnHappy() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser("I am in happy mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("happy",mood);
    }

    @Test
    public void givenMessage_whenAny_shouldReturnHappy() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser("I am in any mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("happy", mood);
    }

    @Test
    public void givenMessage_whenNull_shouldThrowMoodAnalysisException() {
        try {
            moodAnalyser = new MoodAnalyser(null);
            String mood = moodAnalyser.analyseMood();
        }catch (MoodAnalysisException moodAnalysisException) {
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
        try {
            Constructor constructor = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser").getConstructor();
            Object reflectionObject = constructor.newInstance();
            MoodAnalyser moodAnalyser = (MoodAnalyser) reflectionObject;
            MoodAnalyser realMoodObject = new MoodAnalyser();
            Assert.assertTrue(realMoodObject.equals(moodAnalyser));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyser_whenImProper_shouldThrowMoodAnalysisException() {
        try {
            Constructor constructor = Class.forName("com.bridgelabz.MoodAnalyser").getConstructor();
            Object reflectionObject = constructor.newInstance();
            MoodAnalyser moodAnalyser = (MoodAnalyser) reflectionObject;
            MoodAnalyser realMoodObject = new MoodAnalyser();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            try {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND,
                        "Invalid class name");
            }catch (MoodAnalysisException moodAnalysisException){
                Assert.assertEquals(MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND,
                        moodAnalysisException.type);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyser_whenInvalidConstructor_shouldThrowNoSuchMethodException() {
        try {
            Constructor constructor = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser").getConstructor(
                    String.class, Integer.class);
            Object reflectionObject = constructor.newInstance("I am in sad mood", 2);
            MoodAnalyser moodAnalyser = (MoodAnalyser) reflectionObject;
            MoodAnalyser realMoodObject = new MoodAnalyser("I am in sad mood");
        } catch (NoSuchMethodException e) {
            try {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND,
                        "Invalid constructor");
            }catch (MoodAnalysisException moodAnalysisException) {
                Assert.assertEquals("Invalid constructor", moodAnalysisException.getMessage());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
