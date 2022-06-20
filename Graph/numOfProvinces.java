public class numOfProvinces {

    int[] root;
    int[] rank;
    int provinces;

    public int findCircleNum(int[][] isConnected) {
        //there are n cities
        int size = isConnected.length; 
        provinces = size;
        
        //initalize root and rank;
        root = new int [size];
        rank = new int [size];
        
        //loop to add rank and root
        for(int i=0;i< size;i++){
            root[i] = i;
            rank[i] = 1;
        } 
        
        for(int i=0;i<size;i++){
            for(int j =0;j<size;j++){
                if(isConnected[i][j] == 1){
                    union(i,j);
                }
            }
        }
        
        return provinces;
        
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            provinces--;
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }


    public static void main(String [] args){
        numOfProvinces n = new numOfProvinces();
        int [][] myArr = { { 1,0, 0 }, { 0,1,0 } , {0,0,1}};
        int x = n.findCircleNum(myArr);
        System.out.println(x);
    }
}