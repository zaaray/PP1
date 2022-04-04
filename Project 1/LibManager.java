import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.PrintWriter;
import java.lang.Exception;
import java.io.FileNotFoundException;

public class LibManager{

/*
Method to save changed file 
@param list of Titles, filename (Titles.txt), count 
@return no return value
*/
public static void saveList(Titles[] list, String filename, int count){
    File file = new File(filename);
    try{
    PrintWriter writeFile = new PrintWriter(file);
    for(int i = 0; i<count; i++){//row
            writeFile.write(list[i].simpleString());
    }
    writeFile.close();
    }
    catch(FileNotFoundException e){
        System.out.println("Cannot write to file");
    }
}
/*
Method to print Titles list
@param list of media, count number of items in list to be printed
@return no return value
*/
public static void printTitles(Titles[] list, int count){
    for(int i = 0; i<count; i++){
        System.out.println(list[i].toString());
    }
}
/*
Method to search for Titles by call number in the first count number of items in the list
@param list of Titles, count number, call number being searched for 
@return  index of Titles if the Titles is found/ -1 otherwise 
*/
public static int searchCallNumber(Titles[] list, int count, String callNumber){
    int counter = -1;
    boolean found = false;
    for(int i = 0; i<count; i++){
        if((list[i].getCallNumber().toLowerCase()).equals(callNumber.toLowerCase())){
            System.out.println("\nTitles found: " + list[i].toString());
            found = true;
            counter++;   
        }
    }  
    if(!found == true){
        System.out.println("No titles with " + callNumber + " call number found");
    }
    return counter;
}
/*
Method to search for Titles in the first count number of items in the list
@param list of Titles, count number, title being searched for 
@return  index of Titles if the Titles is found/ -1 otherwise 
*/
public static int searchTitles(Titles[] list, int count, String title){
    int counter = -1;
    boolean found = false;
    for(int i = 0; i<count; i++){
        if(list[i].getTitle().toLowerCase().equals(title.toLowerCase())){
            System.out.println("\nTitles found: " + list[i].toString());
            found = true;
            counter++;
            
        }
    }  
    if(!found == true){
        System.out.println(title + " not found");
    }
    return counter;
}
/*
Method to search for Titles by year in the first count number of items in the list
@param list of Titles, count number, title being searched for 
@return  index of Titles if the Titles is found/ -1 otherwise 
*/
public static int searchYear(Titles[] list, int count, int year){
    int counter = -1;
    boolean found = false;
    for(int i = 0; i<count; i++){
        if(list[i].getYear() == year){
            System.out.println("\nTitles found: " + list[i].toString());
            found = true;
            counter++;   
        }
    }  
    if(!found == true){
        System.out.println("No titles with " + year + " year found");
    }
    return counter;
}

/*
Method to sort Titles numerically by year
@param list of Titles, count number
@return no return value
*/
public static void sortTitles(Titles[] list, int count){
    for (int i=1; i<count; i++) {
        //Insert element i in the sorted sub-list
        Titles currentVal = list[i];
        int j = i;
        while (j>0 && ((currentVal.compareTo(currentVal, (list[j - 1])))<0)){
        // Shift element (j-1) into element (j)
            list[j] = list[j - 1];
            j--;
        }
        // Insert currentVal at position j
        list[j] = currentVal;
    }
}
/*
Method to check if callNumber is a valid regex
@param callNumber and type of Titles
@return true or false if callNumber is valid or invalid combination of letters/numbers
*/
public static boolean checkCallNumber(String callNumber, String type)
    throws InvalidInfoException{
        //regex to see if call# matches
        if(type.equals("book") && callNumber.matches("B-\\d{3}-\\d{3}-\\d{3}") ){
            return true;
        }else if(type.equals("periodical") && callNumber.matches("P-\\d{3}-\\d{3}-\\d{3}")){
            return true;
        }else{
            throw new InvalidInfoException("\nInvalid call number: " + callNumber + " . Must be either B-ddd-ddd-ddd for type book, or P-ddd-ddd-ddd for type periodical");
        } 
}
//Overloaded Method
public static boolean checkCallNumber(String callNumber)
    throws InvalidInfoException{
        //regex to see if call# matches
        if(callNumber.matches("B-\\d{3}-\\d{3}-\\d{3}") || callNumber.matches("P-\\d{3}-\\d{3}-\\d{3}") ){
            return true;
        }else{
            throw new InvalidInfoException("\nInvalid call number: " + callNumber + " . Must be either B-ddd-ddd-ddd for type book, or P-ddd-ddd-ddd for type periodical");
        } 
}
/*
Method to check if year is valid
@param year 
@return true or false if year is valid or invalid 
*/
public static boolean checkYear(int year)
    throws InvalidInfoException{
        //year validation
        if(year >= 1900 && year <= 2022){
            return true;
        }else{
            throw new InvalidInfoException("Invalid year: " + year + " . Must be between the years 1900 and 2022");
        } 
}
/*
Method to check if month is valid
@param month 
@return true or false if month is valid/invalid 
*/
public static boolean checkMonth(int month)
    throws InvalidInfoException{
        //month validation
        if(month >= 1 && month <= 12){
            return true;
        }else{
            throw new InvalidInfoException("Invalid month: " + month + " . Must be between the numbers 1 and 12");
        } 
}
/*
Method to check if type is valid
@param type
@return true or false if type is valid/invalid
*/
public static boolean checkType(String type)
    throws InvalidInfoException{
        //month validation
        if(type.equals("book") || type.equals("periodical")){
            return true;
        }else{
            throw new InvalidInfoException("Invalid type of title. Must be a book or periodical.");
        } 
}
/*
Method to check if ISBN is valid
@param type
@return true or false if type is valid/invalid
*/
public static boolean checkISBN(String ISBN)
    throws InvalidInfoException{
        //month validation
        if(ISBN.length() == 10){
            return true;
        }else{
            throw new InvalidInfoException("Invalid length of ISBN. Must be 10 digits.");
        } 
}
/*
Method to add a title
@param scanner object for user input, list of titles, and count
@return no return value
*/
public static boolean addTitles(Scanner scnr, Titles[] list, int count){
    //int counter = 0;
    int copy = 0;
    boolean added = false;
    
        //Asks user for title's attributes
                    System.out.println("Enter the title: ");
                    String t = scnr.nextLine();
    
                    System.out.println("Enter the publisher: ");
                    String p = scnr.nextLine();
    
                    System.out.println("Enter the year of publication: ");
                    String year = scnr.nextLine();
                    int y = Integer.parseInt(year);
                    //validates year
                    try{
                        LibManager.checkYear(y);
    
                    System.out.println("Enter the number of copies: ");
                    String copies = scnr.nextLine();
                    copy = Integer.parseInt(copies);
                    
        //Depending on the type, either a Movie or Show object is created 
        if(searchTitles(list, count, t)==-1){//if  is not in list
            copy = Integer.parseInt(copies);
            int c = copy;
            System.out.println("Enter the type of title (book/periodical): ");
            String type = scnr.nextLine();
            //validates type
            try{
                LibManager.checkType(type);
            

            if(type.equals("periodical")){
                //callNumber
                System.out.println("Enter the call number (P-ddd-ddd-ddd): ");
                String callNum = scnr.nextLine();
                try{
                    checkCallNumber(callNum, type);

                System.out.println("Enter the month:");
                String month =  scnr.nextLine();
                int m = Integer.parseInt(month);
                try{
                
                checkMonth(m);
                //issueNumber         
                System.out.println("Enter the issue number:");
                String issueNumber =  scnr.nextLine();
                int i = Integer.parseInt(issueNumber);
                
                //new instance added to list
                Periodical newP = new Periodical(t, p, y, callNum, c, m, i);
                list[count] = newP;
                added = true;

                System.out.println("title added successfully");
                }catch (InvalidInfoException e) {
                    System.out.println("Invalid month. Must be between 1 and 12");}
    
                }catch(InvalidInfoException e){
                System.out.println("Invalid Call Number. Must be P-ddd-ddd-ddd for periodicals");}
            }else if(type.equals("book")){
                    //callNumber
                    System.out.println("Enter the call number (B-ddd-ddd-ddd): ");
                    String callNum = scnr.nextLine();
                    try{
                        checkCallNumber(callNum, type);
                    
                    //author
                    System.out.println("Enter the author:");
                    String a =  scnr.nextLine();
                
                    //ISBN        
                    System.out.println("Enter the ISBN (10 digits):");
                    String ISBN =  scnr.nextLine();
                    long i = Long.parseLong(ISBN);
                    try{
                        checkISBN(ISBN);
                    
                    
                    //new instance added to list
                    Book newB = new Book(t, p, y, callNum, c, a, i);
                    list[count] = newB;
                    added = true;
                    
                    System.out.println("title added successfully");
                }catch (InvalidInfoException e) {
                    System.out.println("Invalid ISBN. Must be 10 digits");}        
                }catch (InvalidInfoException e) {
                    System.out.println("Invalid Call Number. Must be B-ddd-ddd-ddd for books");}           
                
                }
            }
            catch (InvalidInfoException e) {
                System.out.println("Invalid Type. Must be a book or periodical");}
                
        }
    }catch (InvalidInfoException e) {
        System.out.println("Invalid year. Must be between 1900 and 2022.");}
        return added;           
        
}
/*
Method to remove user-specified Titles
@param list of Titles, count number of elements in the list, and title
@return count for index of element in list to be removed
*/
public static Titles[] removeTitles(Titles[] list, int count, String callNumber){
    Titles[] removeList = new Titles[list.length -1];
    Boolean found = false;
    
    int counter = 0;
    for(int i = 0; i < count; i++){
        if(list[i].getCallNumber().equals(callNumber)){
            found = true;
        }else{
            removeList[counter] = list[i];
            counter++;
        }
    }
    if(found){
        System.out.println("\nTitle removed successfully");
        return removeList;
        
    } else{
        System.out.println("Title doesn't exist");
        return list;
    }
}
/*
Method to restore titles with a publication date over 20 years ago
@param list of titles and count 
@return counter of number of titles available for restoration 
*/
public static int restore(Titles[] list, int count){
        int counter = -1;
        boolean found = false;
        for(int i = 0; i<count; i++){
            if(list[i].isRestorable(list[i])){
                System.out.println("\nTitles found: " + list[i].toString());
                found = true;
                counter++;   
            }
        }  
        if(!found == true){
            System.out.println("No titles for restoration were found");
        }
        System.out.println("Number of titles found: ");
        return counter;
}
}