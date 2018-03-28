package com.company;


import java.io.File;

public class DirList {
    public static void main(String[] args){

        final String dirname = "/Users/viktoriyasidenko/Documents/Projects/Hillel elementary/";
        File file = new File(dirname);
        if (file.isDirectory()){
            System.out.println("Directory " + dirname);
            System.out.println();
            String[] s = file.list();

            for (int i = 0; i < s.length; i++) {
                String dirname1 = dirname + "/" + s[i];
                File f = new File(dirname1);
                if (f.isDirectory()){
                    System.out.println();
                    System.out.println(s[i] + " is directory");
                    System.out.println();

                    String[] list = f.list();

                    for (int j = 0; j < list.length; j++){
                        String dirname2 = dirname1 + "/" + list[j];
                        File f1 = new File(dirname2);
                        if(f1.isDirectory()) {
                            System.out.println(list[j] + " is dir");
                        } else if (f1.isFile()) {
                            System.out.println(list[j] + " is file");
                        }
                    }
                } else {
                    System.out.println(s[i] + " is file");
                }
            }
        } else {
            System.out.println(dirname + " is not directory");
        }
    }
}
