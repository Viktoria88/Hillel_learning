package com.company;

import com.company.calculation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.company.calculation.CalculationFacade.startCalculate;


public class MainCalculation {

    static Calcul calc;

    public static void main(String[] args) {


        try {
            CalculationFacade calculationFacade = new CalculationFacade(args);
            startCalculate(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
