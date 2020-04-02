package com.bridgelabz.moodanalyser;

import com.bridgelabz.moodanalyser.exceptions.MoodAnalysisException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
}
