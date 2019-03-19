package com.xyzcorp;

import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.junit.JUnit4CitrusTestRunner;
import com.consol.citrus.dsl.runner.TestRunner;
import org.junit.Test;

/**
 * Test a connection of your service with an email
 *
 * @author Daniel Hinojosa
 * @since 2019-03-13
 */
public class EmailIT extends JUnit4CitrusTestRunner {
    @CitrusTest
    @Test
    public void emailTest(@CitrusResource TestRunner testRunner) {
        testRunner.echo("TODO: Code the test EmailTest");
    }
}
