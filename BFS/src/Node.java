

import java.util.ArrayList;
import java.util.List;

public class Node<T>{
    private T data = null;
    private List<Node> children = new ArrayList<>();
    private Node parent = null;
    private int distance;
    private ArrayList<Node> path;
    private ArrayList<ClassInfo> previousClasses;

    public Node(T data) {
        this.data = data;
    }

    public void addChild(Node child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        Node<T> newChild = new Node<>(data);
        newChild.setParent(this);
        children.add(newChild);
    }

    public void addChildren(List<Node> children) {
        for(Node t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<Node> getChildren() {
        return children;
    }
    
    public void insertChildren(Node child) {
    	
    }
    
    public void deleteChildren(Node child) {
    	
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public void startPath(Node currentNode) {
		this.path.add(currentNode);
		
	}

	public void addToPath(Node currentNode, ArrayList<Node> pathNode) {
		for(Node<?> n : pathNode) {
			this.path.add(n);
		}
		this.path.add(currentNode);
	}
	
	public ArrayList<Node> getPath(){
		return this.path;
	}
	
	public Node<ArrayList<Node>> getListOfNodes(){
		Node<ArrayList<Node>> listOfNodes = new Node<ArrayList<Node>>(this.path);
		return listOfNodes;
	
	}
	
	public void setTakenClasses(ArrayList<ClassInfo> taken){
		previousClasses = taken;
		for(ClassInfo c:(ArrayList<ClassInfo>) this.getData()) {
			previousClasses.add(c);
		}
	}
	
	public ArrayList<ClassInfo> getTakenClasses(){
		return previousClasses;
	}
}
