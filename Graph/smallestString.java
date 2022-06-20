import java.util.ArrayList;
import java.util.List;

public class smallestString {

    int [] root;
    int [] rank;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int size= s.length();

        root = new int[size];
        rank = new int[size];
        int [][] graph = new int[size][size];

        //initialize rank and root values
        for(int i=0;i<size;i++){
            root[i] = i;
            rank[i] = 1;
        }

        //create a 2d array
        for(int i=0; i< pairs.size();i++){          
            int x = pairs.get(i).get(0);
            int y = pairs.get(i).get(1);
            graph[x][y] = 1;
            union(x,y);
        }

        for(int i=0;i<s.length(); i++){
            for(int j=0;j<s.length();j++){
           //    System.out.println(connected(i,j));
               if(connected(i,j)){
                    if(s.charAt(i) < s.charAt(j)){
                        char temp = s.charAt(i);
                        s = s.replace(s.charAt(i), s.charAt(j));
                        s = s.replace(s.charAt(j), temp);
                        System.out.println(s.charAt(i) + " is less than " + s.charAt(j)+ 
                        "; new s is: "  + s);
                    }else if (s.charAt(i) > s.charAt(j) ){
                        char temp = s.charAt(j);
                        s = s.replace(s.charAt(i), s.charAt(j));
                        s = s.replace(s.charAt(j), temp);
                        System.out.println(s.charAt(i) + " is greater than " + s.charAt(j)+ 
                        "; new s is: "  + s);
                    }else{
                        System.out.println("neither: " + s);
                    }
                  //  System.out.println(s);
               }
            }
        }


        
        return s;
    }


    public void union(int x , int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY] ){
                root[rootY] = rootX;
            }else if( rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootX] += 1;
            }

        }

    }

    public int find(int x){
        if(x == root[x]){
            return x;
        }
        return root[x] = find(root[x]);
    }

    public boolean connected(int x, int y){
        return find(x) == find(y);
    }

    public static void main(String[]args){
        smallestString s = new smallestString();
        List<List<Integer>> listOfLists = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        List<Integer> innerList2 = new ArrayList<>();
        innerList.add(0);
        innerList.add(3);
        innerList2.add(1);
        innerList2.add(2);
        listOfLists.add(innerList);
        listOfLists.add(innerList2);

        s.smallestStringWithSwaps("dcab", listOfLists );
    }
}