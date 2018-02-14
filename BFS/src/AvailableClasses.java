package BFS;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import BFS.MakeTree;

public class AvailableClasses {

	private Node<?> current;
	private ArrayList<ClassInfo> classesTaken = new ArrayList<ClassInfo>();
	private ArrayList<ClassInfo> availableClasses = new ArrayList<ClassInfo>();
	long startTime = MakeTree.startTime;
	private Set<ClassInfo> setOfAvailableClasses;
	
	
	public AvailableClasses(Node<?> classtaken) {
		this.current = classtaken;
		
	}
	
	//This method takes in the arraylist of ClassInfo to remove classes that the student has already taken from an arraylist of all classes
	@SuppressWarnings("unchecked")
	public ArrayList<ClassInfo> checkAvailableClasses(ArrayList<ClassInfo> allClasses) {
		//creates a set of all classes
		setOfAvailableClasses = new HashSet<ClassInfo>(allClasses);
		ArrayList<Node<ArrayList<ClassInfo>>> currClassesTaken; //creates an arraylist of nodes containing arraylists of classinfo objects
		currClassesTaken = (ArrayList<Node<ArrayList<ClassInfo>>>) this.current.getData();//this is the list of classes taken or classes to be taken from the roadmap
		
		//adds classes from the node into an arraylist
		for(int i = 0; i < currClassesTaken.size(); i++){
			classesTaken.addAll(currClassesTaken.get(i).getData());
		}
		
		//if student hasn't taken any classes, add classes that has no prerequisites into available class array
		if(classesTaken.size() == 0) {
			for(ClassInfo aClass: setOfAvailableClasses){
				if(aClass.getPrerequisites() == null){
					this.availableClasses.add(aClass);
				}
			}
			return this.availableClasses;
		}
		
//		if(checkGoalNode()){ //instead of checking each class, make the whole arraylist a goal. Make into hashset containsall
//			for(int i = 0; i < currClassesTaken.size(); i++){
//				for(int j = 0; j < currClassesTaken.get(i).getData().size(); j++){
//					System.out.println((currClassesTaken.get(i).getData().get(j)));
//				}
//				System.out.println("");
//				System.out.println("");
//			}
//			
//			long endTime = System.currentTimeMillis();
//			long totaltime = endTime  - startTime;
//			System.out.print(totaltime);
//			System.exit(0);
//		}
		
		setOfAvailableClasses.removeAll(this.classesTaken); //removes all classes taken from all classes

		for(ClassInfo aClass: this.setOfAvailableClasses){
			if(aClass.getPrerequisites() == null){ //if no prerequisite, add class to available classes that user can add 
				this.availableClasses.add(aClass);	
			}
					
			//if there's a prerequisite, check to see if the student has taken the classes needed to add class to available classes that user can add
			else if(aClass.getPrerequisites() != null && this.classesTaken.containsAll(aClass.getPrerequisites())) { 
				//send availableClasses and aCLass to method to see if aClass is already in there
				this.availableClasses.add(aClass);	
			}
				
		}	

		return this.availableClasses;
		
	}
		
	//make method that checks classes inside arraylist
//	public boolean isClass(ArrayList<ClassInfo> availableClasses, ClassInfo aClass){
//		
//		int counter = 0;
//		
//		for(int i = 0; i < availableClasses.size(); i++){
//			if(availableClasses.get(i).getName().equals(aClass.getName())){
//				
//			}else{
//				counter++;
//			}
//		}
//		
//		
//		if(counter == availableClasses.size()){
//			return true;
//		}else{
//			return false;
//		}
//	}
	
	public boolean checkGoalNode() {
		for(ClassInfo c: this.classesTaken) {
			if(c.getName().toLowerCase().equals("cs4963")) {
				for(ClassInfo i: this.classesTaken){
					if(i.getName().toLowerCase().equals("cs4962")){
						return true;
					}
				}
				return false;
				
			}
		}
		return false;
	}
}

