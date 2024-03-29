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

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NiceGuyTest {
	@Test
	public void sayHi() throws Exception {
		assertThat("Bonjour!").isEqualTo(new FrenchNiceGuy().sayHi());
	}

	@Test
	public void notSayingHi() throws Exception {
		assertThat("Au revoir!").isNotEqualTo(new FrenchNiceGuy().sayHi());
	}

	@Test
	public void sayHiUS() throws Exception {
		assertThat("Au revoir!").isNotEqualTo(new AmericanNotSoNiceGuy().sayHi());
		assertThat("Hi motherfucker!").isEqualTo(new AmericanNotSoNiceGuy().sayHi());
	}
}
