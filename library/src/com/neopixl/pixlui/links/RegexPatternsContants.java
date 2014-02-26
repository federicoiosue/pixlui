/*
 Copyright 2013 Neopixl

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this

file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under

the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF 

ANY KIND, either express or implied. See the License for the specific language governing

permissions and limitations under the License.
 */
package com.neopixl.pixlui.links;

import java.util.regex.Pattern;

public class RegexPatternsContants {
	
	
	// Pattern for gathering @usernames 
	public static final Pattern SCREEN_NAME = Pattern.compile("(@[a-zA-Z0-9_]+)");

	// Pattern for gathering #hasttags 
	public static final Pattern HASH_TAG = Pattern.compile("(#[a-zA-Z0-9_-]+)");

	// Pattern for gathering http:// links
	public static final Pattern HYPER_LINK = Pattern
//			.compile("([Hh][tT][tT][pP][sS]?:\\/\\/[^ ,'\'>\\]\\)]*[^\\. ,'\'>\\]\\)])");
			.compile("([Hh][tT][tT][pP][sS]?:\\/\\/([wW][wW][wW]\\.)*[^ ,'\'>\\]\\)]*[^\\. ,'\'>\\]\\)])");
	
	// Pattern for gathering e-mail
	public static final Pattern EMAIL = Pattern
//			.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	.compile("[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})");
	
	// Pattern for gathering internet domains
	public static final Pattern DOMAIN = Pattern
//			.compile("^[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
//			.compile("^([wW][wW][wW]\\.)*[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
			.compile("([wW][wW][wW]\\.)*[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})");
	
	// Pattern for gathering www adresses
	public static final Pattern WWW = Pattern
//			.compile("^[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
//			.compile("^([wW][wW][wW]\\.)*[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
			.compile("([wW][wW][wW]\\.)+[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})");
	
	// Pattern for gathering IP adresses
	public static final Pattern IP_ADDRESS = Pattern
			.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
	
	
	

	/**
	 * Insert here the pattern you want to match in EditText
	 */
	public static final Pattern[] patterns = {HYPER_LINK, EMAIL, WWW};
}
