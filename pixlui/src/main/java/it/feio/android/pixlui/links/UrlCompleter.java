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
package it.feio.android.pixlui.links;

import java.util.Locale;
import java.util.regex.Matcher;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UrlCompleter {
	
	public static final String HASHTAG_SCHEME = "hashtag:";

	public static String complete(String s) {

		String urlCompleted = s;

		if (RegexPatternsConstants.EMAIL.matcher(s).matches()) {
			urlCompleted = "mailto:" + s;
		}
		else if (RegexPatternsConstants.HYPER_LINK.matcher(s).matches()) {
			if (!s.toLowerCase(Locale.getDefault()).startsWith("http")) {
				urlCompleted = "http://" + s;
			}
		}
		else if (RegexPatternsConstants.HASH_TAG.matcher(s).find()) {
			urlCompleted = HASHTAG_SCHEME + parseHashtag(s);
		}
		else if (RegexPatternsConstants.PHONE.matcher(s).matches()) {
			urlCompleted = "tel:" + s;
		}
		
		return urlCompleted;
	}

	public static String parseHashtag(String token) {
		Matcher matcher = RegexPatternsConstants.HASH_TAG.matcher(token);
		if (matcher.find()) {
			return matcher.group();
		}
		return "";
	}
}
