package com.dagger.programming.basics;

import java.util.*;

public class RectInGrid {

    public static void main(String[] args) {

        int[][] coordinates = new int[8][2];
        //                  x, y
        coordinates[0] = new int[]{1, 1};
        coordinates[1] = new int[]{1, 4};
        coordinates[2] = new int[]{1, 6};
        coordinates[3] = new int[]{2, 3};
        coordinates[4] = new int[]{4, 1};
        coordinates[5] = new int[]{4, 4};
        coordinates[6] = new int[]{1, 2};
        coordinates[7] = new int[]{4, 2};

        printRectangles(coordinates);
    }

    public static void printRectangles(int[][] coordinates) {

        Map<Integer, List<Integer>> lines = new HashMap<>();

        for (int[] coordinate : coordinates) {
            int x = coordinate[0];
            int y = coordinate[1];

            List<Integer> line = lines.get(x);

            if (line == null) {
                line = new ArrayList<>();
                lines.put(x, line);
            }

            line.add(y);
        }

        Iterator<Map.Entry<Integer, List<Integer>>> iterator = lines.entrySet().iterator();

        
        while (iterator.hasNext()) {
            if (iterator.next().getValue().size() < 2) { // This is not a line
                iterator.remove();
            }
        }

        if (lines.size() < 2) { // Only 1 line, so no rectangles
            return;
        }

        Iterator<Map.Entry<Integer, List<Integer>>> iterator2 = lines.entrySet().iterator();

        Map.Entry<Integer, List<Integer>> line1 = null;
        Map.Entry<Integer, List<Integer>> line2 = null;

        List<Integer> processedXs = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : lines.entrySet()) {

            Integer entry1X = entry.getKey();
            processedXs.add(entry1X);
            List<Integer> entry1Ys = entry.getValue();

            for (Map.Entry<Integer, List<Integer>> entry2 : lines.entrySet()) {

                Integer entry2X = entry2.getKey();

                if (processedXs.contains(entry2X)) {
                    continue;
                }

                List<Integer> entry2Ys = entry2.getValue();

                List<Integer> matchingYs = new ArrayList<>();

                for (Integer y : entry1Ys) {
                    if (entry2Ys.contains(y)) {
                        matchingYs.add(y);
                    }
                }

                if (matchingYs.size() > 1) {
                    List<Integer> processedYs = new ArrayList<>();

                    for (Integer matchingY : matchingYs) {
                        processedYs.add(matchingY);

                        for (Integer matchingY2 : matchingYs) {
                            if (processedYs.contains(matchingY2)) {
                                continue;
                            }

                            System.out.println("Rectangle : (" +
                                            entry1X + "," + matchingY + ") " +
                                            entry1X + "," + matchingY2 + ") " +
                                            entry2X + "," + matchingY + ") " +
                                            entry2X + "," + matchingY2 + ") ");
                        }
                    }
                }


            }
        }

        while (iterator2.hasNext()) {
            Map.Entry<Integer, List<Integer>> currentLine = iterator2.next();

            if (line1 == null) {
                line1 = currentLine;
            }

        }
        




    }
}
