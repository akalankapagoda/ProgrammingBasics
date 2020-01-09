package com.dagger.programming.basics;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

        int movesCount = 0;

        // Straight down
        movesCount = movesCount + r_q - 1;

        // Straight up
        movesCount = movesCount + n - r_q;

        // Left
        movesCount = movesCount + c_q - 1;

        // Right
        movesCount = movesCount + n - c_q;

        // Left Up
        movesCount = movesCount + Math.min(c_q - 1, n - r_q);

        // Right Up
        movesCount = movesCount + Math.min(n - c_q, n - r_q);

        // Left Down
        movesCount = movesCount + Math.min(r_q, c_q) - 1;

        // Right Down
        movesCount = movesCount + Math.min(r_q - 1, n - c_q);

        // Now remove stuff that are blocked
        int maxLeftColumn = 0;
        int maxRightColumn = 0;
        int maxUpRow = 0;
        int maxDownRow = 0;
        int maxLeftUp = 0;
        int maxRightUp = 0;
        int maxLeftDown = 0;
        int maxRightDown = 0;


        for (int[] coordinates : obstacles) {
            int r = coordinates[0];
            int c = coordinates[1];

            if (r == r_q) { // Same row as Q
                if (c > c_q) {
                    maxRightColumn = Math.max(maxRightColumn, (n - c + 1));
                } else if (c < c_q) {
                    maxLeftColumn = Math.max(maxLeftColumn, c);
                }
            } else if (c == c_q) { // Same column as Q
                if (r > r_q) {
                    maxUpRow = Math.max(maxUpRow, (n - r + 1));
                } else if (r < r_q) {
                    maxDownRow = Math.max(maxDownRow, r);
                }
            } else if (Math.abs(r - r_q) == Math.abs(c - c_q)) { // A diagonal blocked

                if (r > r_q) {
                    if (c < c_q) { // Left up blocked
                        maxLeftUp = Math.max(maxLeftUp, Math.min(c, n - r + 1));
                    } else if ( c > c_q) { // Right up blocked
                        maxRightUp = Math.max(maxRightUp, Math.min(n - c, n - r) + 1);
                    }
                } else if (r < r_q) {
                    if (c < c_q) { // Left down blocked
                        maxLeftDown = Math.max(maxLeftDown, Math.min(c, r));
                    } else if ( c > c_q) { // Right down blocked
                        maxRightDown = Math.max(maxRightDown, Math.min(n - c + 1, r));
                    }
                }
            }

        }

        movesCount = movesCount - maxUpRow - maxDownRow - maxLeftColumn - maxRightColumn -
                maxLeftUp - maxRightUp - maxLeftDown - maxRightDown;

        return movesCount;

    }

    public static void main(String[] args) {
        int[][] obstacles = new int[20][2];
//        obstacles[0] = new int[]{4, 2};
//        obstacles[1] = new int[]{4, 4};
//        obstacles[2] = new int[]{5, 1};
//        obstacles[3] = new int[]{5, 5};
//        obstacles[4] = new int[]{1, 1};
//        obstacles[5] = new int[]{1, 5};
//        obstacles[6] = new int[]{2, 2};
//        obstacles[7] = new int[]{2, 4};
        obstacles[0] = new int[]{5, 3};
//        obstacles[9] = new int[]{3, 5};
//        obstacles[10] = new int[]{3, 3};
//        obstacles[11] = new int[]{3, 1};


        System.out.println(queensAttack(5, 3, 3, 3, obstacles));
    }

    private static final Scanner scanner = new Scanner(System.in);

//    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] nk = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nk[0]);
//
//        int k = Integer.parseInt(nk[1]);
//
//        String[] r_qC_q = scanner.nextLine().split(" ");
//
//        int r_q = Integer.parseInt(r_qC_q[0]);
//
//        int c_q = Integer.parseInt(r_qC_q[1]);
//
//        int[][] obstacles = new int[k][2];
//
//        for (int i = 0; i < k; i++) {
//            String[] obstaclesRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 2; j++) {
//                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
//                obstacles[i][j] = obstaclesItem;
//            }
//        }
//
//        int result = queensAttack(n, k, r_q, c_q, obstacles);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
//    }
}
