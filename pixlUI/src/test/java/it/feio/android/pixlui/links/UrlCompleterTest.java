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

import org.junit.Assert;
import org.junit.Test;


public class UrlCompleterTest {

	@Test
	public void testCompleteEmail() {
		String email = "test-email@email.com";
		Assert.assertEquals(UrlCompleter.complete(email), "mailto:" + email);
	}

	@Test
	public void testCompleteHashtag() {
		String hashtag = "#testHashtag";
		Assert.assertEquals(UrlCompleter.complete(hashtag), UrlCompleter.HASHTAG_SCHEME + hashtag);

		String numericHashtag = "#123Stella";
		Assert.assertEquals(UrlCompleter.complete(numericHashtag), UrlCompleter.HASHTAG_SCHEME + numericHashtag);
	}
}
