package test.task;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Task12 {

    public static void main(String[] args) throws Exception{
        try(RandomAccessFile reader = new RandomAccessFile(ClassLoader.getSystemResource("example_array.txt").getPath(),"r");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(Path.of("export_array.txt"), StandardOpenOption.CREATE)))){
            long count = 1000;
            int floor = -1;
            for(long i = 0;i<count;++i) {
                int min = Integer.MAX_VALUE;
                String line;
                while ((line = reader.readLine()) != null) {
                    int value = Integer.parseInt(line);
                    if (value > floor && value < min) {
                        min = value;
                    }
                }
                writer.write(String.valueOf(min));
                floor = min;
                writer.newLine();
                reader.seek(0);
            }
        }
    }
}
