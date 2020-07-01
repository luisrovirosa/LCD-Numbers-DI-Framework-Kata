package org.codecop.lcdnumbers;

import org.springframework.boot.ApplicationArguments;

import java.util.List;

public class ScalingArgument {

    private List<String> nonOptionArgs;

    public ScalingArgument(ApplicationArguments args) {
        nonOptionArgs = args.getNonOptionArgs();
    }

    public Scaling getScaling() {
        return nonOptionArgs.size() > 1 ? Scaling.of(Integer.parseInt(nonOptionArgs.get(1))) : Scaling.NONE;
    }
}
