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

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NiceGuyTest {

	@Test
	public void sayHi() {
		assertThat("Bonjour!").isEqualTo(new NiceGuy().sayHi());
	}

	@Test
	public void sayHiFR() {
		assertThat("Bonjour!").isEqualTo(new NiceGuy("fr").sayHi());
	}

	@Test
	public void notSayingHi() {
		assertThat("Au revoir!").isNotEqualTo(new NiceGuy().sayHi());
	}

	@Test(expected = IllegalStateException.class)
	public void unknownLocale() {
		assertThat("Au revoir!").isEqualTo(new NiceGuy("etps").sayHi());
	}
}