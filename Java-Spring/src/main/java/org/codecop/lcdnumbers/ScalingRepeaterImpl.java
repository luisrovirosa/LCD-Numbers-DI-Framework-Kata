package org.codecop.lcdnumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Repeat objects and characters according to scaling.
 */
public class ScalingRepeaterImpl implements ScalingRepeater {

    @Override
    public <T> List<T> repeat(T element, Scaling scaling) {
        List<T> elements = new ArrayList<>();
        scaling.times(() -> elements.add(element));
        return elements;
    }

    @Override
    public String repeat(char aChar, Scaling scaling) {
        StringBuilder acc = new StringBuilder();
        scaling.times(() -> acc.append(aChar));
        return acc.toString();
    }
}
