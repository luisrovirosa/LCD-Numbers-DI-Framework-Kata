package org.codecop.lcdnumbers;

import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class ScalingArgument {

    private ApplicationArguments args;

    public ScalingArgument(ApplicationArguments args) {
        this.args = args;
    }

    @Bean
    public Scaling getScaling() {
        List<String> nonOptionArgs = args.getNonOptionArgs();
        Scaling scaling = nonOptionArgs.size() > 1 ? Scaling.of(Integer.parseInt(nonOptionArgs.get(1))) : Scaling.NONE;
        return scaling;
    }
}
