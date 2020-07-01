package org.codecop.lcdnumbers;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LcdMainTest {
    private Main lcdMain;
    private final ByteArrayOutputStream outputStream;

    public LcdMainTest() {
        lcdMain = new Main();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void lcdAllDigitsOfSize2() throws IOException {
        lcdMain.doRun(Arrays.asList("1234567890", "2"));

        assertEquals(Input.join(Input.allDigitsSize2()), outputStream.toString());
    }

    @Test
    public void lcdAllDigitsDefaultSize() throws IOException {
        lcdMain.doRun(Arrays.asList("1234567890"));

        assertEquals(Input.join(Input.allDigitsSize1()), outputStream.toString());
    }
}
