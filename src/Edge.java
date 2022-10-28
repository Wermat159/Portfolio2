class Edge{
    Vertex from;
    Vertex to;
    Integer weight;
    public Edge(Vertex from,Vertex to, Integer weight){
        this.from=from;
        this.to=to;
        this.weight=weight;
        from.OutEdge.add(this);
        to.InEdge.add(this);
    }
    public String toString(){ return from+"->"+to+"::"+weight;}
}