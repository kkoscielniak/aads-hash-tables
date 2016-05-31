package hashtables;

/**
 * Provides some simple utilities
 * @author krystian
 */
public class Utils {
    
    private static Utils instance = null;
    
    private static Long x = (long) 123456789;
    private static Long y = (long) 362436069;
    private static Long z = (long) 521288629;
    
    public static Utils getInstance() {
        
        if (instance == null) {
            instance = new Utils();
        }        
        return instance;
    }
    
    /**
     * Generates big number, algorithm given by the tutor :)
     * @return
     */
    public static Long xorshf96() {
        
        Long tmp; 
        
        x ^= x << 16; 
        x ^= x >> 5;
        x ^= x << 1;
        
        tmp = x;
        x = y; 
        y = z; 
        z = tmp^x^y;
        return z;         
    }
    
    public static boolean isNumeric(Object o) {
        return (o instanceof Number);
    }
}
