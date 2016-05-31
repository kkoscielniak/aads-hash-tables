package hashtables;

/**
 * Entry level of the program
 * @author krystian
 */
public class Program {
    
    private static final int _dataSize = 1000019;
    
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
        ArrayGenerator<Double> strings;
        strings = new ArrayGenerator<>(_dataSize, 25, Double.class);
    }   
}
