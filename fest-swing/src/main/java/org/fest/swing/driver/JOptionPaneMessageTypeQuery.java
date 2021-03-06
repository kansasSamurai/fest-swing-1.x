/*
 * Created on Aug 21, 2008
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

import static org.fest.swing.edt.GuiActionRunner.execute;
import static org.fest.util.Preconditions.checkNotNull;

import javax.annotation.Nonnull;
import javax.swing.JOptionPane;

import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.edt.GuiQuery;

/**
 * Returns the type of message of a {@code JOptionPane}. This query is executed in the event dispatch thread (EDT.)
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
class JOptionPaneMessageTypeQuery {
  @RunsInEDT
  static int messageTypeOf(final @Nonnull JOptionPane optionPane) {
    Integer result = execute(new GuiQuery<Integer>() {
      @Override
      protected Integer executeInEDT() throws Throwable {
        return optionPane.getMessageType();
      }
    });
    return checkNotNull(result);
  }

  private JOptionPaneMessageTypeQuery() {}
}