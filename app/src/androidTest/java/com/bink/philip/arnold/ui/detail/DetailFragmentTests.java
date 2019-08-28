package com.bink.philip.arnold.ui.detail;

import android.text.Spanned;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DetailFragmentTests {
    @Test
    public void checkEmptyInstructionsFormat() {
        DetailFragment fragment = DetailFragment.newInstance("", null);
        String empty = "";
        Spanned result = fragment.formatInstructions(empty);

        assertEquals(result.toString(), empty);
    }

    @Test
    public void checkSingleLineInstructionsFormat() {
        DetailFragment fragment = DetailFragment.newInstance("", null);
        String value = "A single piece of text";
        Spanned result = fragment.formatInstructions(value);

        assertEquals(result.toString(), value);
    }
    @Test
    public void checkMultiLineInstructionsFormat() {
        DetailFragment fragment = DetailFragment.newInstance("", null);
        String value = "A single piece of text\r\nAnother piece of text";
        Spanned result = fragment.formatInstructions(value);

        // as the formatter replaces single line breaks with HTML <p>, this turns into \n\n
        // BUT, the first line also adds in a space before the returns, so that's added here
        String value2 = "A single piece of text \n\nAnother piece of text\n\n";

        assertEquals(result.toString(), value2);
    }
}
