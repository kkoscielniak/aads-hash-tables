package hashtables;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * Provides methods for generating the array
 * @author krystian
 * @param <T>
 */
public class ArrayGenerator<T> {
    private T[] array; 
    private final Class<T> type;
    
    public void setArray(T[] array) {
        this.array = array;
    }
    
    public T[] getArray() {
        return this.array;
    }
    
    public Class<T> getType() {
        return this.type;
    }
    
    public ArrayGenerator(int size, int elSize, Class<T> type) {
        
        this.type = type;
        
        if (type == String.class) {
            System.out.println("Generating strings array");
//            GenerateRandomStringArray(size, elSize, type);
        } else if (type == Double.class) {
            System.out.println("Generating integer array");
            GenerateRandomDoublesArray(size, elSize, type);
        } else {
            throw new UnsupportedOperationException("Type not supported");
        }
    }

    private void GenerateRandomStringArray(int size, int elSize, Class<T> type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void GenerateRandomDoublesArray(int size, int elSize, Class<T> type) {
        
        Random random = new Random();
        
        @SuppressWarnings({"unchecked"})
        final Double[] arr = (Double[])Array.newInstance(type, size);
       
        for(int i=0; i<size; i++) {
            Double d = random.nextDouble()*((long)Math.pow(10, random.nextInt(elSize-1)+1));
            arr[i] = d;
        }
        
        this.array = (T[]) arr;
    }
}
