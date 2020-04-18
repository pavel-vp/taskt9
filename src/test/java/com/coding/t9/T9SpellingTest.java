package com.coding.t9;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the T9Spelling class
 */
public class T9SpellingTest {

    @Test
    public void t9_spell_1_test() {
        String input = "hi";
        String output = T9Spelling.spell(input);
        Assert.assertEquals("44 444", output);
    }

    @Test
    public void t9_spell_2_test() {
        String input = "yes";
        String output = T9Spelling.spell(input);
        Assert.assertEquals("999337777", output);
    }

    @Test
    public void t9_spell_3_test() {
        String input = "foo  bar";
        String output = T9Spelling.spell(input);
        Assert.assertEquals("333666 6660 022 2777", output);
    }

    @Test
    public void t9_spell_4_test() {
        String input = "hello world";
        String output = T9Spelling.spell(input);
        Assert.assertEquals("4433555 555666096667775553", output);
    }

    @Test
    public void t9_spell_null_test() {
        String input = null;
        String output = T9Spelling.spell(input);
        Assert.assertEquals("", output);
    }

    @Test
    public void t9_spell_space_test() {
        String input = " ab";
        String output = T9Spelling.spell(input);
        Assert.assertEquals("02 22", output);
    }

    @Test(expected = IllegalArgumentException.class)
    public void t9_spell_error_chars_test() {
        String input = "SOME ILLEGAL ARGUMENTS";
        T9Spelling.spell(input);
    }


}
