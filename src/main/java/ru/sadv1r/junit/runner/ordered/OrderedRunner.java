package ru.sadv1r.junit.runner.ordered;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.ArrayList;
import java.util.List;

/**
 * The custom runner for Junit that allows the user to choose the order
 * of execution of the methods within a test class.
 * <p>
 * It's recommended that test methods be written so they are independent
 * of the order that they are executed.
 * However, there may be a number of dependent tests either through error or by design.
 */
public class OrderedRunner extends BlockJUnit4ClassRunner {
    /**
     * Creates a OrderedRunner to run {@code clazz}
     *
     * @throws InitializationError if the test class is malformed.
     */
    @SuppressWarnings("WeakerAccess")
    public OrderedRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> list = super.computeTestMethods();
        List<FrameworkMethod> copy = new ArrayList<>(list);

        copy.sort((f1, f2) -> {
            Order o1 = f1.getAnnotation(Order.class);
            Order o2 = f2.getAnnotation(Order.class);

            if (o1 == null && o2 == null) {
                return 0;
            }

            if (o1 == null) {
                return 1;
            }

            if (o2 == null) {
                return -1;
            }

            return o1.value() - o2.value();
        });

        return copy;
    }
}