package test.task;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task14 {
    public static void main(String[] args) throws Exception{
        try(var lines = Files.lines(Path.of(ClassLoader.getSystemResource("text.txt").getPath()))) {
            var list = lines.flatMap(s-> Arrays.stream(s.split(" "))).collect(Collectors.toSet());
            List<List<String>> array = new ArrayList<>(list.size()) {{
                for (int i = 0; i < list.size(); ++i) {
                    this.add(new ArrayList<>());
                }
            }};
            for (var s : list) {
                int ind = Math.abs(s.hashCode()) % array.size();
                array.get(ind).add(s);
            }
            for (int i = 0; i < array.size(); ++i) {
                if (!array.get(i).isEmpty()) {
                    System.out.printf("%s %s%n", i, array.get(i));
                }
            }
        }
    }
}
