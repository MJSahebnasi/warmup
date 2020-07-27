package UnitTests;

import MainStuff.Graph.EdgeDest;
import MainStuff.Graph.Graph;
import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;

public class GraphTest {
    static Graph g;

    @Test
    public static void t0() {
        int n = 5, m = 10, d = 0;
        int[] edges = {
                1, 1, 2,
                5, 2, 3,
                10, 1, 5,
                8, 1, 3,
                2, 2, 5,
                7, 2, 4,
                3, 3, 4,
                6, 4, 5,
                9, 4, 1,
                4, 5, 3, 4}; //frst,scnd,code

        //init graph
        ArrayList<ArrayList<EdgeDest>> tmpEdges = new ArrayList<>(Collections.nCopies(n + 1, new ArrayList()));
        for (int i = 0; i < m; i += 3) {
            int code = i + 2, scnd = i + 1;
            tmpEdges.get(i).add(new EdgeDest(code, scnd));
        }

        g = new Graph(n, m, (d == 1), tmpEdges);


    }
}
