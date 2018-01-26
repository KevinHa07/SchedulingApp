package BFS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Node<T>{
    private T data = null;
    @SuppressWarnings("rawtypes")
	private List<Node> children = new ArrayList<>();
    private Node<?> parent = null;
    private int numOfElectiveUnits = 0;
    

	@SuppressWarnings("rawtypes")
	private ArrayList<Node> path = new ArrayList<>();
    private ArrayList<ClassInfo> TakenClasses = new ArrayList<>();

    public Node(T data) {
        this.data = data;
    }

    public void addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        Node<T> newChild = new Node<>(data);
        newChild.setParent(this);
        children.add(newChild);
    }

    @SuppressWarnings("rawtypes")
	public void addChildren(List<Node> children) {
        for(Node<?> t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    @SuppressWarnings("rawtypes")
	public List<Node> getChildren() {
        return children;
    }
    
    public void insertChildren(Node<?> child) {
    	
    }
    
    public void deleteChildren(Node<?> child) {
    	
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(Node<?> parent) {
        this.parent = parent;
    }

    public Node<?> getParent() {
        return parent;
    }

    public int getNumOfElectiveUnits() {
		return numOfElectiveUnits;
	}

	public void setNumOfElectiveUnits(int numOfElectives) {
		this.numOfElectiveUnits += numOfElectives;
	}
	
	public void startPath(Node<T> currentNode) {
		this.path.add(currentNode);
		setTakenClasses();
		
	}

	@SuppressWarnings("rawtypes")
	public void addToPath(Node<T> currentNode, ArrayList<Node> pathNode) {
		for(Node<?> n : pathNode) {
			this.path.add(n);
		}
		this.path.add(currentNode);
		setTakenClasses();
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList<Node> getPath(){
		return this.path;
	}
	
	@SuppressWarnings("rawtypes")
	public Node<ArrayList<Node>> getListNodes(){
		Node<ArrayList<Node>> listOfNodes = new Node<ArrayList<Node>>(this.path);
		return listOfNodes;
	}
	
	private void setTakenClasses(){
		if(this.path.get(this.path.size() - 1).getData() == null) {
			return;
		}
		for(Node<ArrayList<ClassInfo>> n : this.path) {
			for(ClassInfo c : n.getData()) {
				this.TakenClasses.add(c);
//				System.out.println(c);
			}
		}
//		System.out.println("--------------------------------------");
//		System.out.println("");
//		System.out.println("");
		
		
		
	}
	
	public ArrayList<ClassInfo> getTakenClasses(){
		return this.TakenClasses;
	}
	
}
