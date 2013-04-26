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

import java.io.IOException;
import java.util.Properties;

public class NiceGuyManager {
	private final Properties gentlemen = new Properties();
	public NiceGuyManager() throws IOException {
		this.gentlemen.load(NiceGuyManager.class.getResourceAsStream("/languages.properties"));
	}
	
	public boolean isLanguageSpeaken(String language) {
		return gentlemen.containsKey(language);
	}
	
	public NiceGuy forLocale(String language)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException { 
		if (!isLanguageSpeaken(language)) {
			throw new ClassNotFoundException(String.format("The language %s is not recognized", language));
		}
		return (NiceGuy) Class.forName(gentlemen.get(language).toString()).newInstance();
	}

}