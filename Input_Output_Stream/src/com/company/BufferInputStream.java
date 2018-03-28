package com.company;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferInputStream {
    public static void main(String[] args) {

        final String filePath = "/Users/viktoriyasidenko/Documents/Сиденко Виктория.odt/";
        BufferedInputStream buffInStrm = null;
        FileInputStream fInStrm = null;

//        try {
//            fInStrm = new FileInputStream(filePath);
//            buffInStrm = new BufferedInputStream(fInStrm);
//            while (true) {
//                int byteValue = buffInStrm.read();
//                System.out.print(byteValue + " ");
//                if (byteValue == -1)	break;
//            }
//        } catch (IOException ex) { ex.printStackTrace(); }
//        finally {
//            try {
//                if (buffInStrm != null) buffInStrm.close();
//                if (fInStrm != null) fInStrm.close();
//            } catch (IOException ex) {	ex.printStackTrace(); }
//        }

        try {
            fInStrm = new FileInputStream(filePath);
            buffInStrm = new BufferedInputStream(fInStrm);
            while (buffInStrm.available() > 0) {
                int byteValue = buffInStrm.read();
                System.out.print(byteValue + ", ");
//                System.out.print((char) byteValue);
            }

        } catch (IOException ex) { ex.printStackTrace(); }
        finally {
            try {
                if (buffInStrm != null) buffInStrm.close();
                if (fInStrm != null) fInStrm.close();
            } catch (IOException ex) { ex.printStackTrace(); }
        }


        final String filePathWrite = "/Users/viktoriyasidenko/Documents/Projects/Hillel elementary/Healthy_LifeStyle_English_project/1_1.txt";
        int[] somedata = {80, 75, 3, 4, 20, 0, 0, 8};
        FileOutputStream myFile = null;
        try {
            // true - Добавление данных в конец файла
            myFile = new FileOutputStream(filePathWrite, true);
            for (int i = 0; i < somedata.length; i++) {
                myFile.write(somedata[i]);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try { if (myFile != null) myFile.close(); }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
