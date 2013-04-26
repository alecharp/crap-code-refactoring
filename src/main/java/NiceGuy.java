/*
 * Copyright 2013 Adrien Lecharpentier
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class NiceGuy {
	private final String locale;

	public NiceGuy() { this(null); }
	public NiceGuy(String locale) {
		this.locale = locale;
	}

	public String sayHi() {
		if (locale == null || "fr_FR".equals(locale) || "fr".equalsIgnoreCase(locale)) {
			return "Bonjour!";
		}
		throw new IllegalStateException("The locale is not recognized");
	}
}