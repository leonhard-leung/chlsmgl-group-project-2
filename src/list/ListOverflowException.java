package list;

public class ListOverflowException extends Throwable{
    public ListOverflowException() {
        super("Size limit attained.");
    } // end of default constructor
} // end of ListOverflowException class
