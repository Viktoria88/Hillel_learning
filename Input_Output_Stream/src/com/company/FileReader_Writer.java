package com.company;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader_Writer {
    public static void main(String[] args) {

        try (FileReader fr = new FileReader("/Users/viktoriyasidenko/Documents/Сиденко Виктория.odt/")) {
            int c;
            while ((c = fr.read()) != 1) {
                System.out.println((char) c);
            }
        } catch (IOException e) {
            System.out.println("Error input-output: " + e);
        }


        String source = "I am studying now,\n" +
                        " у меня все выйдет\n";

        char[] buffer = new char[source.length()];

        source.getChars(0, source.length(), buffer, 0);

        try(FileWriter fw = new FileWriter("/Users/viktoriyasidenko/Documents/Projects/Hillel elementary/Work_with_File/file1.txt");
            FileWriter fw1 = new FileWriter("/Users/viktoriyasidenko/Documents/Projects/Hillel elementary/Work_with_File/file2.txt");
            FileWriter fw2 = new FileWriter("/Users/viktoriyasidenko/Documents/Projects/Hillel elementary/Work_with_File/file3.txt"))
        {
            for (int i = 0; i < buffer.length; i += 2) {
                fw.write(buffer[i]);
            }

            fw1.write(buffer);

            fw2.write(buffer, buffer.length - buffer.length/4, buffer.length/4);
        } catch (IOException e){
            System.out.println("Error input-output");
        }
    }
}
