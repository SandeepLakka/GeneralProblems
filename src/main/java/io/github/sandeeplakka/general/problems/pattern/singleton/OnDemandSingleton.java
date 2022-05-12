package io.github.sandeeplakka.general.problems.pattern.singleton;

import java.util.Objects;
import java.util.Random;

public class OnDemandSingleton {
    private static OnDemandSingleton singleton;

    private OnDemandSingleton() {
    }

    public static OnDemandSingleton getInstance() {
        if (singleton == null) {
            singleton = new OnDemandSingleton();
        }
        return singleton;
    }

}
