import java.lang.Math.*;   import java.io.*;   import java.text.*; import java.util.Random;
import java.util.*;


public class Main {

    public static void main(String args[]) {
        int m = 1000000;
        int repetitions = 30;
        String[][] data = Data.generateData(1000000);
        int[] loads = {750000, 800000, 850000, 900000, 950000};

        System.out.println("\nAverage time in seconds");
        System.out.println("--------------------------------");
        System.out.printf("%-10s %-10s %-12s %-15s %-15s\n", "Hash a", "N", "1/(1-a)", "Open Hash", "Chained Hash");
        System.out.println("--------------------------------");


        for (int N : loads) {

            double a = (double) N / m;
            double b = 1.0 / (1.0 - a);


            openHash open = new openHash(m);
            chainedHash chained = new chainedHash(m);


            for (int i = 0; i < N; i++) {
                open.insert(data[i][0], data[i][1]);
                chained.insert(data[i][0], data[i][1]);
            }

            double openTotal = 0;
            double chainedTotal = 0;


            for (int r = 0; r < repetitions; r++) {
                long start = System.currentTimeMillis();


                for (int i = 0; i < N; i++) 
                    open.lookup(data[i][0]);

                    long finish = System.currentTimeMillis();
                    openTotal = finish - start;

                    start = System.currentTimeMillis();


                    for (int i = 0; i < 30; i++) 
                        chained.lookup(data[i][0]);


                        finish = System.currentTimeMillis();
                        chainedTotal = finish - start;
                    }

                    double openAvg = (openTotal / repetitions) / 1000.0;
                    double chainedAvg = (chainedTotal / repetitions) / 1000.0;

                    System.out.printf("%-10s %-10d %-12.2f %-15.5f %-15.5f\n",
                            (int)(a * 100) + "%",
                            N,
                            b,
                            openAvg,
                            chainedAvg);
                }
                System.out.println("----------------------------");
            }
        }


        class Data {
            public static String[][] generateData(int total) {
                String[][] data = new String[total][2];

                List<Integer> keys = new ArrayList<>();
                for (int i = 1; i <= total; i++) {
                    keys.add(i);
                }
                Collections.shuffle(keys);

                for (int i = 0; i < total; i++) {
                    data[i][0] = String.valueOf(keys.get(i));
                    data[i][1] = String.valueOf(keys.get(i));
                }
                return data;
            }
        }
    


            
        
    

        
