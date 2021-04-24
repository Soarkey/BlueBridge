package jvm;

/**
 * LambdaTest class
 *
 * @author Soarkey
 * @date 2021/4/24
 */

@FunctionalInterface
interface Func {
    public boolean func(String s);
}

public class LambdaTest {
    public void lambda(Func func) {
        return;
    }

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();

        Func func = s -> {
            return true;
        };

        lambdaTest.lambda(func);
        lambdaTest.lambda(s -> {
            return false;
        });

    }
}
