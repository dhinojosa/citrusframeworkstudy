package com.xyzcorp;


import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.junit.JUnit4CitrusTestDesigner;
import org.junit.Test;

public class SimpleTestDesignerIT extends JUnit4CitrusTestDesigner {
    @Test
    @CitrusTest(name = "MyFirstTestDesigner")
    public void myFirstTest() {
        description("First example showing the basic test case definition elements!");
        variable("text", "Hello Test Framework");
        echo("${text}");
    }
}