package com.company.calculation;

import com.company.annotations.DescriptionCalculation;
import com.company.annotations.TypeCalculation;
import com.company.exception.IncorrectValueException;
import com.company.history.History;
import com.company.operations.*;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.company.calculation.Calculation.args;

public class CalculationFacade<T extends Number> {


    private static Calcul calcul;
    Class<RutCalc> calculClass = RutCalc.class;
    Class<SimpleCalc> simpleCalcClass = SimpleCalc.class;
    Class<CalculAdapterJS> jsClass = CalculAdapterJS.class;
    Annotation annotationT;
    Annotation annotationD;
    public static String typeCalculation;
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    static LocalDate localDate = LocalDate.now();
    static String data = dtf.format(localDate);
    private static final String CSV_SEPARATOR = ";";
    private static final String pathHistory = "/Users/viktoriyasidenko/Documents/Projects/Hillel elementary/elemenaty_19/sidenko_vika/Calculator/history.csv";
    private static List<History> histories;

    public static final String PATH_TO_PROPERTIES = "sidenko_vika/Calculator/resources/config.properties";

    public CalculationFacade(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        FileInputStream fileInputStream;
        Properties prop = new Properties();

        fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
        prop.load(fileInputStream);

        typeCalculation = prop.getProperty("class");

        switch (typeCalculation) {
            case ("RutCalc"):
                if (isDouble(args)) {
                    calcul = calculClass.getDeclaredConstructor(String[].class, Class.class).newInstance(args, BigDecimal.class);
                } else {
                    calcul = calculClass.getDeclaredConstructor(String[].class, Class.class).newInstance(args, BigInteger.class);
                }
                annotationT = calculClass.getDeclaredAnnotation(TypeCalculation.class);
                annotationD = calculClass.getDeclaredAnnotation(DescriptionCalculation.class);
                break;
            case ("SimpleCalc"):
                if (isDouble(args)) {
                    calcul = simpleCalcClass.getDeclaredConstructor(String[].class, Class.class).newInstance(args, BigDecimal.class);
                } else {
                    calcul = simpleCalcClass.getDeclaredConstructor(String[].class, Class.class).newInstance(args, BigInteger.class);
                }
                annotationT = simpleCalcClass.getDeclaredAnnotation(TypeCalculation.class);
                annotationD = simpleCalcClass.getDeclaredAnnotation(DescriptionCalculation.class);
                break;
            case ("JS"):
                calcul = new CalculAdapterJS(args);
                annotationT = jsClass.getDeclaredAnnotation(TypeCalculation.class);
                annotationD = jsClass.getDeclaredAnnotation(DescriptionCalculation.class);
                break;
        }
        if (annotationT != null && annotationD != null) {
            TypeCalculation.Type type = ((TypeCalculation) annotationT).type();
            System.out.println(type);
            String description = ((DescriptionCalculation) annotationD).description();
            System.out.println(description);
        }
    }

    public static boolean isDouble(String[] args) {
        boolean symb;
        for (int i = 0; i < args.length; i++) {
            Pattern p = Pattern.compile("^[0-9]*[.,][0-9]+$");
            Matcher m = p.matcher(args[i]);
            symb = m.matches();
            if (symb == true) {
                return symb;
            } else {
                continue;
            }
        }
        return false;
    }

    public static void startCalculate(String[] s) throws CloneNotSupportedException {
        BigDecimal total;
        HashMap<ConstOperation, Operations> map = new HashMap<>();
        map.put(ConstOperation.PLUS, Plus.createInstance());
        map.put(ConstOperation.MINUS, Minus.createInstance());
        map.put(ConstOperation.MULTIPLY, Multiply.createInstance());
        map.put(ConstOperation.DIVIDE, Divide.createInstance());
        calcul.setOperations(map);
        Calculation.existOperations();
        try {
            calcul.setExp(s);
        } catch (IncorrectValueException e) {
            System.out.println(e);
        }
        total = calcul.getResult();
        System.out.println("Total: " + total);

        History history = History.getInstance(typeCalculation, data, args, total);
        histories = new ArrayList<>();
        histories.add(history);
        saveHistory();
    }

    private static void saveHistory() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathHistory, true)));
            for (History history : histories) {
                StringBuffer line = new StringBuffer();
                line.append(history.getTypeCalculation());
                line.append(CSV_SEPARATOR);
                line.append(history.getCurrentData());
                line.append(CSV_SEPARATOR);
                line.append(Arrays.asList(history.getArgs()));
                line.append(CSV_SEPARATOR);
                line.append(history.getTotal());
                bw.write(line.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
