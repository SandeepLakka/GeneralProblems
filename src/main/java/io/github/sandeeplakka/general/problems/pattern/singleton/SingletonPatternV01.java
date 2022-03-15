package io.github.sandeeplakka.general.problems.pattern.singleton;

public class SingletonPatternV01 {
    private static final SingletonPatternV01 instance = new SingletonPatternV01();
    private static int val;

    private SingletonPatternV01() {
        val++;
    }

    public void printValue() {
        System.out.println(val);
    }

    public static void main(String[] args) {
        SingletonPatternV01.instance.printValue();
        System.out.println("--");
        SingletonPatternV01.instance.printValue();
    }

}
