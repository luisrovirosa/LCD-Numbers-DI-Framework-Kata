package org.codecop.lcdnumbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;

@ExtendWith(OutputCaptureExtension.class)
public class SpringBootStartTest {

    @Test
    public void lcdAllDigitsOfSize2(CapturedOutput output) throws IOException {

        new Main().doRun(((ApplicationArguments) new DefaultApplicationArguments("1234567890", "2")).getNonOptionArgs());
        assertThat(output.getOut(), endsWith(Input.join(Input.allDigitsSize2())));
    }
}
