package com.nullcognition.javaregularexpressions;

import junit.framework.TestCase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ersin on 13/04/15 at 11:20 PM
 */
public class MatcherAndPattern extends TestCase {

   public void testMethod(){

	  Pattern p0 = Pattern.compile("./d", Pattern.CASE_INSENSITIVE);
	  Pattern p1 = Pattern.compile("./d #this is a comment", Pattern.COMMENTS);
	  Pattern p2 = Pattern.compile("./d", Pattern.DOTALL); // dot may match line endsings
	  Pattern p3 = Pattern.compile("./d", Pattern.LITERAL); // first parameter is literal

	  boolean isMatch = Pattern.matches("..", "ab"); // same as Pattern.compile(regEx).matcher(input).matches();

	  int i = p0.flags();
	  Matcher matcherWithInputText = p0.matcher("i3");
	  String stringOfThePattern = p0.pattern();
	  String[] splitArray = p0.split("some input that should have at least one occurence of pattern a5 to be used as i3 the split point", 1);
	  // if the pattern does not occur, output is a string
	  // if it does, limit controls the max number of entries in the array and how the trailing empty strings are dealt with
	  String[] stringArrayOfTheSplit = p0.split("input will be split here3,the trailing text will not be used");

	  String patternIsLiteral = Pattern.quote("/d"); // same as using the .LITERAL flag
	  String patternIsAlsoLiteral = Matcher.quoteReplacement("/d");

	  Matcher m = p0.matcher("some input4 that should match");
	  Pattern thePatternUsedWithTheMatcher = m.pattern();
	  Matcher regonizedMatecher = m.region(5,15); // only the region of character 5-15 will be consiered for the match

	  // TODO finish matcher methods and then read chapter3? validate the chapter

   }

}
