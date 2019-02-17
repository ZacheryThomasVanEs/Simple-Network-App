import java.util.Stack;

/**
 * Zachery Van Es
 */

public class UndirectedGraph<T> extends DirectedGraph<T> implements GraphInterface<T>, java.io.Serializable {
    public UndirectedGraph() {
        super();
    }

    public boolean addEdge(T begin, T end, double edgeWeight) {
        boolean result = false;
        result = super.addEdge(begin, end, edgeWeight);
        result = super.addEdge(end, begin, edgeWeight);

        return result;
    }

    public boolean addEdge(T begin, T end) {
        boolean result = false;
        result = super.addEdge(begin, end);
        result = super.addEdge(end, begin);

        return result;
    }

    public int getNumberOfEdges() {
        return super.getNumberOfEdges() / 2;
    }

    public Stack<T> getTopologicalOrder() throws UnsupportedOperationException {
        return super.getTopologicalOrder();

    }

}
