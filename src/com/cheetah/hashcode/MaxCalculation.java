package com.cheetah.hashcode;

import com.cheetah.hashcode.Library;
import com.cheetah.hashcode.processing.Processing;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MaxCalculation {
  List<Library> mainList = new ArrayList<Library>();

  public void maxCalculatedScore(List<Library> calculatedList,HashSet<Long> hashSet,int totalDays) {
    while (calculatedList.size() > 0) {
      Library max = new Library();
      max.setCalculatedScore(Long.MIN_VALUE);
      for (int i = 0; i < calculatedList.size(); i++) {
        if (calculatedList.get(i).getCalculatedScore() > max.getCalculatedScore()) {
          max = calculatedList.get(i);
        }
      }
      int indexOfMax = calculatedList.indexOf(max);
      hashSet.addAll(max.getScoreOfEachBook());
      mainList.add(max);
      calculatedList.remove(indexOfMax);
      Processing processing = new Processing(calculatedList, totalDays-max.getSignUpDays(),hashSet);
      calculatedList = processing.returnProcessedData();
      maxCalculatedScore(calculatedList,hashSet,totalDays);
    }

    try {
      FileWriter file = new FileWriter("result.txt", true);
      file.write(mainList.size() + " \n");
      for (int i = 0; i < mainList.size(); i++) {
        file.write(mainList.get(i).getBooksDispatchedPerDay() + " \n");
      }
      file.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
