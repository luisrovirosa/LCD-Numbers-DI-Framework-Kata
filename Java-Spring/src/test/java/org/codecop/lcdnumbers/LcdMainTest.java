package org.codecop.lcdnumbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LcdMainTest {

    private ApplicationArguments args;

    private Main lcdMain;

    public LcdMainTest() {
        args = mock(ApplicationArguments.class);
        lcdMain = new Main();
    }

    @Test
    @ExtendWith(OutputCaptureExtension.class)
    public void lcdAllDigitsOfSize2(CapturedOutput output) throws IOException {
        when(args.getNonOptionArgs()).thenReturn(Arrays.asList("1234567890", "2"));

        lcdMain.doRun(args.getNonOptionArgs());

        assertEquals(Input.join(Input.allDigitsSize2()), output.getOut());
    }

    @Test
    @ExtendWith(OutputCaptureExtension.class)
    public void lcdAllDigitsDefaultSize(CapturedOutput output) throws IOException {
        when(args.getNonOptionArgs()).thenReturn(Arrays.asList("1234567890"));

        lcdMain.doRun(args.getNonOptionArgs());

        assertEquals(Input.join(Input.allDigitsSize1()), output.getOut());
    }
}
