package BFS;

import java.util.ArrayList;

public class Combinations {

	public Combinations() {
		
	}
	
	public ArrayList<ArrayList<ClassInfo>> findCombination(ArrayList<ClassInfo> arr, int minUnits, int maxUnits) {
		ArrayList<ArrayList<ClassInfo>> combClasses = new ArrayList<ArrayList<ClassInfo>>();
		
		for (int i = 0; i < arr.size(); i++) {
			int r = i+1;
			int sizeOfArr = arr.size();
			printCombination(arr, sizeOfArr, r, combClasses);
		}
		
		
		
		//if the number of units is over what they inputed then take it out of the array
		for(int i = 0; i < combClasses.size();){
			int totalUnits = 0;
			
			for( int j = 0; j < combClasses.get(i).size(); j++){
				totalUnits += combClasses.get(i).get(j).getUnits();
			}
			
			if(maxUnits < totalUnits || minUnits > totalUnits ){
				combClasses.remove(i);
			}
			else{
				i++;
			}
		}
		
		
		
		return combClasses;
		
	}

	//arr[]  ---> Input Array
    //data[] ---> Temporary array to store current combination
    //start & end ---> Staring and Ending indexes in arr[]
    //index  ---> Current index in data[]
    //r ---> Size of a combination to be printed */
    static void combinationUtil(ArrayList<ClassInfo> arr, ArrayList<ClassInfo> data, int start, int end, int index, int r,  ArrayList<ArrayList<ClassInfo>> combClasses){
    	
        // Current combination is ready to be printed, print it
        if (index == r){
        	ClassInfo temp = null;
        	ArrayList<ClassInfo> tempList = new ArrayList<ClassInfo>();
            for (int j=0; j<r; j++){
               temp =  data.get(j);
               tempList.add(temp);
            }
            
            combClasses.add(tempList);
            temp = null;	
            return;
        }
        
 
        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++){
            data.set(index, arr.get(i));
            combinationUtil(arr, data, i+1, end, index+1, r, combClasses);
        }
    }
 
    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(ArrayList<ClassInfo> arr, int sizeOfArr, int r,  ArrayList<ArrayList<ClassInfo>> combClasses){
        // A temporary array to store all combination one by one
    	ArrayList<ClassInfo> data= new ArrayList<ClassInfo>(r);
    	ClassInfo filler = null;
    	for(int i = 0; i < r; i++) {
    		data.add(filler);
    	}
        // Print all combination using temporary array 'data[]'
        combinationUtil(arr, data, 0, sizeOfArr-1, 0, r, combClasses);
    }
}