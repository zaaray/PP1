public class Book extends Titles{

    private String author;
    private long ISBN;

    public Book(){
    }
    public Book(String title, String publisher, int year, String callNumber, int copies, String author, long ISBN){
        super(title, publisher, year, callNumber, copies);
        this.author = author;
        this.ISBN = ISBN;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getuthor(){
        return author;
    }
    public void setISBN(long ISBN){
        this.ISBN = ISBN;
    }
    public long getISBN(){
        return ISBN;
    }

    public String toString(){
        return String.format("%s", 
            super.toString());
    }
    public boolean isRestorable(Titles a){
        boolean restorable = false;
        int current = 2021;
        if(current - (a.getYear()) > 20){
            restorable = true;
        }else if(restorable != true){
            System.out.println("");
        }
        return restorable;
    }
    public String simpleString(){
        return super.simpleString() + author + "\n"+ ISBN +"\n";
    }
}