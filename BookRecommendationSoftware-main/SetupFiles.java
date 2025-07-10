import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SetupFiles {
    private static File file;
    private static FileWriter fileWriter;

    public static void setupFiles() {
        try {
            file = new File("./output.txt");
            fileWriter = new FileWriter(file);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static File getFile() {
        return file;
    }

    public static FileWriter getFileWriter() {
        return fileWriter;
    }
}
