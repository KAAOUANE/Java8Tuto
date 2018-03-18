package interfaceFonctionnel;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by admin on 16/03/2018.
 */
public class OldInterfaceFunctionnel {

    //exister deja des interface fonctionnel Runnable et Callable java 5

    @Test
    public void RunnableInterface() {
        Runnable r = () -> System.out.println("Bonjour de la part d'un autre Thread");
        Thread th = new Thread(r);
        th.start();
    }


    @Test
    public void RunnableLamndaInterface() {
        Thread thread = new Thread(() -> System.out.println("Bonjour de la part d'un autre Thread"));
        thread.start();
    }

    @Test
    public void CallableInterface() {
        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Callable<Integer> callableObj = () -> {
            int result = integers.stream().mapToInt(i -> i.intValue()).sum();
            return result;
        };
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(callableObj);
        Integer result = 0;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Sum = " + result);
    }
}
