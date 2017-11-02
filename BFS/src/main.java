

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class main { 

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		FileInput f = new FileInput("Sample_Classes.csv");
		
		System.out.println("");
		
		//boolean done = false;
		
		Scanner in = new Scanner(System.in);
		
		ArrayList<ClassInfo> listOfTakenClasses = new ArrayList<ClassInfo>();
		
		for(ClassInfo c: f.getListOfClassInfo()) {
			System.out.println("Have you taken " + c.getName() + "?");
			String input = in.next();
			if(input.equals("y")) {
				listOfTakenClasses.add(c);
			}
		}
		
		
		//while(!done) {
			
			Node takenClasses = new Node(listOfTakenClasses);
			
			AvailableClasses ac = new AvailableClasses(takenClasses, f.getListOfClassInfo());
			
			ArrayList<ClassInfo> avc = ac.checkAvailableClasses();
			
//			if(ac.checkGoalNode()) {
//				done = true;
//				break;
//			}
			
			ClassInfo arr[] = new ClassInfo[avc.size()]; 
			
			Combination combination = new Combination(avc.toArray(arr), 12);
			
			ArrayList<ArrayList<ClassInfo>> comboClasses = combination.getCombinations();
			
			for(ArrayList<ClassInfo> combArr: comboClasses) {
				int i = 0;
				Node childNode = new Node(combArr);
				childNode.setTakenClasses(listOfTakenClasses);
				ArrayList<ClassInfo> newListOfTakenClasses = childNode.getTakenClasses();
				takenClasses.addChild(childNode);
				
				if(i == 111) {
					System.out.println("");
					System.out.println("");
					System.out.println("---------------------------------------------------------");
					for(ClassInfo ci : newListOfTakenClasses)
						System.out.println(ci);
					
				}
				i++;
			}
			
			
		
			
			
//			AvailableClasses updateAvailableClasses = new AvailableClasses(childNode, combArr);
//			Node newNode = new Node(updateAvailableClasses.checkAvailableClasses());
			
			//done = true;
			
		//}
		
		
		
//		MakeTree MT = new MakeTree(f.getListOfClassInfo());
//		
//		MT.MakeT();

		
	/*	
		List<ClassInfo> root1 = new ArrayList<ClassInfo>();
		Node<List<ClassInfo>> root = new Node<>(root1);

		ClassInfo child1 = new ClassInfo("CS1000", 01231, 3, "NA", false, 1);
		List<ClassInfo> l1 = new ArrayList<ClassInfo>();
		l1.add(child1);
		Node<List<ClassInfo>> child_1 = new Node<>(l1);
		
		ClassInfo child2 = new ClassInfo("CS1010", 04531, 3, "NA", false, 2);
		List<ClassInfo> l2 = new ArrayList<ClassInfo>();
		l2.add(child2);
		Node<List<ClassInfo>> child_2 = new Node<>(l2);
		
		
		root.addChild(child_1);
		root.addChild(child_2);
		
	

		ClassInfo gchild1 = new ClassInfo("CS2500", 01231, 3, "NA", false, 3);
		List<ClassInfo> l3 = new ArrayList<ClassInfo>();
		l3.add(gchild1);
		Node<List<ClassInfo>> gchild_1 = new Node<>(l3);
		
		ClassInfo gchild2 = new ClassInfo("CS3900", 01231, 3, "NA", false, 3);
		List<ClassInfo> l4 = new ArrayList<ClassInfo>();
		l4.add(gchild2);
		Node<List<ClassInfo>> gchild_2 = new Node<>(l4);

	
		child_1.addChild(gchild_1);
		child_1.addChild(gchild_2);

		ClassInfo ggchild1 = new ClassInfo("CS4440", 01231, 3, "NA", false, 5);
		List<ClassInfo> l5 = new ArrayList<ClassInfo>();
		l5.add(ggchild1);
		Node<List<ClassInfo>> ggchild_1 = new Node<>(l5);
	
		gchild_1.addChild(ggchild_1);

		System.out.println("Breadth First Search : ");
		
		T_BFS bfs = new T_BFS(root);
		//ArrayList<Node> path = bfs.findShortestPath();
		
		*/
	
	
	}
	

}