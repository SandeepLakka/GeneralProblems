package io.github.sandeeplakka.general.problems.pattern.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Driver {

    public static void main(String[] args) {
        Supplier<OnDemandSingleton> onDemandSingletonSupplier = OnDemandSingleton::getInstance;
        testNormally(onDemandSingletonSupplier);
        testParallelly(onDemandSingletonSupplier);
    }

    public static <T> void testParallelly(Supplier<T> supplier) {

        String cut = supplier.get().getClass().getSimpleName();
        try {
            ExecutorService service = Executors.newFixedThreadPool(20);
            service.invokeAll(IntStream.of(0, 20).<Callable<T>>mapToObj((value) -> supplier::get).collect(Collectors.toList()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<T> list = IntStream.range(0, 100)
                .parallel()
                .mapToObj(value -> supplier.get())
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        boolean isPassed = getResult(list);
        printResults("Parallel Testing", cut, isPassed);

    }

    public static <T> void testNormally(Supplier<T> supplier) {
        String cut = supplier.get().getClass().getSimpleName();
        List<T> list = new ArrayList<>();
        boolean isPassed;
        list.add(supplier.get());
        list.add(supplier.get());
        list.add(supplier.get());
        isPassed = getResult(list);
        printResults("Normal Testing", cut, isPassed);
    }

    private static <T> boolean getResult(List<T> list) {
        System.out.println("length is " + list.size());
        boolean isPassed = true;
        for (int i = 1; i < list.size(); i++) {
            isPassed = isPassed && (list.get(i - 1) == list.get(i));
            if (!isPassed) {
                System.err.println("Object1 : " + list.get(i - 1) + " and Object2 : " + list.get(i));
                return isPassed;
            }
        }
        return isPassed;
    }

    private static void printResults(String testName, String cut, boolean isPassed) {
        if (isPassed) {
            System.out.printf("%s of %s is success%n", testName, cut);
        } else {
            System.err.printf("%s of %s is failed%n", testName, cut);
        }
    }
}
