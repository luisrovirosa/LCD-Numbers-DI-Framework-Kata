package org.codecop.lcdnumbers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Splits into digits and converts digits to LCD digits.
 */
@Service
public class DigitsSplitterImpl implements DigitsSplitter {

    private NumeralSystem numeralSystem;
    private DigitFactory digitFactory;

    public DigitsSplitterImpl() {
        numeralSystem = new NumeralSystemImpl(10);
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