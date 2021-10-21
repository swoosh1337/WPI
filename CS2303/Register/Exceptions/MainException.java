
package Exceptions;


public class MainException extends Exception {


    public MainException() {
    }

  
    public MainException(String msg) {
        super(msg);
    }

    
    
    private Exception exceptions[] = new Exception[20];

    public Exception[] getExceptions() {
        return exceptions;
    }
    
    private int index;

    public int getIndex() {
        return index;
    }
    
    public void add(Exception ex){
        exceptions[index] = ex;
        index++;
    }
 
}
