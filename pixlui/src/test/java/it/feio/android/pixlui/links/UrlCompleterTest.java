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

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static it.feio.android.pixlui.links.UrlCompleter.HASHTAG_SCHEME;
import static it.feio.android.pixlui.links.UrlCompleter.complete;

import org.junit.Test;


public class UrlCompleterTest {

	@Test
	public void complete_Email() {
		String email = "test-email@email.com";
		assertEquals("mailto:" + email, complete(email));
	}

	@Test
	public void complete_numericHashtagFailing() {
		String numericHashtag = "#123Star";
		assertEquals(numericHashtag, complete(numericHashtag));

		String numericWithUnderscoreHashtag = "#_123Star";
		assertEquals(numericWithUnderscoreHashtag, complete(numericWithUnderscoreHashtag));
	}

	@Test
	public void complete_numericHashtag() {
		String numericPostfixHashtag = "#Star123";
		assertEquals(UrlCompleter.HASHTAG_SCHEME + numericPostfixHashtag, complete(numericPostfixHashtag));
	}

	@Test
	public void complete_hashtag() {
		String hashtag = "#testHashtag";
		assertEquals(UrlCompleter.HASHTAG_SCHEME + hashtag, complete(hashtag));
	}

	@Test
	public void complete_hashtagRussian() {
		String hashtag = "#привет";
		assertEquals(UrlCompleter.HASHTAG_SCHEME + hashtag, complete(hashtag));
	}

	@Test
	public void complete_hashtagChinese() {
		String hashtag = "#中华人民共和国";
		assertEquals(UrlCompleter.HASHTAG_SCHEME + hashtag, complete(hashtag));
	}

	@Test
	public void complete_hashtagWithSpecialChars() {
		String hashtag = "#area/bau.ui";
		assertEquals(HASHTAG_SCHEME + "#area", complete(hashtag));
	}

	@Test
	public void complete_hyperlink() {
		String url = "google.com";
		assertTrue(complete(url).startsWith("http://"));
	}

	@Test
	public void complete_hyperlink_invalid() {
		String url = "aaaa.22";
		assertFalse(complete(url).startsWith("http://"));
	}

	@Test
	public void complete_hyperlink_withSslPrefix() {
		String url = "https://reload.alphacomm.network/web/ah";
		assertTrue(complete(url).startsWith("https"));
	}

	@Test
	public void complete_hyperlink_complex() {
		String url = "https://www.anysite.com/1/anysite/3803/product-model/522/elegant-80#toggleOtherComments";
		assertTrue(complete(url).startsWith("https://"));
	}

	@Test
	public void complete_hyperlink_invalidTopLevelDomain() {
		assertEquals("S100.D70.P65,", complete("S100.D70.P65,"));
		assertEquals("aaaa.23", complete("aaaa.23"));
		assertEquals("3.14", complete("3.14"));
		assertEquals("12.34.56", complete("12.34.56"));
	}

	@Test
	public void complete_phoneNumber() {
		assertEquals("tel:1234567", complete("1234567"));
		assertEquals("tel:1234567890", complete("1234567890"));
		assertEquals("tel:+39 333 1234567", complete("+39 333 1234567"));
		assertEquals("tel:333-123-4567", complete("333-123-4567"));
	}

	@Test
	public void complete_shortNumericTokenIsNotAPhoneNumber() {
		assertEquals("123456", complete("123456"));
		assertEquals("2024", complete("2024"));
		assertEquals("ORD-2024-001", complete("ORD-2024-001"));
	}

	@Test
	public void complete_dateIsNotAPhoneNumber() {
		assertEquals("12.03.2024", complete("12.03.2024"));
		assertEquals("2024-10-21", complete("2024-10-21"));
		assertEquals("10/21/24", complete("10/21/24"));
	}

}
