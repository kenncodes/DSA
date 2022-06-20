public class DisjointSet {

    int [] root;
    int [] rank;

    public DisjointSet(int size){
        
    }

    public int find(int x){
        if(x == root[x]){
            return x; //we found the root
        }
        //path compression
        return root[x] = find(root[x]);
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootX] +=1;      
            }
        }
    }

    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
}
