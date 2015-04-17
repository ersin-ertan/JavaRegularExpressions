package com.nullcognition.javaregularexpressions.chapter03;

import android.test.AndroidTestCase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ersin on 14/04/15 at 3:59 PM
 */

/*
	concepts, including groups, subgroups, noncapturing groups, greedy qualifiers, positive qualifiers, reluctant qualifiers,
	positive lookaheads, negative lookaheads, positive lookbehinds, and negative lookbehinds.
*/


public class AdvancedRegex extends AndroidTestCase {

   // REMEMBER THAT THE matcher.find() IS NEEDED TO WORK WITH GROUPS, code is fixed look at examples

   public void testGroupsNonCapt(){

	  assertEquals(true, Pattern.matches("(.)((b|d).)", "abc")); // subgroups, where group b|d would be group(3)

	  assertEquals(true, Pattern.matches("(.)((?:b|d).)", "abc")); // dealing with noncapturing groups, there is no group(3)

	  Pattern p = Pattern.compile("a((b)c)");
	  Pattern pp = Pattern.compile("a(?:(b)c)"); // should not be captured

	  Matcher m = p.matcher("abc"); // which should match for both
	  Matcher mm = pp.matcher("abc");

	  m.find();
	  mm.find();
	  // Log.e(getClass().getSimpleName(), m.group(2)); // either you can't log with debugging, or groups dont work

	  // Log.e(getClass().getSimpleName(), mm.group(2));

	  assertEquals("bc", m.group(1)); // group one is bc
	  assertEquals("b", m.group(2)); // group c is b in m

	  assertEquals("b", mm.group(1)); // but group one is b is mm
   }

   public void testGroups(){

	  Pattern pat = Pattern.compile("(A1)");
	  Matcher mat = pat.matcher("A1");
	  mat.find();
	  String str = mat.group(0); // outputs a1 // don't know the problem // to fix mat.find() to return the first group

	  assertEquals("A1", str);
   }

   // greedy will match more than it is needed but will release if next quantifier needs the char for a match
   public void testGreedyQuantifiers(){

	  String[] inputs = {"aabcdeeee", "aabce", "aabe", "aabccccccccde"};

	  // non capture, match exactly 2 times, zero or more, zero or one, one or more
	  Pattern pattern = Pattern.compile("(?:a{2})(bc*)(d?)(e+)"); // note that the astrisk quantifier is only for the c in group 2, move it
	  // to the right of the ( parentheses to apply it to the whole group, see inputs[2]

	  Matcher matcher;

	  for(String _inputs : inputs){
		 matcher = pattern.matcher(_inputs);
		 assertTrue(matcher.matches());
	  }
   }

   public void testPossessiveQuantifiers(){

	  assertFalse(Pattern.matches("\\w++\\w", "TwoWords")); // the possessive \w++ does not give up the second word for \w to match
	  // remember, in java the extra \ is needed on the \ for the regex engine to recognize it as a regex command
   }

   public void testReluctantQuantifier(){

	  Pattern pattern = Pattern.compile("(\\d+?)"); // group(0) is the whole match only
	  Matcher matcher = pattern.matcher("123");

	  boolean isMatch = matcher.find(); // required to move to the next occurance of the group, to work with groups

	  assertEquals("1", matcher.group(0)); // group 0, and 1(only if there is a () group around the pattern) show the same thing,
	  // should only be the matched group of 1 due to the reluctant qualifier that will be
	  // satisfied with the first character it gets

	  Pattern pattern1 = Pattern.compile("\\d+?\\d+?");
	  Matcher matcher1 = pattern1.matcher("123");

	  // matcher1.find(); double matches do not work in this specific case
	  matcher1.find(); // with out this, should fail
	  assertEquals("12", matcher1.group(0));

   }

   public void testLookarounds(){

	  String input = "abc255.0.0.1";

	  Matcher matcher = null; // error of matcher was not initialized

	  assertEquals(input, matcherHelper(".*(?=255).*", input, matcher).group()); // ?= positive look ahead
	  assertEquals(input, matcherHelper(".*(?!251).*", input, matcher).group()); // ?! negative look ahead

	  // positive and negative lookbehinds, ?<= ?<! to match right before the pattern, need to find in what case this would be
	  // look-behind expressions cannot be of variable length. That means you cannot use quantifiers (?, *, +, or {1,5}) or
	  // alternation of different-length items inside them.

   }

   public Matcher matcherHelper(String pattern, String inputText, Matcher matcher){

	  matcher = (Pattern.compile(pattern)).matcher(inputText);
	  matcher.find();
	  return matcher;
   }
}
