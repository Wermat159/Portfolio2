import java.lang.reflect.Array;
import java.util.ArrayList;

class Vertex {
    String name;
    ArrayList<Edge> OutEdge;
    ArrayList<Edge> InEdge;
    private int containers;
    private int containersSent;
    private int containersReceived;
    public int getContainers() {
        return containers;
    }

    public void setContainers(int containers) {
        this.containers = containers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContainersSent() {
        return containersSent;
    }

    public void setContainersSent(int containersSent) {
        this.containersSent = containersSent;
    }

    public int getContainersReceived() {
        return containersReceived;
    }

    public void setContainersReceived(int containersReceived) {
        this.containersReceived = containersReceived;
    }

    public Vertex(String name){
        this.name=name;
        OutEdge=new ArrayList<Edge>();
        InEdge=new ArrayList<Edge>();
        this.containers = containers;
        this.containersReceived= containersReceived;
        this.containersSent = containersSent;
    }
    public String toString(){ return name;}
}