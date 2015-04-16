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

   // read blog for qualifiers example, look arounds should be easy enough to understand

public class AdvancedRegex extends AndroidTestCase {


   public void testGroupsNonCapt(){

	  assertEquals(true, Pattern.matches("(.)((b|d).)", "abc")); // subgroups, where group b|d would be group(3)

	  assertEquals(true, Pattern.matches("(.)((?:b|d).)", "abc")); // dealing with noncapturing groups, there is no group(3)

	  Pattern p = Pattern.compile("a((b)c)");
	  Pattern pp = Pattern.compile("a((?:b)c)"); // should not be captured

	  Matcher m = p.matcher("abc"); // which should match for both
	  Matcher mm = pp.matcher("abc");

	  // Log.e(getClass().getSimpleName(), m.group(2)); // either you can't log with debugging, or groups dont work

	  // Log.e(getClass().getSimpleName(), mm.group(2));

	  assertNotSame(mm.group(2), m.group(2)); // group to should not exist
   }

   public void testGroups(){

	  Pattern pat = Pattern.compile("(A1)");
	  Matcher mat = pat.matcher("A1");
	  String str = mat.group(0); // outputs a1 // don't know the problem

	  assertEquals("A1", str);
   }
}


























