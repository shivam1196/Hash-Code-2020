package com.cheetah.hashcode.processing;

import com.cheetah.hashcode.Book;
import com.cheetah.hashcode.Library;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Processing {

  private List<Library> listOfLibraries = new ArrayList<>();
  private long numberOfDays = 0;
  private HashSet<Integer> uniqueBookIds = new HashSet<>();
  public Processing(List<Library> listOfLibraries,long numberOfDays,HashSet<Integer> uniqueBookIds){
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
      List<Book> allBooks = library.getBooks();
      List<Book> remainingBooks = new ArrayList<>();
      allBooks.sort(new Comparator<Book>(){

        @Override
        public int compare(Book o1, Book o2) {
          if(o1.getScore() < o2.getScore()){
            return 1;
          }else if(o1.getScore() == o2.getScore()){
            return 0;
          }
          else {
            return -1;
          }
        }
      });
      long numberOfIteration = 0;
      if(totalWorkUnits > allBooks.size()){
          numberOfIteration = allBooks.size();
      }else{
        numberOfIteration = totalWorkUnits;
      }

      for ( int  i =0 ; i< numberOfIteration ;i++){
        if(!uniqueBookIds.contains(allBooks.get(i).getId())){
          totalCalculatedScore = totalCalculatedScore + allBooks.get(i).getScore();
          remainingBooks.add(allBooks.get(i));

        }
      }
      library.setCalculatedScore(totalCalculatedScore);
      library.setBooks(remainingBooks);
      return library;
  }


}
