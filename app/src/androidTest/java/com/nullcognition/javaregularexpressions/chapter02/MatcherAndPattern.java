package com.nullcognition.javaregularexpressions.chapter02;

import junit.framework.TestCase;

import java.util.regex.MatchResult;
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
	  Matcher regonizedMatecher = m.region(5, 15); // only the region of character 5-15 will be consiered for the match
	  Matcher resetMatcher = m.reset();// resets the matcher, inputs wilrl be lost

	  String replaceAll = m.replaceAll("'There should have been a pattern where I am'"); // replaces the pattern, if found, with the input text
	  Pattern thePatternUsedWithTheMatcher = m.pattern();

	  int theFirstIndexOfTheFoundMatcher = m.start();

	  MatchResult matchResult = m.toMatchResult();// independant from the matcher, unaffected of matchers state chanage, is now a MatchResult, else throw IllegalStateException
	  // MatchResult is an interface that, holds the state of the matcher of the results of a successful match of a pattern against the input string
	  matchResult.group(); // returns the text that matched the whole regular expression
	  matchResult.groupCount(); // returns the number of groups in the result
	  matchResult.start(); // index of first character that matched the whole regular expression
	  matchResult.end(); // indexd of last...

	  Matcher anchoringBounds = m.useAnchoringBounds(true); // enabled by default, start and end of input match the ^ and $ meta characters

	  m.usePattern(p1); // uses new pattern, previous find results are lost, next attempt to find patterns occurrence are reset

	  Matcher transparentBounds = m.useTransparentBounds(true); // outside of region are subject to lookahead/behind, false by default
	  // collectively called lookaround are zero length assertions that matches characters, but then gives up the match, returning only the result: match or no match
	  // allowing you to create regular expressions that are impossible to create without them, or that would get very longwinded without them

	  Matcher appendedWithReplacementText = m.appendReplacement(new StringBuffer(), "Text that will be appended at whatever location is needed"); //
	  StringBuffer appendedTailText = m.appendTail(new StringBuffer()); // allows for the rest of the input text to be appendded, as the matcher will stop at the last match
	  int firstCharacterThatAfterLastMatch = m.end();
	  boolean isAnotherMatch = m.find();
	  String groupThatMatches = m.group(); // group that matched the whole regex, or if int is provided, returns the group
	  int numberOfGroupsInTheResult = m.groupCount();
	  boolean isUsingAnchoring = m.hasAnchoringBounds();
	  boolean ifMatchIsAvailiblePastTheEndBecauseOfASearch = m.hitEnd(); // this will return true, additional input might yield more results
	  boolean isThereAMatch = m.lookingAt(); // does not require to match over the whole region, returns true if there is a match
	  boolean mustMatchEntireRegionOrInput = m.matches();
   }

}
