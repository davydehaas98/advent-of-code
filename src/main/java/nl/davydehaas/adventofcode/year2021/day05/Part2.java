package nl.davydehaas.adventofcode.year2021.day05;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part2 {
    
    private static final List<String> INPUT = readFile(2021, 5);
    
    void main() {
        timeSolution(Part2::solve);
    }
    
    static Number solve() {
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
        if (startPoint.x < endPoint.x) {
            // Diagonal line from left to right
            difference = endPoint.x - startPoint.x;
            if (startPoint.y < endPoint.y) {
                // Diagonal line from top left to bottom right
                for (int i = 0; i < difference + 1; i++) {
                    addVent(vents, new Point(startPoint.x + i, startPoint.y + i));
                }
            } else {
                // Diagonal line from bottom left to top right
                for (int i = 0; i < difference + 1; i++) {
                    addVent(vents, new Point(startPoint.x + i, startPoint.y - i));
                }
            }
        } else {
            // Diagonal line from right to left
            difference = startPoint.x - endPoint.x;
            if (startPoint.y < endPoint.y) {
                // Diagonal from top right to bottom left
                for (int i = 0; i < difference + 1; i++) {
                    addVent(vents, new Point(startPoint.x - i, startPoint.y + i));
                }
            } else {
                // Diagonal line bottom right to top left
                for (int i = 0; i < difference + 1; i++) {
                    addVent(vents, new Point(startPoint.x - i, startPoint.y - i));
                }
            }
        }
    }
    
    private static void createHorizontalVent(Point startPoint, Point endPoint, LinkedHashMap<Point, Integer> vents) {
        if (startPoint.x < endPoint.x) {
            // Start point x smaller than end point x
            for (int x = startPoint.x; x < endPoint.x + 1; x++) {
                addVent(vents, new Point(x, startPoint.y));
            }
        } else if (startPoint.x > endPoint.x) {
            // Start point x greater than end point x
            for (int x = endPoint.x; x < startPoint.x + 1; x++) {
                addVent(vents, new Point(x, startPoint.y));
            }
        }
    }
    
    private static void createVerticalVent(Point startPoint, Point endPoint, LinkedHashMap<Point, Integer> vents) {
        if (startPoint.y < endPoint.y) {
            // Start point y smaller than end point y
            for (int y = startPoint.y; y < endPoint.y + 1; y++) {
                addVent(vents, new Point(startPoint.x, y));
            }
        } else if (startPoint.y > endPoint.y) {
            // Start point y greater than end point y
            for (int y = endPoint.y; y < startPoint.y + 1; y++) {
                addVent(vents, new Point(startPoint.x, y));
            }
        }
    }
    
    private static void addVent(LinkedHashMap<Point, Integer> vents, Point point) {
        if (vents.containsKey(point)) {
            vents.compute(point, (_, value) -> value + 1);
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
    
    record Point(int x, int y) {
    }
}
