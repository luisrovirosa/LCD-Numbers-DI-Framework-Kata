package org.codecop.lcdnumbers;

public class NumeralSystemProvider {

    private int base = 10;

    public NumeralSystem createNumeralSystem() {
        return new NumeralSystemImpl(base);
    }
}
