package logging;

import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class FileLogger implements ILog {
    private PrintWriter myWriter;
    public void write(long text) {
        myWriter.println(text);
    }

    public void write(String text) {
        myWriter.println(text);
    }

    public void write(Object... values) {
        for(Object o: values)
            myWriter.print(values + " ");
    }

    @Override
    public void writeTime(String string, long value, TimeUnit.units unit) {

    }

    public FileLogger(String name)
    {
        String fileName = name;
        String filePath = "D:\\year 2\\sem2\\co\\project\\BenchmarkingProject\\";
        String fullPath = filePath + fileName;

        try {
            File file = new File(fullPath);
            myWriter = new PrintWriter(fileName);
            if (file.createNewFile()) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists.");
            }

            Desktop.getDesktop().open(file);

//            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
    public void close() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args)
    {
        FileLogger f = new FileLogger("example2.txt");
        f.write("buna siua");
    }
}
