package io.github.sandeeplakka.general.problems.pattern.singleton;

public class SingletonPatternV02 {
    private static final SingletonPatternV02 instance = new SingletonPatternV02();

    private static int val;

    private SingletonPatternV02() {
        if (instance != null) throw new IllegalAccessError("Single instance is allowed for this Class");
    }

    public void printValue() {
        System.out.println(val);
    }

    public static SingletonPatternV02 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonPatternV02 obj1 = SingletonPatternV02.getInstance();
        obj1.printValue();
        System.out.println("--");
        SingletonPatternV02 obj2 = SingletonPatternV02.getInstance();
        obj2.printValue();
    }

}
