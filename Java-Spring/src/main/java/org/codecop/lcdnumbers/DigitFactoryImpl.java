package org.codecop.lcdnumbers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Creates (LCD) digits from patterns.
 */
public class DigitFactoryImpl implements DigitFactory {

    private Patterns patterns;

    public DigitFactoryImpl() {
        patterns = new PatternsImpl();
    }

    @Override
    public Digit create(int digit) {
        return new Digit(digit, patterns);
    }
}
