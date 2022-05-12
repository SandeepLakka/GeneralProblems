package io.github.sandeeplakka.general.problems.pattern.singleton;

public class SingletonPatternV01 {
    private static final SingletonPatternV01 instance = new SingletonPatternV01();
    private static int val;

    public static int getVal() {
        return val;
    }

    public static SingletonPatternV01 getInstance() {
        return instance;
    }

    private SingletonPatternV01() {
        val++;
    }


}
