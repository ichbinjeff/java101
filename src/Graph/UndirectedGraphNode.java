package Graph;
import java.util.ArrayList;

/**
 * Created by jli on 11/8/15.
 */
public class UndirectedGraphNode {
    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

    public static void main(String[] args) {

    }
}


