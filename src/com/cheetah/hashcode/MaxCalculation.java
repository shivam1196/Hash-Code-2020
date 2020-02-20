package hashcode2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxCalculation {
	List<Library> mainList = new ArrayList<Library>();
	
	public List<Library> maxCalculatedScore(List<Library> calculatedList){
		if(calculatedList.size() == 0) {
			return mainList;
		}
		Library max = new Library();
		for(int i = 0; i<calculatedList.size(); i++) {
			if(calculatedList.get(i).getCalculatedScore() > max.getCalculatedScore()) {
				max = calculatedList.get(i);
			}
		}
		int indexOfMax = calculatedList.indexOf(max);
		mainList.add(max);
		calculatedList.remove(indexOfMax);
		return processLibraryList(calculatedList);
	}
}
