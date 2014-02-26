package com.neopixl.pixlui.links;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlCompleter {

	public static String complete(String s) {
		String res = null;
		// Matcher matching the pattern
		Matcher m;
		
		for (Pattern pattern : RegexPatternsContants.patterns) {
			m = pattern.matcher(s);
			if (m.matches()) {
				if (pattern.equals(RegexPatternsContants.EMAIL) && !s.contains("mailto:")) {
					res = "mailto:" + s;
				}
				else if (pattern.equals(RegexPatternsContants.WWW)) {
					res = "http://:" + s;
				}
				break;
			}
		}
		return res;
	}
}
