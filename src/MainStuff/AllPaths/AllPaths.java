package MainStuff.AllPaths;

import MainStuff.Graph.Graph;

import java.util.ArrayList;

public abstract class AllPaths {
    Graph g;

    public AllPaths(Graph g) {
        this.g = g;
    }

    public abstract ArrayList<ArrayList<Integer>> find(int strt, int end, int min, int max);
}
