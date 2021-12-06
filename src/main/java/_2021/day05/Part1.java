package _2021.day05;

import utils.FileReader;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Part1 {
    public static void main(String[] args) {
        List<Point[]> lines = getLines();
        LinkedHashMap<Point, Integer> vents = new LinkedHashMap<>();
        int dangerousAreaCounter = 0;
        
        for (Point[] points : lines) {
            Point startPoint = points[0];
            Point endPoint = points[1];
            // Skip over diagonal lines
            if (startPoint.x == endPoint.x || startPoint.y == endPoint.y) {
                // Horizontal lines
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
                // Vertical lines
                // Start point y smaller than end point y
                else if (startPoint.y < endPoint.y) {
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
        }
        
        for (Map.Entry<Point, Integer> vent : vents.entrySet()) {
            if (vent.getValue() > 1) {
                dangerousAreaCounter++;
            }
        }
        
        System.out.println("The number of points where at least two lines overlap is:");
        System.out.println(dangerousAreaCounter);
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
        
        try {
            File file = new File("src/main/resources/_2021/day05-input.txt");
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String[] pointString = scanner.nextLine().split(" -> ");
                
                String[] startPointString = pointString[0].split(",");
                Point startPoint = new Point(Integer.parseInt(startPointString[0]), Integer.parseInt(startPointString[1]));
                
                String[] endPointString = pointString[1].split(",");
                Point endPoint = new Point(Integer.parseInt(endPointString[0]), Integer.parseInt(endPointString[1]));
                
                lines.add(new Point[]{startPoint, endPoint});
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return lines;
    }
}
