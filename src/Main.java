import MainStuff.Graph.EdgeDest;
import MainStuff.Graph.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt(), s = scan.nextInt(), t = scan.nextInt(),
                min = scan.nextInt(), max = scan.nextInt(), d = scan.nextInt();
        int[] edgeArray = new int[3*m]; //code , frst, scnd
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                int tmp = scan.nextInt();
                edgeArray[i+j] = tmp;
            }
        }
        Graph graph = new Graph(n,m,(d==1), makeEdgeList(edgeArray, n));

        ArrayList<Integer> res = graph.findAllPaths(s,t,min,max);
        System.out.println(printRes(res));

    }


    public static String printRes(ArrayList<Integer> list) {
        list = list.stream().distinct().sorted().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list.size());
        StringBuilder res = new StringBuilder();

        for (int i : list)
            res.append(i).append(" ");

        return res.toString();
    }

    public static ArrayList<ArrayList<EdgeDest>> makeEdgeList(int[] rawArray, int n) {
        ArrayList<ArrayList<EdgeDest>> edgeList = new ArrayList<>(Collections.nCopies( n+1, new ArrayList()));
        for (int i = 0; i < rawArray.length; i+=3)
            edgeList.get(rawArray[i+1]).add(new EdgeDest(rawArray[i],rawArray[i+2]));
        return edgeList;
    }
}
