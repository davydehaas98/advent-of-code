package nl.davydehaas.adventofcode.year2021.day05;

import nl.davydehaas.adventofcode.year2021.Year2021;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part2 extends Year2021 {
    
    private static final List<String> INPUT = readFile("/day05.txt");
    
    public static void main(String[] args) {
        timeSolution(Part2::calculate);
    }
    
    static int calculate() {
        List<Point[]> lines = getLines();
        LinkedHashMap<Point, Integer> vents = new LinkedHashMap<>();
        int dangerousAreaCounter = 0;
        
        for (Point[] points : lines) {
            Point startPoint = points[0];
            Point endPoint = points[1];
            
            if (startPoint.x != endPoint.x && startPoint.y != endPoint.y) {
                createDiagonalVent(startPoint, endPoint, vents);
            } else if (startPoint.x != endPoint.x) {
                createHorizontalVent(startPoint, endPoint, vents);
            } else if (startPoint.y != endPoint.y) {
                createVerticalVent(startPoint, endPoint, vents);
            }
        }
        
        for (Map.Entry<Point, Integer> vent : vents.entrySet()) {
            if (vent.getValue() > 1) {
                dangerousAreaCounter++;
            }
        }
        
        return dangerousAreaCounter;
    }
    
    private static void createDiagonalVent(Point startPoint, Point endPoint, LinkedHashMap<Point, Integer> vents) {
        int difference;
        // Diagonal line from left to right
        if (startPoint.x < endPoint.x) {
            difference = endPoint.x - startPoint.x;
            // Diagonal line from top left to bottom right
            if (startPoint.y < endPoint.y) {
                for (int i = 0; i < difference + 1; i++) {
                    addVent(vents, new Point(startPoint.x + i, startPoint.y + i));
                }
            }
            // Diagonal line from bottom left to top right
            else {
                for (int i = 0; i < difference + 1; i++) {
                    addVent(vents, new Point(startPoint.x + i, startPoint.y - i));
                }
            }
        }
        // Diagonal line from right to left
        else {
            difference = startPoint.x - endPoint.x;
            // Diagonal from top right to bottom left
            if (startPoint.y < endPoint.y) {
                for (int i = 0; i < difference + 1; i++) {
                    addVent(vents, new Point(startPoint.x - i, startPoint.y + i));
                }
            }
            // Diagonal line bottom right to top left
            else {
                for (int i = 0; i < difference + 1; i++) {
                    addVent(vents, new Point(startPoint.x - i, startPoint.y - i));
                }
            }
        }
    }
    
    private static void createHorizontalVent(Point startPoint, Point endPoint, LinkedHashMap<Point, Integer> vents) {
        // Start point x smaller than end point x
        if (startPoint.x < endPoint.x) {
            for (int x = startPoint.x; x < endPoint.x + 1; x++) {
                addVent(vents, new Point(x, startPoint.y));
            }
        }
        // Start point x greater than end point x
        else if (startPoint.x > endPoint.x) {
            for (int x = endPoint.x; x < startPoint.x + 1; x++) {
                addVent(vents, new Point(x, startPoint.y));
            }
        }
    }
    
    private static void createVerticalVent(Point startPoint, Point endPoint, LinkedHashMap<Point, Integer> vents) {
        // Start point y smaller than end point y
        if (startPoint.y < endPoint.y) {
            for (int y = startPoint.y; y < endPoint.y + 1; y++) {
                addVent(vents, new Point(startPoint.x, y));
            }
        }
        // Start point y greater than end point y
        else if (startPoint.y > endPoint.y) {
            for (int y = endPoint.y; y < startPoint.y + 1; y++) {
                addVent(vents, new Point(startPoint.x, y));
            }
        }
    }
    
    private static void addVent(LinkedHashMap<Point, Integer> vents, Point point) {
        if (vents.containsKey(point)) {
            int value = vents.get(point);
            vents.put(point, value + 1);
        } else {
            vents.put(point, 1);
        }
    }
    
    private static List<Point[]> getLines() {
        List<Point[]> lines = new ArrayList<>();
        
        INPUT.forEach(fileLine -> lines.add(new Point[]{
                new Point(
                        Integer.parseInt(fileLine.split(" -> ")[0].split(",")[0]),
                        Integer.parseInt(fileLine.split(" -> ")[0].split(",")[1])
                ),
                new Point(
                        Integer.parseInt(fileLine.split(" -> ")[1].split(",")[0]),
                        Integer.parseInt(fileLine.split(" -> ")[1].split(",")[1])
                )
        }));
        
        return lines;
    }
}
