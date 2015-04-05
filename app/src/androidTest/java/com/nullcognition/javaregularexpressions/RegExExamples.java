package com.nullcognition.javaregularexpressions;

import android.os.PatternMatcher;

import junit.framework.TestCase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ersin on 05/04/15 at 12:54 PM
 */
public class RegExExamples extends TestCase {

   String patternString = "(..\\s)(([a-z]){3}){2}";
   String inputString   = "hi jarjar"; // input string must be exact, to find the regex amongst text, surrond with .* (any character zero or more times)

   public void testPatternMatcherExample(){

	  Pattern pattern = Pattern.compile(patternString); // long way, used for the same reg ex used in multiple ways
	  Matcher matcher = pattern.matcher(inputString);

	  boolean isMatch = matcher.matches();
	  assertEquals(true, isMatch);
   }

   public void testPattern(){

	  boolean b = Pattern.matches(patternString, inputString); // equivilent to Pattern.compile(patternString).matcher(inputString).matches();
	  assertEquals(true, b);
   }

   public void testAndroidPatternMatcher(){

	  PatternMatcher patternMatcher = new PatternMatcher("hi jarjar", PatternMatcher.PATTERN_LITERAL); // must be exact
	  assertEquals(true, patternMatcher.match("hi jarjar"));

	  patternMatcher = new PatternMatcher("hi", PatternMatcher.PATTERN_PREFIX); // only prefix is fine
	  assertEquals(true, patternMatcher.match("hi jar"));

//	  // failing test
//	  patternMatcher = new PatternMatcher("/mnt/my.file.mytype", PatternMatcher.PATTERN_SIMPLE_GLOB); // where .* in regular expressions would be any number of, .* is limited to the word with PatternMatcher, look into this
//	  assertEquals(true, patternMatcher.match("(.)*\\.mytype")); // match any prefix, not the metacharacter of . and the word mytype, should be allowed
//http://weiyang.wordpress.ncsu.edu/2013/04/11/a-limitation-in-intent-filter-of-android-application/
	  // .* was a greedy search,taking all of the letters prior to the postfix, however as patternsimpleglob states, it will only take a character
	  // (.)*\.mytype should work for anything prior to .mytype but it does not
   }

}
