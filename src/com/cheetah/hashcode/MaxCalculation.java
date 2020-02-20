package hashcode2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxCalculation {
	List<Long> mainList = new ArrayList<Long>();
	
	public List<Long> maxCalculatedScore(List<Long> calculatedList){
		if(calculatedList.size() == 0) {
			return mainList;
		}
		long max = Collections.max(calculatedList);
		int indexOfMax = calculatedList.indexOf(max);
		mainList.add(max);
		calculatedList.remove(indexOfMax);
		return processLibraryList(calculatedList);
	}
}
