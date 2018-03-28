package com.company;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;


public class Filter {

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/viktoriyasidenko/Documents/Projects/Hillel elementary/Healthy_LifeStyle_English_project/");

        System.out.println(file.canRead());

        System.out.println("Filter");
        FileFilter fileCanReadFilter = new MyFileFilter();
        File[] files1 = file.listFiles(fileCanReadFilter);
        for(File f : files1){
            System.out.println("File can read - " + f);
        }

        FileFilter fileIsPictureFilter = new MyFilterJPG();
        File[] files2 = file.listFiles(fileIsPictureFilter);
        for(File f : files2){
            System.out.println("File is picture - " + f);
        }


        new File("/Users/viktoriyasidenko/Documents/Projects/Hillel elementary/Healthy LifeStyle/").renameTo(
                new File("/Users/viktoriyasidenko/Documents/Projects/Hillel elementary/Healthy_LifeStyle_English_project/"));

//        file.mkdir();
        System.out.println(file.getTotalSpace());
        System.out.println(file.getFreeSpace());
        System.out.println(file.getUsableSpace());

        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();

                for (File f : files) {
                    try {
                        System.out.println("Directory has file - " + f.getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (file.isFile()){
            System.out.println("File?");
        }

//        file.delete();

        String parentPath = file.getParent();
        File parentFile = file.getParentFile();

        System.out.println("parent file : " + parentFile);
        System.out.println("parent path : " + parentPath);

    }
}
