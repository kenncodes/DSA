public class UnionByRank {
    private int [] root;
    private int [] rank; 

    public UnionByRank(int size){
        root = new int [size];
        rank = new int [size];
        for(int i = 0; i< size;i++){
            root[i] = i;
            rank[i] = 1;
        }
    }

    //find the root
    public int find(int x){ 
        while(x != root[x]){
            x = root[x];
        }
        return x;
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){

        }
    }

    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
}
