import MainStuff.Graph.EdgeDest;
import MainStuff.Graph.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt(), s = scan.nextInt(), t = scan.nextInt(),
                min = scan.nextInt(), max = scan.nextInt(), d = scan.nextInt();

        //init graph
        ArrayList<ArrayList<EdgeDest>> tmpEdges = new ArrayList<>(Collections.nCopies(n+1, new ArrayList()));
        for (int i = 0; i < m; i++) {
            int code = scan.nextInt(), frst = scan.nextInt(), scnd = scan.nextInt();
            tmpEdges.get(frst).add(new EdgeDest(code, scnd));
        }
        Graph graph = new Graph(n, m, (d == 1), tmpEdges);

        //find paths
        ArrayList<ArrayList<Integer>> res = graph.findAllPaths(s,t,min,max);
        int size = -1;
        Optional op = res.stream().map(ArrayList::size).reduce((a, b) -> a+b);
        if(op.isPresent()) size = (Integer) op.get();
        System.out.println(size);
        for (ArrayList<Integer> l:res) {
            for (int i:l)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
