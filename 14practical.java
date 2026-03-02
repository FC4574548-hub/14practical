import java.lang.Math.*;   import java.io.*;   import java.text.*; import java.util.Random;
import java.util.*;


public class timeMethods {
    public static int N = 32654;
    static Node array[] = new Node[N];


    public static void main(String args[]) throws Exception {

        DecimalFormat twoD = new DecimalFormat("0.00");
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        long start, finish;
        double runTime = 0, runTime2 = 0, time;
        double runTimeB = 0, runTime2B = 0, timeB;
        double totalTime = 0.0;
        double totalTimeB = 0.0;
        int n = N;
        int repetition, repetitions = 30;

        Random random = new Random();



        int[] keys = new int[30];
        for (int i = 0; i < 30; i++) {
            keys[i] = random.nextInt(32654) + 1;
        }

        runTime = 0;
        for (repetition = 0; repetition < repetitions; repetition++) {
            start = System.currentTimeMillis();

            // call the procedures to time here:
            // Linear Search
            for (int i = 0; i < 30; i++) {
                linearSearch(keys[i]);
            }

            finish = System.currentTimeMillis();

            time = (double) (finish - start);
            runTime += time;
            runTime2 += (time * time);


            double aveRuntime = runTime / repetitions;
            double stdDeviation =
                    Math.sqrt(runTime2 - repetitions * aveRuntime * aveRuntime) / (repetitions - 1);

            System.out.println("________________________________________________");
            System.out.println("Linear Search");
            System.out.println("Average time =           " + fiveD.format(aveRuntime / 1000)
                    + "s. " + '\u00B1' + " " + fourD.format(stdDeviation) + "ms.");
            System.out.println("Standard deviation =     " + fourD.format(stdDeviation));

        }
        // Binary Search
        runTimeB = 0;


        for (repetition = 0; repetition < repetitions; repetition++) {
            start = System.currentTimeMillis();

            for (int i = 0; i < 30; i++) {
                binarySearch(keys[i]);
            }

            finish = System.currentTimeMillis();

            timeB = (double) (finish - start);
            runTimeB += timeB;
            runTime2B += (timeB * timeB);


            double aveRuntimeB = runTimeB / repetitions;
            double stdDeviationB =
                    Math.sqrt(runTime2B - repetitions * aveRuntimeB * aveRuntimeB) / (repetitions - 1);



            System.out.println("________________________________________________");
            System.out.println("Binary Search");
            System.out.println("Average time =           " + fiveD.format(aveRuntimeB / 1000)
                    + "s. " + '\u00B1' + " " + fourD.format(stdDeviationB) + "ms.");
            System.out.println("Standard deviation =     " + fourD.format(stdDeviationB));}

    }


    public class Data {
    public static String [][] generateData(int total) {
        String[][] data = new String[total][2];

        List<Integer> keys = new ArrayList<>();
        for(int i = 1; i <= total; i++){
            keys.add(i);
        }
        Collections.shuffle(keys);

        for(int i = 0; i < total; i++){
            data[i][0] = String.valueOf(keys.get(i));
            data[i][1] = String.valueOf(keys.get(i));
        }
        return data;
    }
    }
