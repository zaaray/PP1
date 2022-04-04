public class Periodical extends Titles{

    private int month;
    private int issueNumber;

    public Periodical(){
    }
    public Periodical(String title, String publisher, int year, String callNumber, int copies, int month, int issueNumber){
        super(title, publisher, year, callNumber, copies);
        this.month = month;
        this.issueNumber = issueNumber;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public int getMonth(){
        return month;
    }
    public void setIssueNumber(int issueNumber){
        this.issueNumber = issueNumber;
    }
    public int getIssueNumber(){
        return issueNumber;
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
        return super.simpleString() + month + "\n"+ issueNumber +"\n";
    }
}