package com.cheetah.hashcode;

import com.cheetah.hashcode.processing.Processing;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.IOException;
import java.util.stream.Collectors;

public class MaxCalculation {
  List<Library> mainList = new ArrayList<Library>();

  public void maxCalculatedScore(List<Library> calculatedList,HashSet<Integer> hashSet,int totalDays) {
    while (calculatedList.size() > 0) {
      Library maxLibrary = getMaxLibrary(calculatedList);
      hashSet.addAll(maxLibrary.getBooks().stream().map(Book::getId).collect(Collectors.toCollection(HashSet::new)));
      mainList.add(maxLibrary);
      calculatedList.remove(maxLibrary);
      Processing processing = new Processing(calculatedList, totalDays-maxLibrary.getSignUpDays(),hashSet);
      calculatedList = processing.returnProcessedData();
//      maxCalculatedScore(calculatedList,hashSet,totalDays);
    }


  }

  private Library getMaxLibrary(List<Library> allLibraries){
    Library max = new Library();
    max.setCalculatedScore(Long.MIN_VALUE);
    for (int i = 0; i < allLibraries.size(); i++) {
      if (allLibraries.get(i).getCalculatedScore() > max.getCalculatedScore()) {
        max = allLibraries.get(i);
      }
    }
    return max;
  }

  public void writeTofile(){
    try {
      for(Library library:mainList){
        if(library.getLibraryId()==18){
          System.out.println();
        }
      }
      FileWriter file = new FileWriter("result_c.txt", true);
      file.write(mainList.size() + " \n");
      for (int i = 0; i < mainList.size(); i++) {
        file.write(mainList.get(i).getLibraryId()+" "+mainList.get(i).getBooks().size() + "\n");
        for(Book book : mainList.get(i).getBooks()){
          file.write(book.getId()+" ");
        }
        file.write("\n");
      }
      file.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
