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

	// Pattern for gathering http:// or www links
	public static final Pattern HYPER_LINK = Pattern
			.compile("([Hh][tT][tT][pP][sS]?:\\/\\/[^ ,'\'>\\]\\)]*[^\\. ,'\'>\\]\\)])");
}
