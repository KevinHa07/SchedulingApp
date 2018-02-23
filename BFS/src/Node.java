package BFS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Node{
    private List<String> classTaken;
    @SuppressWarnings("rawtypes")
	
    private Node parent;
    private int numOfElectiveUnits = 0;
    private boolean isGoal = false;
    private List<String> availableClasses;

	@SuppressWarnings("rawtypes")
	private List<Node> path = new ArrayList<>();
    private List<String> takenClassesFromPath = new ArrayList<String>();

    public Node(List<String> data) {
        this.classTaken = data;
    }

    public List<Node> addChild(Node child) {
    	List<Node> children = new ArrayList<>();
        child.setParent(this);
        children.add(child);
        return children;
    }

	public List<Node> addChildren(List<Node> children) {
        for(Node t : children) {
            t.setParent(this);
        }
        return children;
    }

//	public List<Node> getChildren() {
//		//find available classes and do combination in here
//        return null;
//    }
    
//    public void insertChildren(Node<?> child) {
//    	
//    }
//    
//    public void deleteChildren(Node<?> child) {
//    	
//    }

    public List<String> getData() {
        return classTaken;
    }

    public void setData(List<String> data) {
        this.classTaken = data;
    }

    private void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public int getNumOfElectiveUnits() {
		return numOfElectiveUnits;
	}

	public void addNumOfElectiveUnits(int numOfElectives) {
		this.numOfElectiveUnits += numOfElectives;
	}
	
	public void startPath(Node currentNode) {
		this.path.add(currentNode);
		setTakenClasses();
		
	}

	@SuppressWarnings("rawtypes")
	public void addToPath(Node currentNode, List<Node> pathNode) {
		for(Node n : pathNode) {
			this.path.add(n);
		}
		this.path.add(currentNode);
		setTakenClasses();
	}
	
	@SuppressWarnings("rawtypes")
	public List<Node> getPath(){
		return this.path;
	}
	
	private void setTakenClasses(){
		if(this.path.get(this.path.size() - 1).getData() == null) {//get the previous node from the path and get the list of  classes taken from that point on the path
			return;
		}
		for(Node n : this.path) {
			takenClassesFromPath.addAll(n.getData());
		}
	}
	
	public List<String> getTakenClasses(){
		return takenClassesFromPath;
	}
	
	public boolean isGoal() {
		return isGoal;
	}

	public void setGoal(boolean isGoal) {
		this.isGoal = isGoal;
	}

	public List<String> getAvailableClasses() {
		return availableClasses;
	}

	public void setAvailableClasses(List<String> availableClasses) {
		this.availableClasses = availableClasses;
	}
	
	
	
}
