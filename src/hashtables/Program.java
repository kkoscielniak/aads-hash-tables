package hashtables;

/**
 * Entry level of the program
 * @author krystian
 */
public class Program {
    
    private static final int _dataSize = 1000019;
    private static final double _loadFactor = 0.7;

    /**
     * @param args the command line arguments
    */
    public static void main(String[] args) {               
//        ArrayGenerator<Double> strings;
//        strings = new ArrayGenerator<>(_dataSize, 25, Double.class);
//        Object[] stringsArray = strings.getArray();
        
        Object[] numbersArray = new Object[_dataSize];
        
        for (int i = 0; i < _dataSize; i++)
            numbersArray[i] = Utils.getInstance().xorshf96();
        
        Hashing h1 = new Hashing(_dataSize);
        
        h1.MakeOperations(_loadFactor, 0, HashingMethod.LP, numbersArray, 0);
        h1.ShowAvgs();
    }   
}
