package main.java.app;

import main.java.modules.log.LnModule;
import main.java.modules.log.Log2Module;
import main.java.modules.log.Log3Module;
import main.java.modules.log.Log5Module;
import main.java.modules.log.real.LnModuleReal;
import main.java.modules.log.real.Log2ModuleReal;
import main.java.modules.log.real.Log3ModuleReal;
import main.java.modules.log.real.Log5ModuleReal;

import main.java.modules.trig.SinModule;
import main.java.modules.trig.CosModule;
import main.java.modules.trig.TanModule;
import main.java.modules.trig.CotModule;
import main.java.modules.trig.SecModule;
import main.java.modules.trig.real.SinModuleReal;
import main.java.modules.trig.real.CosModuleReal;
import main.java.modules.trig.real.TanModuleReal;
import main.java.modules.trig.real.CotModuleReal;
import main.java.modules.trig.real.SecModuleReal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ModuleCsvApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите модуль для теста (реальная реализация):");
        System.out.println("1 - Sin");
        System.out.println("2 - Cos");
        System.out.println("3 - Tan");
        System.out.println("4 - Cot");
        System.out.println("5 - Sec");
        System.out.println("6 - Ln");
        System.out.println("7 - Log2");
        System.out.println("8 - Log3");
        System.out.println("9 - Log5");
        System.out.print("> ");

        int choice = scanner.nextInt();

        System.out.print("Введите start (начало диапазона, например, \"-1,5\"): ");
        double start = scanner.nextDouble();
        System.out.print("Введите end (конец диапазона): ");
        double end = scanner.nextDouble();
        System.out.print("Введите step (шаг): ");
        double step = scanner.nextDouble();

        Object module = createRealModule(choice);

        String filename = getModuleName(choice) + "_module.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("x," + getModuleName(choice) + "(x)\n");

            for (double x = start; x <= end + 1e-15; x += step) {

                double value;
                try {
                    value = calculateValue(module, x);
                } catch (Exception e) {
                    value = Double.NaN;
                }

                bw.write(String.format(Locale.US, "%.6f,%.6f\n", x, value));
            }

            System.out.println("Файл " + filename + " успешно создан.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Object createRealModule(int choice) {
        double eps = 1e-4;

        switch (choice) {
            case 1:
                return new SinModuleReal(eps);
            case 2:
                return new CosModuleReal(new SinModuleReal(eps));
            case 3:
                SinModule sinReal = new SinModuleReal(eps);
                CosModule cosReal = new CosModuleReal(sinReal);
                return new TanModuleReal(sinReal, cosReal);
            case 4:
                SinModule sinReal2 = new SinModuleReal(eps);
                CosModule cosReal2 = new CosModuleReal(sinReal2);
                TanModule tanReal = new TanModuleReal(sinReal2, cosReal2);
                return new CotModuleReal(tanReal);
            case 5:
                return new SecModuleReal(new CosModuleReal(new SinModuleReal(eps)));
            case 6:
                return new LnModuleReal(eps);
            case 7:
                LnModule ln2 = new LnModuleReal(eps);
                return new Log2ModuleReal(ln2);
            case 8:
                LnModule ln3 = new LnModuleReal(eps);
                return new Log3ModuleReal(ln3);
            case 9:
                LnModule ln5 = new LnModuleReal(eps);
                return new Log5ModuleReal(ln5);
            default:
                throw new IllegalArgumentException("Неверный выбор модуля!");
        }
    }

    private static String getModuleName(int choice) {
        return switch (choice) {
            case 1 -> "sin";
            case 2 -> "cos";
            case 3 -> "tan";
            case 4 -> "cot";
            case 5 -> "sec";
            case 6 -> "ln";
            case 7 -> "log2";
            case 8 -> "log3";
            case 9 -> "log5";
            default -> "unknown";
        };
    }

    private static double calculateValue(Object module, double x) {
        return switch (module) {
            case SinModule sinModule -> sinModule.sin(x);
            case CosModule cosModule -> cosModule.cos(x);
            case TanModule tanModule -> tanModule.tan(x);
            case CotModule cotModule -> cotModule.cot(x);
            case SecModule secModule -> secModule.sec(x);
            case LnModule lnModule -> lnModule.ln(x);
            case Log2Module log2Module -> log2Module.log2(x);
            case Log3Module log3Module -> log3Module.log3(x);
            case Log5Module log5Module -> log5Module.log5(x);
            case null, default -> throw new IllegalArgumentException("Неизвестный модуль");
        };
    }
}
