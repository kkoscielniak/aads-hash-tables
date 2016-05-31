package hashtables;

/**
 * Entry level of the program
 * @author krystian
 */
public class Program {
    
    /**
     * Determines type of hashing
     */
    public enum HashingMethod { 
        LP, 
        DH 
    }

    /**
     * @param args the command line arguments
    */
    public static void main(String[] args) {       
        System.out.println(Utils.getInstance().isNumeric(Utils.getInstance().xorshf96()));
    }   
}
