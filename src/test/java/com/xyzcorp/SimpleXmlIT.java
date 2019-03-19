package com.xyzcorp;

import com.consol.citrus.annotations.CitrusXmlTest;
import com.consol.citrus.dsl.junit.JUnit4CitrusTest;
import com.consol.citrus.junit.AbstractJUnit4CitrusTest;
import org.junit.Test;


public class SimpleXmlIT extends AbstractJUnit4CitrusTest {

    /**
     * This is just an empty method
     * The actual test implementation is in the
     * SimpleXmlIT.xml file inside of
     * resources.
     */
    @Test
    @CitrusXmlTest(name = "SimpleXmlIT")
    public void emailTest() {
    }
}
