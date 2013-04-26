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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class NiceGuyManager {
	private final Map<String, NiceGuy> gentlemen = new HashMap<String, NiceGuy>();

	public NiceGuyManager() {
		ServiceLoader<NiceGuy> gentlemenServiceLoader = ServiceLoader.load(NiceGuy.class);
        Iterator<NiceGuy> iterator = gentlemenServiceLoader.iterator();
        for (NiceGuy gentleman; iterator.hasNext(); ) {
            try {
                gentleman = iterator.next();
                gentlemen.put(gentleman.getLocale(), gentleman);
            } catch (ServiceConfigurationError error) {
            	// can be logged
            }
        }
	}
	
	public boolean isLanguageSpeaken(String language) {
		return gentlemen.containsKey(language);
	}
	
	public NiceGuy forLocale(String language)
			throws ClassNotFoundException {
		NiceGuy gentleman = gentlemen.get(language);
        if (gentleman == null) {
            throw new ClassNotFoundException(String.format("There is no class that can manage the language %s",
                    language));
        }
        return gentleman;
	}

}