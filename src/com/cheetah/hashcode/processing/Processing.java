package com.cheetah.hashcode.processing;

import com.cheetah.hashcode.Library;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Processing {

  private List<Library> listOfLibraries = new ArrayList<>();
  private long numberOfDays = 0;
  private HashSet<Long> uniqueBookIds = new HashSet<>();
  public Processing(List<Library> listOfLibraries,long numberOfDays,HashSet<Long> uniqueBookIds){
    this.listOfLibraries = listOfLibraries;
    this.numberOfDays = numberOfDays;
    this.uniqueBookIds = uniqueBookIds;
  }


  public List<Library> returnProcessedData(){
    return processLibraryList();
  }

  private List<Library> processLibraryList(){
     List<Library> processedLibraries = new ArrayList<>();
    for (Library library : listOfLibraries){
          processedLibraries.add(calculateScore(library));
    }
    return processedLibraries;
  }


  private Library calculateScore(Library library){
      long numberOfEligibleWorkDays = this.numberOfDays - library.getSignUpDays();
      long totalWorkUnits = numberOfEligibleWorkDays * library.getBooksDispatchedPerDay();
      long totalCalculatedScore = 0;
      List<Long> eachBookScore = library.getScoreOfEachBook();
      eachBookScore.sort(Collections.reverseOrder());
      long numberOfIteration = 0;
      if(totalWorkUnits > eachBookScore.size()){
          numberOfIteration = eachBookScore.size();
      }else{
        numberOfIteration = totalWorkUnits;
      }

      for ( int  i =0 ; i< numberOfIteration ;i++){
        if(uniqueBookIds.contains(eachBookScore.get(i))){
          totalCalculatedScore = totalCalculatedScore + eachBookScore.get(i);
          uniqueBookIds.remove(eachBookScore.get(i));
        }
      }
      library.setCalculatedScore(totalCalculatedScore);
      return library;
  }


}
