package com.cheetah.hashcode.processing;

import com.cheetah.hashcode.Library;
import java.util.ArrayList;
import java.util.List;

public class Processing {

  private List<Library> listOfLibraries = new ArrayList<>();
  private long numberOfDays = 0;
  public Processing(List<Library> listOfLibraries,long numberOfDays){
    this.listOfLibraries = listOfLibraries;
    this.numberOfDays = numberOfDays;
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
      long totalWorkUnitsDone = numberOfEligibleWorkDays * library.getBooksDispatchedPerDay();
      library.setCalculatedScore(totalWorkUnitsDone);
      return library;
  }


}
