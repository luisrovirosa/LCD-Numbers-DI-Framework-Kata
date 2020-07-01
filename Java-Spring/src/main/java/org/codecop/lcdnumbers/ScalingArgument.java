package org.codecop.lcdnumbers;

import java.util.List;

public class ScalingArgument {

    private List<String> nonOptionArgs;

    public ScalingArgument(List<String> nonOptionArgs) {
        this.nonOptionArgs = nonOptionArgs;
    }

    public Scaling getScaling() {
        return nonOptionArgs.size() > 1 ? Scaling.of(Integer.parseInt(nonOptionArgs.get(1))) : Scaling.NONE;
    }
}
