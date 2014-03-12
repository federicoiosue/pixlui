/*
 Copyright 2014 Federico Iosue (federico.iosue@gmail.com)

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this

file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under

the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF 

ANY KIND, either express or implied. See the License for the specific language governing

permissions and limitations under the License.
 */
package com.neopixl.pixlui.links;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlCompleter {

	public static String complete(String s) {
		// Matcher matching the pattern
		Matcher m;
		
//		for (Pattern pattern : RegexPatternsConstants.patterns) {
//			m = pattern.matcher(s);
//			if (m.matches()) {
//				if (pattern.equals(RegexPatternsConstants.EMAIL)) {
//					s = "mailto:" + s;
//				}
//				else if (pattern.equals(RegexPatternsConstants.HYPER_LINK) && !s.toLowerCase().startsWith("http")) {
//					s = "http://" + s;
//				}
//				else if (pattern.equals(RegexPatternsConstants.PHONE)) {
//					s = "tel:" + s;
//				}
//				break;
//			}
//		}

		if (RegexPatternsConstants.EMAIL.matcher(s).matches()) {
			s = "mailto:" + s;
		}
		else if (RegexPatternsConstants.HYPER_LINK.matcher(s).matches() && !s.toLowerCase().startsWith("http")) {
			s = "http://" + s;
		}
		else if (RegexPatternsConstants.PHONE.matcher(s).matches()) {
			s = "tel:" + s;
		}
		
		
		
		return s;
	}
}
