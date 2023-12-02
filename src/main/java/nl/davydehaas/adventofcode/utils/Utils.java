package nl.davydehaas.adventofcode.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public final class Utils {
    
    public static void timeSolution(Supplier<Integer> supplier) {
        long startTime = System.nanoTime();
        int result = supplier.get();
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000F;
        System.out.printf("""
                Result:
                %s
                Duration (ms):
                %s""", result, duration);
    }
    
    public static void timeSolution(Runnable runnable) throws InterruptedException {
        Thread thread = new Thread(runnable);
        long startTime = System.nanoTime();
        
        thread.start();
        thread.join();
        
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000F;
        
        System.out.println(duration + " ms");
    }
    
    public static List<String> readFile(String pathName) {
        try {
            return new ArrayList<>(Files.readAllLines(Path.of(String.format("src/main/resources/%s", pathName))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
