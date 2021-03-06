/*
 * Created on Apr 5, 2008
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2008-2013 the original author or authors.
 */
package org.fest.swing.driver;

import static org.fest.assertions.Assertions.assertThat;

import org.fest.swing.test.swing.TestWindow;
import org.junit.Test;

/**
 * Tests for {@link WindowDriver#moveToBack(java.awt.Window)}.
 *
 * @author Alex Ruiz
 */
public class WindowDriver_moveToBack_Test extends WindowDriver_TestCase {
  @Test
  public void should_move_Window_to_back() {
    // TODO(alruiz): Test on Windows
    showWindow();
    TestWindow window2 = TestWindow.createAndShowNewWindow(getClass());
    assertThat(isActive(window2)).isTrue();
    driver.moveToBack(window2);
    assertThat(isActive(window2)).isFalse();
  }
}
