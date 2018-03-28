package com.company;


import java.io.*;

public class BufferReader_Writer {
    public static void main(String[] args) throws FileNotFoundException {

        final String filePath = "/Users/viktoriyasidenko/Documents/Projects/Hillel elementary/Work_with_File/file2.txt";

        final String encoding = "UTF-8";

        Reader inputStream = null;

        try {

            inputStream = new InputStreamReader(new FileInputStream(filePath), encoding);

        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        String lineRead;

        if(inputStream != null){
            try(final BufferedReader bufferedReader = new BufferedReader(inputStream)){
                while ((lineRead = bufferedReader.readLine()) != null) {
                    System.out.println(lineRead);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        final String filePathWrite = "/Users/viktoriyasidenko/Documents/Projects/Hillel elementary/Work_with_File/fileBuff.txt";
        Writer outputStream = null;

        try{
            outputStream = new OutputStreamWriter(new FileOutputStream(filePathWrite, true), encoding);
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        if (outputStream != null){
            try(final BufferedWriter bufferedWriter = new BufferedWriter(outputStream)){
                final String line = "new line \n new new new\n";
                bufferedWriter.write(line);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
