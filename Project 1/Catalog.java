import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.PrintWriter;
import java.lang.Exception;
import java.io.FileNotFoundException;

public class Catalog{ //Test Class
    public static void main(String[]args){
        Titles[] titlesList = new Titles[50];
        int count = 0;
        File file = new File("titles.txt");
        try{
        Scanner readFile = new Scanner(file);
        while(readFile.hasNextLine()){
            String firstLine = readFile.nextLine();//Will be read in line by line
                if((firstLine.charAt(0))=='P'){//periodical
                    String callNumber = firstLine;
                    String t = readFile.nextLine();//title
                    String p = readFile.nextLine();//publisher
                    String year = readFile.nextLine();
                    int y = Integer.parseInt(year);//year
                    String copies = readFile.nextLine();
                    int c = Integer.parseInt(copies);//copies
                    String month = readFile.nextLine();
                    int m = Integer.parseInt(month);//month
                    String issueNumber = readFile.nextLine();
                    int i = Integer.parseInt(issueNumber);//issueNumber
                    Periodical p1 = new Periodical(t, p, y, callNumber, c, m, i);
                    titlesList[count] = p1;
                    count++;
                }else if((firstLine.charAt(0))=='B'){//book
                    String callNumber = firstLine;
                    String t = readFile.nextLine();//title
                    String p = readFile.nextLine();//publisher
                    String year = readFile.nextLine();
                    int y = Integer.parseInt(year);//year
                    String copies = readFile.nextLine();
                    int c = Integer.parseInt(copies);//copies
                    String a = readFile.nextLine();//author
                    String ISBN = readFile.nextLine();
                    long i = Long.parseLong(ISBN);//ISBN
                    Book b1 = new Book(t, p, y, callNumber, c, a, i);
                    titlesList[count] = b1;
                    count++;
                }
        }
        readFile.close();//closes scanner used for reading file
    }catch(FileNotFoundException e){
        for(int i = 0; i < titlesList.length; i++){
            titlesList[i] = null;
        }

    }
         
        Scanner scnr = new Scanner(System.in);//declared new scanner for user input
        
        boolean notExit = true;
        while(notExit){
            //continuously prints user menu
            System.out.println("\nSelect an Operation");
            System.out.println("\n1: View all titles\n2: Search by call number\n3: Search by title\n4: Search by year \n5: Add new title\n" +
            "6: Remove title\n7: Sort titles by year\n8: View Titles due for restoration\n9: Exit");
            boolean valid = scnr.hasNextInt();
            if(valid){
                String c = scnr.nextLine();
                int choice = Integer.parseInt(c);
                //choices
                switch(choice){
                case 1:{//print media 
                    try{
                    LibManager.printTitles(titlesList, count);
                    }catch(NullPointerException e){
                        System.out.println(e);
                    }
                break;
                }case 2:{//search by call number
                    System.out.println("Enter a callNumber: ");
                    String callNumber = scnr.nextLine();
                    try{
                        LibManager.checkCallNumber(callNumber);
                    }catch(InvalidInfoException e){
                        System.out.println("Invalid CallNumber. Must be B-ddd-ddd-ddd or P-ddd-ddd-ddd");
                    }
                    LibManager.searchCallNumber(titlesList, count, callNumber);
                    
                break;
                }case 3:{//search by title
                    System.out.println("Enter a title: ");
                    String title = scnr.nextLine();
                    LibManager.searchTitles(titlesList, count, title);
                break;
                }case 4:{//search by year
                    System.out.println("Enter a year: ");
                    String year = scnr.nextLine();
                    int y = Integer.parseInt(year);
                    LibManager.searchYear(titlesList, count, y);
                    try{
                        LibManager.checkYear(y);
                    }catch(InvalidInfoException e){
                        System.out.println("Invalid Year. Must be between 1900 and 2022.");
                    }
                break;
                }case 5:{//add title
                    try{
                    if(LibManager.addTitles(scnr, titlesList, count)){
                        count += 1;
                    }
                    }catch(InvalidInfoException e){
                        System.out.println(e);
                    }
                    
                break; 
                }case 6:{//remove title by call number
                    System.out.println("Enter a callNumber: ");
                    String callNumber = scnr.nextLine();
                    try{
                        LibManager.checkCallNumber(callNumber);
                    try{
                        Titles[] removeList = LibManager.removeTitles(titlesList, count, callNumber);
                        if(titlesList.length != removeList.length){
                            titlesList = new Titles[removeList.length];
                            for(int i = 0; i< removeList.length; i++){
                                titlesList[i]  = removeList[i];
                            }
                            int rCount = count -1;
                            count = rCount;
                        }
                    }catch(Exception e){
                        System.out.println("Title not removed");
                        System.out.println(e);
                    }
                    }catch(InvalidInfoException e){
                        System.out.println("Invalid CallNumber. Must be B-ddd-ddd-ddd or P-ddd-ddd-ddd");
                    }

                break;
                }case 7:{//sort titles by year
                    LibManager.sortTitles(titlesList, count);
                    LibManager.printTitles(titlesList, count);
                break;
                }case 8:{//check to see if titles are restorable
                    LibManager.restore(titlesList, count);
                break;
                }
                case 9:{//save file 
                    LibManager.saveList(titlesList,"titles.txt", count);
                    System.out.println("Thank you for using my program. Bye!");
                    notExit = false;
                    break;
                }
                default:{
                    System.out.println("Invalid: out of bounds!");}  
                break; }     
            }else{
                System.out.println("Invalid Input");}
        }

    }

    }
        
