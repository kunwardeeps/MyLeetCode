import java.util.List;

public class TopologicalSort {

    public static List<Integer> topologicalSort(Map<Integer, Integer> inDegree, Map<Integer, List<Integer>> graph) {
        List<Integer> res = new ArrayList<>();
        while(!inDegree.isEmpty()) {
            boolean noLoop = false;   
            for(int key : inDegree.keySet()) {  // find nodes with 0 indegree
                if(inDegree.get(key) == 0) {
                    res.add(key);
                    List<Integer> children = graph.get(key);  
                    for(int child : children) 
                        inDegree.put(child, inDegree.get(child) - 1);
                    inDegree.remove(key);      // remove the current node with 0 degree and start over
                    noLoop = true;
                    break;
                }
            }
            if(!noLoop)  // there is a loop --> All Indegree are not 0
                return new int[0];
        }
        return res;
    }

    /**          
     *  1 -> 2 -> 4
     *  1 -> 3 -> 5
     */
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4));
        graph.put(3, Arrays.asList(5));
        graph.put(4, null);
        graph.put(5, null);

        Map<Integer, Integer> inDegree = new HashMap<>();
        inDegree.put(1, 0);
        inDegree.put(2, 1);
        inDegree.put(3, 1);
        inDegree.put(4, 1);
        inDegree.put(5, 1);

        System.out.println(topologicalSort(inDegree, graph));
    }
    
}
