

import java.util.ArrayList;
import java.util.List;


public class MakeTree {

	private ArrayList<ClassInfo> listOfClassInfo;
	List<ClassInfo> root1 = new ArrayList<ClassInfo>();
	Node<List<ClassInfo>> root = new Node<>(root1); 
	
	public MakeTree(){
		
	}
	
	public MakeTree(ArrayList<ClassInfo> listOfClassInfo) {
		this.listOfClassInfo = listOfClassInfo;
	}

	public void MakeT() {
		
		ArrayList<ClassInfo> CL = new ArrayList<>();
		CL = listOfClassInfo;
		
		
		//Go through the list and find the highest rank
		int highestRank = 0;
		int temp = 0;
		
		for(int i = 0; i < CL.size(); i++){
			if(CL.get(i).getRank() > temp){
				temp = CL.get(i).getRank();
			}
			
			highestRank = temp;
		}
		
		
		//Put ClassInfo into Node
		
		ArrayList<Node<List<ClassInfo>>> cI = new ArrayList<>();
		for(int i = 0; i < CL.size(); i++){
			List<ClassInfo> list = new ArrayList<ClassInfo>(); 
			list.add(CL.get(i));
			Node<List<ClassInfo>> list_ = new Node<>(list);
			cI.add(list_);
		}
		
		
		//search the ranks and put into appropriate spots
		for(int i = 0; i < cI.size(); i++){
			if(cI.get(i).getData().get(0).getRank() == 1){
				root.addChild(cI.get(i));
			}
			else{
				int tempRank = 0;
				tempRank = cI.get(i).getData().get(0).getRank();
				
				for(int j = 0; j < cI.size(); j++){
						if(cI.get(j).getData().get(0).getRank() == tempRank -1){
							cI.get(j).addChild(cI.get(i));
							break;
						}
					}
				
				
			}
		}
		
		
		T_BFS bfs = new T_BFS(root);
	}
	
	
	

}
