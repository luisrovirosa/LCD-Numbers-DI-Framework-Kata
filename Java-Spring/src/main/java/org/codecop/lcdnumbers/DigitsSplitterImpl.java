package org.codecop.lcdnumbers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Splits into digits and converts digits to LCD digits.
 */
public class DigitsSplitterImpl implements DigitsSplitter {

    private NumeralSystem numeralSystem;
    private DigitFactory digitFactory;

    public DigitsSplitterImpl() {
        numeralSystem = new NumeralSystemProvider().createNumeralSystem();
        digitFactory = new DigitFactoryImpl();
    }

    @Override
    public List<Digit> convert(int number) {
        List<Integer> numeralDigits = numeralSystem.digitsOf(number);

        return numeralDigits.stream(). //
                map(digitFactory::create). //
                collect(Collectors.toList());
    }
}