package com.acme.edu.unittests;

import com.acme.edu.LoggerSaver;
import com.acme.edu.Saver;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SaverTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion
    @Test
    public void shouldSaveString() {
        Saver saver = new LoggerSaver();
        String output = "test output";
        saver.save(output);
        assertSysoutEquals("test output");
    }

    @Test
    public void shouldNotSaveNull() {
        Saver saver = new LoggerSaver();
        String output = null;
        saver.save(output);
        assertSysoutNotEquals("null");
    }

    @Test
    public void saveStringAndNull() {
        Saver saver = new LoggerSaver();
        String output = "test output";
        String nullOutput = null;
        saver.save(output);
        saver.save(nullOutput);
        assertSysoutEquals("test output");
    }
}
