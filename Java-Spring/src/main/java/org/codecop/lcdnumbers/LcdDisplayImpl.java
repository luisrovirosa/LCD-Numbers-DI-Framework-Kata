package org.codecop.lcdnumbers;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Combines Converter, Scaler and Printer.
 */
@Service
public class LcdDisplayImpl implements LcdDisplay {

    private DigitsSplitter digitsSplitter;
    private DigitScaler digitScaler;
    private DigitPrinter digitPrinter;

    public LcdDisplayImpl() {
        digitsSplitter = new DigitsSplitterImpl();
        digitScaler = new DigitScalerImpl();
        digitPrinter = new DigitPrinterImpl();
    }

    @Override
    public String toLcd(int number, Scaling scaling) {
        List<Digit> digits = digitsSplitter.convert(number);
        List<Digit> scaled = digitScaler.scale(digits, scaling);
        return digitPrinter.render(scaled);
    }
}
