package com.mmsofts.regextuts.larsvogel;

import android.test.AndroidTestCase;

import java.util.regex.Pattern;

/**
 * Created by mms on 5/18/16.
 */

public class GroupingBackRef extends AndroidTestCase{

    public void testPatternMatcherExample(){

        String inputString = "This is a test which is cool";
        boolean b = Pattern.matches( "(is)($1)", inputString); // equivalent to Pattern.compile(patternString).matcher(inputString).matches();
        assertEquals(true, b);
    }

    /**
     * Negative Lookahead - where a positive match will yield a negative because the regex has matched
     * negative criteria in the text following the initial match
     */
    public void testNegativeLookahead(){
        String inputText = "this will match a so long as it does not follow as 'ab'. Anything after" +
                "is still fair game to be matched with the same criteria.";
        String negativeLookahead = "a(?!b)";

        boolean doesMatch = Pattern.matches(negativeLookahead, inputText);
        assertEquals(true, doesMatch);
    }

}
