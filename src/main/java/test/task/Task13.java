package test.task;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Task13 {
    public static void main(String[] args) throws Exception{
        try(var lines = Files.lines(Path.of(ClassLoader.getSystemResource("text.txt").getPath()))) {
            var list = lines.flatMap(s -> Arrays.stream(s.split(" "))).collect(Collectors.toSet());
            String[] array = new String[list.size() + 100];
            for (var s : list) {
                int ind = Math.abs(s.hashCode()) % array.length;
                while (array[ind] != null) ind++;
                array[ind] = s;
            }
            for (int i = 0; i < array.length; ++i) {
                if (array[i] != null) {
                    System.out.printf("%s %s%n", i, array[i]);
                }
            }
        }
    }
}
