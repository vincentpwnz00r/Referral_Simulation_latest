import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IncentiveNode<T> implements Iterable<IncentiveNode<T>> {
	T data;
	IncentiveNode<T> parent;
	List<IncentiveNode<T>> children;
	public IncentiveNode(){}
	public IncentiveNode(T data){
		this.data = data;
		this.children = new LinkedList<IncentiveNode<T>>();
	}
	
	public IncentiveNode<T> addChild(T child){
		IncentiveNode<T> childNode = new IncentiveNode<T>(child);
		childNode.parent = this;
		this.children.add(childNode);
		return childNode;
	}
	
	public int checkDepth(IncentiveNode<T> n) {
		int counter = 1;
		IncentiveNode<T> p = n;
		while (p.parent != null) {
			p = p.parent;
			counter++;
		}
		while(!n.children.isEmpty()) {
			n = n.children.get(0);
			counter++;
		}
		return counter;
	}

	/**
	 * checks for the current depth of a node.
	 * @param n Node to be checked.
	 * @return current depth.
	 */
	public int currentDepth(IncentiveNode<T> n){
		int counter = 1;
		while(n.parent != null) {
			counter++;
			n = n.parent;
		}
		return counter;
	}

	/**
	 * checks the deepest depth of the tree
	 * @param n any node in the user
	 * @param checker 0
	 * @return deepest depth.
	 */
	public int deepestDepth(IncentiveNode<T> n, int checker) {
		int deepest = 0;
		deepest = checkDepth(n);
		if(deepest > checker) {
			checker = deepest;
		}
		if(n.children.size() > 0) {
			for(int i = 0; i < n.children.size(); i++) {
				checker = deepestDepth(n.children.get(i), checker);
			}
		}
		return checker;
	}
	
	public IncentiveNode<T> getNextChild(IncentiveNode<T> n) {
		IncentiveNode<T> p = n.parent;
		int childSize = p.children.size();
		int next = -1;
		for(int i = 0; i < childSize; i++){
			IncentiveNode<T> test = p.children.get(i);
			if(n == test){
				next = i + 1;
				break;
			}
		}
		return p.children.get(next);
	}
	
	public int numChild(IncentiveNode<T> p){
		return p.children.size();
	}
	
 
	@Override
	public Iterator<IncentiveNode<T>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
