import java.util.ArrayList;


public class ConnectionGraph {
        private ArrayList<Vertex> Vertices;
        public ConnectionGraph(){
            Vertices=new ArrayList<Vertex>();
        }

        public ArrayList<Vertex> getVertices() {
        return Vertices;
    }

        public void setVertices(ArrayList<Vertex> vertices) {
        Vertices = vertices;
    }
        public void addVertex(Vertex v){
            Vertices.add(v);
        }
        public void addEdge(Vertex from, Vertex to, Integer weight){
            if(!(Vertices.contains(from) && Vertices.contains(to)))
            {
                System.out.println("Vertices missing from graph");
                return;
            }
            Edge newE=new Edge(from, to, weight);
        }
        public void printGraph(){
            for(int i=0;i<Vertices.size();i++){
                Vertex current=Vertices.get(i);
                System.out.println("------------------------------");
                System.out.println("Port "+Vertices.get(i).name+" is connected to: \n");
                for (Edge e: current.OutEdge) {
                    System.out.println("-" + e.to.name + " with weight: " + e.weight);

                }
                if(current.getContainers()>0){
                    System.out.println("*Number of containers needed back: "+current.getContainers());
                }
                else if(current.getContainers()<0){
                    System.out.println("*Number of containers to send back: "+ Math.abs(current.getContainers()));
                }
            }
        }
        public void sortContainers(){ //SORT FROM BIGGEST TO SMALLEST
           Vertex last = Vertices.get(Vertices.size()-1);
           Vertex current;
           int j = 1;
           int total = 0;
            for (int i = 1; i < Vertices.size()-1; i++) {
                current = Vertices.get(i-1);
                System.out.println("*******************");
                while(true) {
                    if (current.getContainers() != 0) {
                        int temp = current.getContainers() + last.getContainers();
                        if (temp > 0) {
                            System.out.println(last.getName() + " has shipped " + Math.abs(last.getContainers()) + " containers to " +
                                    current.getName() +"\nCost = " + (Math.abs(last.getContainers())*100) + "$");
                            System.out.println("----------------------");
                            current.setContainers(temp);
                            total+=(Math.abs(last.getContainers())*100);
                            last.setContainers(0);
                            if(Vertices.size()-j > 0){
                                j++;
                                last = Vertices.get(Vertices.size()-j);
                            }
                            else {
                                break;
                            }
                        } else if (temp < 0) {
                            System.out.println(last.getName() + " has shipped " + current.getContainers() +
                                    " containers to " + current.getName() + "\nCost = "
                                    + (Math.abs(current.getContainers()*100))+ "$");
                            last.setContainers(temp);
                            total+=(current.getContainers()*100);
                            current.setContainers(0);

                            break;
                        }
                        else if(temp == 0){
                            System.out.println(last.getName() + " has shipped " + Math.abs(last.getContainers())
                                    + " containers to " + current.getName() + "\nCost = "
                                    + (Math.abs(last.getContainers()*100)) + "$");
                            current.setContainers(0);
                            total+=(Math.abs(last.getContainers())*100);
                            last.setContainers(0);
                            break;
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
            }
            System.out.println("Total: " + total+ "$");
        }
        public void setContainers(){
            for (int i = 0; i < Vertices.size(); i++) {
                int containers_sent = 0;
                int containers_received = 0;
                int net;
                Vertex current=Vertices.get(i);
                for (Edge e: current.OutEdge) {
                    containers_sent+=e.weight;
                }
                for (Edge e: current.InEdge){
                    containers_received+=e.weight;
                }
                net = containers_sent-containers_received;
                current.setContainers(net);
                current.setContainersSent(containers_sent);
                current.setContainersReceived(containers_received);
            }
        }


}
