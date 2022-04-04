/*
Zaara Yakub
CSE17: Project 1 
*/
 public abstract class Titles
            implements Comparable<Titles, Titles>, Restorable{
    
    private String title;
    private String publisher;
    private int year;
    private String callNumber; 
    protected int copies;
    
    protected Titles(){
    }
    protected Titles(String title, String publisher, int year, String callNumber, int copies){
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.callNumber = callNumber; 
        this.copies = copies;
    }
    //Imlemented interface to compare Titles by year order
    public int compareTo(Titles a, Titles b){
        if(a.getYear()==b.getYear()){
            return 0;
        }else if(a.getYear()<b.getYear()){
            return -1;
        }else{
            return 1;
        }
    }
    //abstract interface isRestorable
    //could use "current year" from class calendar 
    public boolean isRestorable(Titles a){
        boolean restorable = false;
        int current = 2022;
        if(current - (a.getYear()) > 20){
            restorable = true;
            return restorable;
        }else if(current - (a.getYear()) < 20){
            restorable = false ;
        }else{
            restorable = false;
        }
        return restorable;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public String getPublisher(){
        return publisher;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getYear(){
        return year;
    }
    public void setCallNumber(String callNumber){
        this.callNumber = callNumber;
    }
    public String getCallNumber(){
        return callNumber;
    }
    public void setCopies(int copies){
        this.copies = copies;
    }
    public int getCopies(){
        return copies;
    }
    public String toString(){
        return String.format("%-10s\t%-45s\t%-20s\t%-20s",
            callNumber, title, publisher, year);
    }
    public String simpleString(){
        String print = callNumber + "\n" + title + "\n" + publisher + "\n" + year + "\n" + copies +"\n";
        return print;
    }

{
}
}