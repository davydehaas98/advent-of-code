package nl.davydehaas._2021.day09;

import nl.davydehaas.utils.InputReader;

import java.util.List;

public class Part1 {
    static int[][] heightMap;
    
    public static void main(String[] args) {
        heightMap = getHeightMap();
        
        int sum = sumRiskLevels();
    
        System.out.println("The sum of the risk levels of all low points is:");
        System.out.println(sum);
    }
    
    private static int sumRiskLevels() {
        int sum = 0;
        
        for (int column = 0; column < heightMap.length; column++)
            for (int row = 0; row < heightMap[0].length; row++)
                if (isLowestPoint(column, row))
                    sum += heightMap[column][row] + 1;
        
        return sum;
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
        List<String> lines = InputReader.readFile("/_2021/day09-input.txt");
        int[][] heightMap = new int[lines.size()][lines.get(0).length()];
        
        for (int column = 0; column < heightMap[0].length; column++)
            for (int row = 0; row < heightMap.length; row++)
                heightMap[row][column] = Integer.parseInt(String.valueOf(lines.get(row).charAt(column)));
        
        return heightMap;
    }
}
