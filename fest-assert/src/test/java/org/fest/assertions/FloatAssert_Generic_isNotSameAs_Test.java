/*
 * Created on 2010-4-29
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright @2007-2010 the original author or authors.
 */

package org.fest.assertions;

/**
 * Test ensuring that {@link org.fest.assertions.FloatAssert} obeys the {@link org.fest.assertions.GenericAssert#isNotSameAs(Object)}
 * contract for {@link Float}.
 */
public class FloatAssert_Generic_isNotSameAs_Test extends GenericAssert_isNotSameAs_TestBase<Float> {

  @Override
  protected Float createEight() {
    return new Float(8.0f);
  }

  @Override
  protected String eightAsString() {
    return "8.0";
  }

  @Override
  protected FloatAssert assertionFor(Float actual) {
    return new FloatAssert(actual);
  }
}