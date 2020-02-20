import java.io.File;
import java.io.IOException;
import java.io.File; 
import java.util.*;
import com.cheetah.hashcode.Library;
// Import this class to handle errors
import java.io.FileNotFoundException; 
public class ReadInput{
    public static void main(String[] args) {
        boolean isFirst=true;
        boolean isSecond=false;
        boolean isThird=false;
        boolean isFourth=false;
        int noOfBooks=0;
        int noOfLibraries=0;
        int totalDays=0;
        List<Long> allBooksScore=new ArrayList<>();
        List<Library> allLibrary=new ArrayList<>();
        Library library=new Library();
        try {
            File myObj = new File("input.txt");  
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] arr =data.split(" ");
            if(isFirst){
                isFirst=false;
                isSecond=true;
                noOfBooks=Integer.parseInt(arr[0]);
                noOfLibraries=Integer.parseInt(arr[1]);
                totalDays=Integer.parseInt(arr[2]);
                System.out.println("noOfBooks: "+ noOfBooks);
                System.out.println("noOfLibraries: "+ noOfLibraries);
                System.out.println("totalDays: "+ totalDays);
            }
            else if(isSecond){
                for (String string : arr) {
                    allBooksScore.add(Long.parseLong(string));
                }
                isSecond =false;
                isThird=true;
            }

            else if(isThird){
                isThird=false;
                isFourth=true;
                library=new Library();
                library.setNoOfBooks(Integer.parseInt(arr[0]));
                library.setSignUpDays(Integer.parseInt(arr[1]));
                library.setBooksDispatchedPerDay(Integer.parseInt(arr[2]));
            }
            else if(isFourth){
                isFourth=false;
                isThird=true;
                List<Long> bookScores=new ArrayList<>();
                for (String string : arr) {
                    bookScores.add(allBooksScore.get(Integer.parseInt(string)));
                }
                library.setScoreOfEachBook(bookScores);
                allLibrary.add(library);
            }
            
            }
            myReader.close();
            } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
    }

}