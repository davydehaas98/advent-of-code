package nl.davydehaas.adventofcode.year2023.day08;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part1 {
    
    private static final List<String> INPUT = readFile(2023, 8);
    
    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }
    
    static int solve() {
        char[] instructions = INPUT.getFirst().toCharArray();
        Map<String, String[]> nodes = getNodes();
        
        int steps = 0;
        String currentNode = "AAA";
        for (int i = 0; i < instructions.length; i++) {
            steps++;
            if (instructions[i] == 'L') {
                currentNode = nodes.get(currentNode)[0];
            } else {
                currentNode = nodes.get(currentNode)[1];
            }
            if ("ZZZ".equals(currentNode)) {
                break;
            }
            if (i == instructions.length - 1) {
                i = -1;
            }
        }
        
        return steps;
    }
    
    private static Map<String, String[]> getNodes() {
        Map<String, String[]> nodes = new HashMap<>();
        for (int i = 2; i < INPUT.size(); i++) {
            String[] node = INPUT.get(i).split(" = \\(");
            nodes.put(node[0], node[1].replace(")", "").split(", "));
        }
        return nodes;
    }
}
