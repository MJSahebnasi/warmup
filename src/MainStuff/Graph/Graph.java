package MainStuff.Graph;

import MainStuff.AllPaths.AllPaths;
import MainStuff.AllPaths.AllPaths_bareDFS;

import java.util.ArrayList;

public class Graph {
    int nodesNo, edgesNo;
    boolean directed;
    ArrayList<ArrayList<EdgeDest>> edges;
    AllPaths allPaths;

    public Graph(int nodesNo, int edgesNo, boolean directed, ArrayList<ArrayList<EdgeDest>> edges) {
        this.nodesNo = nodesNo;
        this.edgesNo = edgesNo;
        this.directed = directed;
        this.edges = edges;
        initAllPaths();
    }

    private void initAllPaths() {
        //TODO
        //for now:
        allPaths = new AllPaths_bareDFS(this);
    }

    public ArrayList<Integer> findAllPaths(int strt, int end, int min, int max) {
        return allPaths.find(strt, end, min, max);
    }
}
