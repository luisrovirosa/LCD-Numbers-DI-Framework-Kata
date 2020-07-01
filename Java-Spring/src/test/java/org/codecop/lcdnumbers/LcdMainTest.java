package org.codecop.lcdnumbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LcdMainTest {


    private Main lcdMain;

    public LcdMainTest() {
        lcdMain = new Main();
    }

    @Test
    @ExtendWith(OutputCaptureExtension.class)
    public void lcdAllDigitsOfSize2(CapturedOutput output) throws IOException {
        lcdMain.doRun(Arrays.asList("1234567890", "2"));

        assertEquals(Input.join(Input.allDigitsSize2()), output.getOut());
    }

    @Test
    @ExtendWith(OutputCaptureExtension.class)
    public void lcdAllDigitsDefaultSize(CapturedOutput output) throws IOException {

        lcdMain.doRun(Arrays.asList("1234567890"));

        assertEquals(Input.join(Input.allDigitsSize1()), output.getOut());
    }
}
