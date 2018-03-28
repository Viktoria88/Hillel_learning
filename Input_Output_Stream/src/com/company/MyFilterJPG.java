package com.company;

import java.io.File;
import java.io.FileFilter;


public class MyFilterJPG implements FileFilter {
    @Override
    public boolean accept(File pathname) {
         return pathname.toString().toLowerCase().endsWith(".jpg");
    }
}
