public class Main {

    public static void main(String[] args) {

        ConnectionGraph Graph = makeGraph();

        /*
         * TO PRINT ALL CONNECTIONS UNCOMMENT LINE BELOW
         * Graph.printGraph;
         */

        /*
         * TO SORT CONTAINERS, setContainers method must be used first
         * UNCOMMENT ALL LINES BELOW TO SET AND SORT CONTAINERS WITH MAXIMUM EFFICIENCY
         * FOR LOOP WILL SHOW THAT ALL PORTS HAVE DESIRED NUMBER OF CONTAINERS (0 AS IN NOT NEEDED OR NONE TO BE SENT)
         * Graph.setContainers();
         * Graph.sortContainers();
         * for(int i = 0; i < Graph.getVertices().size(); i++){
         * System.out.println(Graph.getVertices());
         * System.out.println(Graph.getVertices().get(i).getContainers();
         * }
         *
         */

         /*
          * UNCOMMENT BELOW TO SEND ALL CONTAINERS BACK TO THEIR ORIGINAL DESTINATIONS (REVERSE FLOW)
          * returnContainersToOrigin(Graph);
          */
    }
    public static ConnectionGraph makeGraph() {
        //MAKE VERTEX NAMES AND ADD ALL TO AN ARRAY
        ConnectionGraph newGraph = new ConnectionGraph();
        Vertex JNU=new Vertex("Jawaharlal Nehru");
        Vertex MOM=new Vertex("Mombasa");
        Vertex DES=new Vertex("Dar Es Salaam");
        Vertex ZAN=new Vertex("Zanzibar");
        Vertex JAD=new Vertex("Jebel Ali Dubai");
        Vertex TAP=new Vertex("Tanjung Pelepas");
        Vertex SAL=new Vertex("Salalah");


        /*
         * ADD ALL VERTICES
         * NOTE: I have added all vertexes in order of biggest to smallest, sorting them separately makes the algorithm
         * unnecessarily longer, if needed it can be done
         */


        newGraph.addVertex(TAP);newGraph.addVertex(DES);
        newGraph.addVertex(JNU);newGraph.addVertex(ZAN);
        newGraph.addVertex(MOM);newGraph.addVertex(SAL);
        newGraph.addVertex(JAD);
        //ADD ALL EDGES
        newGraph.addEdge(TAP, MOM, 5000);
        newGraph.addEdge(TAP, DES, 3000);
        newGraph.addEdge(TAP, ZAN, 2000);
        newGraph.addEdge(TAP, JAD, 7000);
        newGraph.addEdge(TAP, SAL, 7000);

        newGraph.addEdge(DES, TAP, 5000);
        newGraph.addEdge(DES, JNU, 3000);
        newGraph.addEdge(DES, JAD, 2000);

        newGraph.addEdge(JNU,MOM, 2000);
        newGraph.addEdge(JNU, DES, 2000);

        newGraph.addEdge(MOM, SAL, 2000);
        newGraph.addEdge(MOM, JAD, 500);



        return newGraph;
    }

    private static void returnContainersToOrigin(ConnectionGraph newGraph){
        int total = 0;
        for (int i = 0; i < newGraph.getVertices().size(); i++) {
            Vertex current = newGraph.getVertices().get(i);
            for (Edge e: current.OutEdge) {
                System.out.println("Total cost to move containers back = " + (e.weight*100) + "$");
                total+=e.weight*100;
                current.setContainers(current.getContainers() - e.weight);
            }
        }
        System.out.println("Total cost to move all containers back to their origins = " + total + "$");
    }
}
