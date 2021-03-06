package org.codecop.lcdnumbers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Appends lines next to each other and adds line breaks.
 */
public class DigitPrinterImpl implements DigitPrinter {

    private static final String NEWLINE = "\n";

    private Zipper zipper;

    public DigitPrinterImpl() {
        zipper = new ZipperImpl();
    }

    @Override
    public String render(List<Digit> digits) {
        List<List<Line>> linesOfAllDigits = linesOfAllDigits(digits);
        List<String> linesSideBySide = zip(linesOfAllDigits);
        return join(linesSideBySide);
    }

    private List<List<Line>> linesOfAllDigits(List<Digit> digits) {
        return digits.stream(). //
                map(Digit::lines). //
                collect(Collectors.toList());
    }

    private List<String> zip(List<List<Line>> linesOfAllDigits) {
        return zipper.zip(linesOfAllDigits, this::concat);
    }

    private String concat(List<Line> lines) {
        return lines.stream(). //
                map(Line::toString). //
                collect(Collectors.joining());
    }

    private String join(List<String> lines) {
        return lines.stream(). //
                collect(Collectors.joining(NEWLINE, "", NEWLINE));
    }

}
