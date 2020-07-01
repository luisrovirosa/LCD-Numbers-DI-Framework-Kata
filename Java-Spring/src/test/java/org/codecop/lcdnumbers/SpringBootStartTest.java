package org.codecop.lcdnumbers;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;

public class SpringBootStartTest {

    @Test
    public void lcdAllDigitsOfSize2() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        new Main().doRun(Arrays.asList("1234567890", "2"));
        assertThat(outputStream.toString(), endsWith(Input.join(Input.allDigitsSize2())));
    }
}
