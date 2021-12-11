package nl.davydehaas.year2021.day09;

import nl.davydehaas.utils.InputReader;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
    static int[][] heightMap;
    static int sizeCounter;
    
    public static void main(String[] args) {
        heightMap = getHeightMap();
        List<Point> lowestPoints = new ArrayList<>();
        List<Integer> basins = new ArrayList<>();
        
        for (int column = 0; column < heightMap.length; column++)
            for (int row = 0; row < heightMap[0].length; row++)
                if (isLowestPoint(column, row))
                    lowestPoints.add(new Point(column, row));
        
        lowestPoints.forEach(p -> {
            sizeCounter = 0;
            basins.add(calculateBasinSize(p.x, p.y));
        });
        
        int product = basins.stream().sorted().toList()
                .subList(basins.size() - 3, basins.size()).stream()
                .reduce(1, Math::multiplyExact);
        
        System.out.println("The product of the three largest basins:");
        System.out.println(product);
    }
    
    private static Integer calculateBasinSize(int column, int row) {
        int maxColumnIndex = heightMap.length - 1;
        int maxRowIndex = heightMap[0].length - 1;
        
        sizeCounter++;
        heightMap[column][row] = 9;
        
        int left = column - 1;
        if (left >= 0 && heightMap[left][row] < 9) {
            calculateBasinSize(left, row);
        }
        
        int right = column + 1;
        if (right <= maxColumnIndex && heightMap[right][row] < 9) {
            calculateBasinSize(right, row);
        }
        
        int up = row - 1;
        if (up >= 0 && heightMap[column][up] < 9) {
            calculateBasinSize(column, up);
        }
        
        int down = row + 1;
        if (down <= maxRowIndex && heightMap[column][down] < 9) {
            calculateBasinSize(column, down);
        }
        
        return sizeCounter;
    }
    
    private static boolean isLowestPoint(int column, int row) {
        int maxColumnIndex = heightMap.length - 1;
        int maxRowIndex = heightMap[0].length - 1;
        int point = heightMap[column][row];
        
        int left = column - 1;
        if (left >= 0)
            if (point >= heightMap[left][row])
                return false;
        
        int right = column + 1;
        if (right <= maxColumnIndex)
            if (point >= heightMap[right][row])
                return false;
        
        int up = row - 1;
        if (up >= 0)
            if (point >= heightMap[column][up])
                return false;
        
        int down = row + 1;
        if (down <= maxRowIndex)
            if (point >= heightMap[column][down])
                return false;
        
        return true;
    }
    
    private static int[][] getHeightMap() {
        List<String> lines = InputReader.readFile("/year2021/day09-input.txt");
        int[][] heightMap = new int[lines.size()][lines.get(0).length()];
        
        for (int column = 0; column < heightMap[0].length; column++)
            for (int row = 0; row < heightMap.length; row++)
                heightMap[row][column] = Integer.parseInt(String.valueOf(lines.get(row).charAt(column)));
        
        return heightMap;
    }
}
