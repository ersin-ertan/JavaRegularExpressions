package com.mmsofts.regextuts.javacodegeeks;

import android.test.AndroidTestCase;

import java.util.regex.Pattern;

/**
 * Created by mms on 5/18/16.
 * Reference site: https://examples.javacodegeeks.com/core-java/java-regular-expressions-tutorial/
 */
public class RegexEx  extends AndroidTestCase{

    public void split(){

        Pattern pattern = Pattern.compile("\\d+");
        String[] st = pattern.split("20 potato, 10 tomato, 5 bread");
        for (int i = 1; i < st.length; i++) {
            System.out.println("recipe ingredients" + i + " : " + st[i]);
        }

        // which outputs rec ing1 : po
        // which splits the given input string based on matches of the pattern, working for any digit
        // occuring one or more for the input string
    }

    public void flags(){

        Pattern pattern = Pattern.compile("abc$", Pattern.CASE_INSENSITIVE);
        // pattern can be created with flags to mae the pattern flexible against the input sting
    }

    public void matches(){
        // to return the boolean result of whether the input matches use
        Pattern.matches("regularExpression", "inputString");
        // using Strings functions can also work too
        String matchMe = "matchMe";
        boolean doIMatch = matchMe.matches(".+");
    }

    // don't forget that when working with groups that the first group that is group 0
    // is always the full input string, thus the group number corresponds with the group
    // unlike the off by one due to the 0 start of arrays
}
