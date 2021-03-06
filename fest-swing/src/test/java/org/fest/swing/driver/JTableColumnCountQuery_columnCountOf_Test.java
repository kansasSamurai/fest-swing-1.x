/*
 * Created on Aug 10, 2008
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
import static org.fest.swing.edt.GuiActionRunner.execute;

import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.test.core.MethodInvocations;
import org.fest.swing.test.core.RobotBasedTestCase;
import org.fest.swing.test.swing.TestTable;
import org.fest.swing.test.swing.TestWindow;
import org.junit.Test;

/**
 * Tests for {@link JTableColumnCountQuery#columnCountOf(javax.swing.JTable)}.
 * 
 * @author Alex Ruiz
 */
public class JTableColumnCountQuery_columnCountOf_Test extends RobotBasedTestCase {
  private static final int COLUMN_COUNT = 6;

  private MyTable table;

  @Override
  protected void onSetUp() {
    MyWindow window = MyWindow.createNew();
    table = window.table;
  }

  @Test
  public void should_return_column_count() {
    table.startRecording();
    assertThat(JTableColumnCountQuery.columnCountOf(table)).isEqualTo(COLUMN_COUNT);
    table.requireInvoked("getColumnCount");
  }

  private static class MyWindow extends TestWindow {
    final MyTable table = new MyTable();

    @RunsInEDT
    static MyWindow createNew() {
      return execute(new GuiQuery<MyWindow>() {
        @Override
        protected MyWindow executeInEDT() {
          return new MyWindow();
        }
      });
    }

    private MyWindow() {
      super(JTableColumnCountQuery_columnCountOf_Test.class);
      addComponents(table);
    }
  }

  private static class MyTable extends TestTable {
    private boolean recording;
    private final MethodInvocations methodInvocations = new MethodInvocations();

    MyTable() {
      super(2, COLUMN_COUNT);
    }

    @Override
    public int getColumnCount() {
      if (recording) {
        methodInvocations.invoked("getColumnCount");
      }
      return super.getColumnCount();
    }

    void startRecording() {
      recording = true;
    }

    MethodInvocations requireInvoked(String methodName) {
      return methodInvocations.requireInvoked(methodName);
    }
  }
}
