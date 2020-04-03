package com.bridgelabz.moodanalyser;

import com.bridgelabz.moodanalyser.exceptions.MoodAnalysisException;
import com.bridgelabz.moodanalyser.factory.MoodAnalyserFactory;
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
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.getMoodAnalyserObject();
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        Assert.assertTrue(moodAnalyser.equals(moodAnalyserObject));
    }

    @Test
    public void givenMoodAnalyser_whenImProper_shouldThrowMoodAnalysisException() {
        try
        {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getMoodAnalyserObject("CroodAnalyser");
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND,e.type);
        }
    }

    @Test
    public void givenMoodAnalyser_whenInvalidConstructor_shouldThrowNoSuchMethodException() {
        try
        {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getMoodAnalyserObject("com.bridgelabz." +
                    "moodanalyser.MoodAnalyser", Integer.class);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.INVALID_CONSTRUCTOR,e.type);
        }
    }
}
