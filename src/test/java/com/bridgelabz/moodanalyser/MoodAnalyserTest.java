package com.bridgelabz.moodanalyser;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoodAnalyserTest {
    private MoodAnalyser moodAnalyser;

    @Before
    public void initialize() {
        moodAnalyser = new MoodAnalyser();
    }

    @Test
    public void givenMessage_whenSad_shouldReturnSad() {
        String mood = moodAnalyser.analyseMood("Today I am sad");
        Assert.assertEquals("sad", mood);
    }

    @Test
    public void givenMessage_whenHappy_shouldReturnHappy() {
        String mood = moodAnalyser.analyseMood("Today I am happy");
        Assert.assertEquals("happy",mood);
    }

    @Test
    public void givenMessage_whenAny_shouldReturnHappy() {
        String mood = moodAnalyser.analyseMood("I am in Any Mood");
        Assert.assertEquals("happy", mood);
    }

}
