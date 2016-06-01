package hashtables;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class responsible for hashing operations
 * @author krystian
 */
public class Hashing {

    public Hashing(int size) {
        this.table = new Object[size];
        this.length = size;
        this.LPInsertCounter = new ArrayList();
        this.LPSearchHitCounter = new ArrayList();
        this.LPSearchMissCounter = new ArrayList();
        this.LPRemoveCounter = new ArrayList();
        this.DHInsertCounter = new ArrayList();
        this.DHSearchHitCounter = new ArrayList();
        this.DHSearchMissCounter = new ArrayList();
        this.DHRemoveCounter = new ArrayList();
    }

    private Object[] table;
    public Object[] getTable() {
        return table;
    }
    public void setTable(Object[] table) {
        this.table = table;
    }

    private int length;

    private ArrayList LPInsertCounter;
    private ArrayList LPSearchHitCounter;
    private ArrayList LPSearchMissCounter;
    private ArrayList LPRemoveCounter;
    private ArrayList DHInsertCounter;
    private ArrayList DHSearchHitCounter;
    private ArrayList DHSearchMissCounter;
    private ArrayList DHRemoveCounter;
    private Double LPInsertAvg;
    private Double LPSearchHitAvg;
    private Double LPSearchMissAvg;
    private Double LPRemoveAvg;
    private Double DHInsertAvg;
    private Double DHSearchHitAvg;
    private Double DHSearchMissAvg;
    private Double DHRemoveAvg;

    public ArrayList getLPInsertCounter() {
        return LPInsertCounter;
    }

    public void setLPInsertCounter(ArrayList LPInsertCounter) {
        this.LPInsertCounter = LPInsertCounter;
    }

    public ArrayList getLPSearchHitCounter() {
        return LPSearchHitCounter;
    }

    public void setLPSearchHitCounter(ArrayList LPSearchHitCounter) {
        this.LPSearchHitCounter = LPSearchHitCounter;
    }

    public ArrayList getLPSearchMissCounter() {
        return LPSearchMissCounter;
    }

    public void setLPSearchMissCounter(ArrayList LPSearchMissCounter) {
        this.LPSearchMissCounter = LPSearchMissCounter;
    }

    public ArrayList getLPRemoveCounter() {
        return LPRemoveCounter;
    }

    public void setLPRemoveCounter(ArrayList LPRemoveCounter) {
        this.LPRemoveCounter = LPRemoveCounter;
    }

    public ArrayList getDHInsertCounter() {
        return DHInsertCounter;
    }

    public void setDHInsertCounter(ArrayList DHInsertCounter) {
        this.DHInsertCounter = DHInsertCounter;
    }

    public ArrayList getDHSearchHitCounter() {
        return DHSearchHitCounter;
    }

    public void setDHSearchHitCounter(ArrayList DHSearchHitCounter) {
        this.DHSearchHitCounter = DHSearchHitCounter;
    }

    public ArrayList getDHSearchMissCounter() {
        return DHSearchMissCounter;
    }

    public void setDHSearchMissCounter(ArrayList DHSearchMissCounter) {
        this.DHSearchMissCounter = DHSearchMissCounter;
    }

    public ArrayList getDHRemoveCounter() {
        return DHRemoveCounter;
    }

    public void setDHRemoveCounter(ArrayList DHRemoveCounter) {
        this.DHRemoveCounter = DHRemoveCounter;
    }

    public Double getLPInsertAvg() {
        return LPInsertAvg;
    }

    public void setLPInsertAvg(Double LPInsertAvg) {
        this.LPInsertAvg = LPInsertAvg;
    }

    public Double getLPSearchHitAvg() {
        return LPSearchHitAvg;
    }

    public void setLPSearchHitAvg(Double LPSearchHitAvg) {
        this.LPSearchHitAvg = LPSearchHitAvg;
    }

    public Double getLPSearchMissAvg() {
        return LPSearchMissAvg;
    }

    public void setLPSearchMissAvg(Double LPSearchMissAvg) {
        this.LPSearchMissAvg = LPSearchMissAvg;
    }

    public Double getLPRemoveAvg() {
        return LPRemoveAvg;
    }

    public void setLPRemoveAvg(Double LPRemoveAvg) {
        this.LPRemoveAvg = LPRemoveAvg;
    }

    public Double getDHInsertAvg() {
        return DHInsertAvg;
    }

    public void setDHInsertAvg(Double DHInsertAvg) {
        this.DHInsertAvg = DHInsertAvg;
    }

    public Double getDHSearchHitAvg() {
        return DHSearchHitAvg;
    }

    public void setDHSearchHitAvg(Double DHSearchHitAvg) {
        this.DHSearchHitAvg = DHSearchHitAvg;
    }

    public Double getDHSearchMissAvg() {
        return DHSearchMissAvg;
    }

    public void setDHSearchMissAvg(Double DHSearchMissAvg) {
        this.DHSearchMissAvg = DHSearchMissAvg;
    }

    public Double getDHRemoveAvg() {
        return DHRemoveAvg;
    }

    public void setDHRemoveAvg(Double DHRemoveAvg) {
        this.DHRemoveAvg = DHRemoveAvg;
    }





    public boolean LPInsertion(Object value, int a) {
        int k;
        int counter = 0;
        for (int i = 0; i < length - 1; i++)
        {
            k = LPHashFunction(value, i, a, counter);

            if (table[k] == null) {
                LPInsertCounter.add(counter);
                table[k] = value;
                return true;
            }
        }
        return false;
    }

    private int LPHashFunction(Object value, int i, int a, int count) {
        System.out.println(value);
        count++;
        if (value instanceof Integer && a == 0) {
            if (i == 0)
                return (int)value % length;
            else
                return (LPHashFunction(value, 0, 0, count) + 3 * i) % length;
        }
//        else if (value instanceof String && a > 0)
//        {
//            int h = 0, c = 29;
//
//            for(int j = 0; j < value.toString().length(); j++)
//                h = (c * h + value.toString().charAt(j)) % a;
//
//            h = (h + i) % a;
//
//            return h;
//        }
        else return 0;
    }

    public void MakeOperations(double loadFactor, int operationType, HashingMethod method, Object[] tab, int a)
    {
        String opType;
        if (operationType == 0) {
            opType = "Insertion";
        }
        else if (operationType == 1) {
            opType = "Search";
        }
        else {
            opType = "Remove";
        }

        System.out.println("Executing operation:");
        System.out.println("Operation type: " + method.toString() + " " + opType);
        System.out.println("Data type: " + tab[0].getClass().toString());

        ClearTable();

        int load = (int)(this.length * loadFactor);
        int ten = (int)(load + load * 0.1);
        boolean check;

        if (method == HashingMethod.LP)
        {
            for (int i = 0; i < load; i++)
                check = this.LPInsertion(tab[i], a);

            this.LPInsertCounter.clear();
        }
        else
        {
//            for (int i = 0; i < load; i++)
//                check = this.DHInsertion(tab[i], a);
//
//            this.DHInsertCounter.Clear();
        }

        double loadCount = 0;

        for (Object table1 : this.table) {
            if (table1 != null) {
                loadCount += (double)1;
            }
        }

        System.out.println(loadCount + " " + (double)this.table.length);
        double loadRatio = loadCount/(double)this.table.length;
        System.out.println("Actual load factor: " + loadRatio);

        switch (operationType) {
            case 0:
                if (method == HashingMethod.LP) {
                    for(int i=load;i < ten;i++)
                        this.LPInsertion(tab[i], a);

                    CalcAvg(CounterType.LPInsertion);
                }
                else if (method == HashingMethod.DH) {
//                    for (int i = load; i < ten; i++ )
//                        this.DHInsertion(tab[i], a);

//                    CalcAvg(CounterType.DHInsertion);
                }
                break;
            case 1:
                if (method == HashingMethod.LP) {
//                    for (int i = load; i < ten; i++ )
//                        this.LPSearch(tab[i], a);
//
//                    CalcAvg(CounterType.LPSearchMiss);

//                    for (int i = (int)(load-load*0.1); i < load; i++)
//                        this.LPSearch(tab[i], a);
//
//                    CalcAvg(CounterType.LPSearchHit);
                }
                else if (method == HashingMethod.DH) {
//                    for (int i = load; i < ten; i++)
//                        this.DHSearch(tab[i], a);
//
//                    CalcAvg(CounterType.DHSearchMiss);
//
//                    for (int i = (int)(load - load * 0.1); i < load; i++)
//                        this.DHSearch(tab[i], a);
//
//                    CalcAvg(CounterType.DHSearchHit);

                }
                break;
                
            case 2:
                if (method == HashingMethod.LP)
                {
//                    for (int i = (int)(load - load * 0.1); i <load; i++)
//                        this.LPRemove(tab[i], a);
//
//                    CalcAvg(CounterType.LPRemove);
                }
                else if (method == HashingMethod.DH)
                {
//                    for (int i = (int)(load - load * 0.1); i < load; i++)
//                        this.DHRemove(tab[i], a);
//
//                    CalcAvg(CounterType.DHRemove);
                }
                break;
            default:
                System.out.println("Wrong operation type. (only 0-2)");
                return;
        }

    }

    public void CalcAvg(CounterType t) {
        double count = 0;

        switch(t)
        {
            case LPInsertion:
                System.out.println(count);
                for (Object x : LPInsertCounter) {
                    count += (double)x;
                }
                
                
                    
                LPInsertAvg = count / LPInsertCounter.size();
                count = 0;
                
                break;
            // case LPSearchHit:
            //     foreach(int x in LPSearchHitCounter)
            //         count += x;
            //
            //     LPSearchHitAvg = count / LPSearchHitCounter.Count;
            //
            //     count = 0;
            //
            //     break;
            // case LPSearchMiss:
            //     foreach (int x in LPSearchMissCounter)
            //         count += x;
            //
            //     LPSearchMissAvg = count / LPSearchMissCounter.Count;
            //
            //     count = 0;
            //     break;
            // case LPRemove:
            //     foreach (int x in LPRemoveCounter)
            //         count += x;
            //
            //     LPRemoveAvg = count / LPRemoveCounter.Count;
            //
            //     count = 0;
            //     break;
            // case DHInsertion:
            //
            //     foreach (int x in DHInsertCounter)
            //         count += x;
            //
            //     DHInsertAvg = count / DHInsertCounter.Count;
            //
            //     count = 0;
            //     break;
            // case DHSearchHit:
            //     foreach (int x in DHSearchHitCounter)
            //         count += x;
            //
            //     DHSearchHitAvg = count / DHSearchHitCounter.Count;
            //
            //     count = 0;
            //     break;
            // case DHSearchMiss:
            //     foreach (int x in DHSearchMissCounter)
            //         count += x;
            //
            //     DHSearchMissAvg = count / DHSearchMissCounter.Count;
            //
            //     count = 0;
            //     break;
            //
            // case DHRemove:
            //      foreach (int x in DHRemoveCounter)
            //         count += x;
            //
            //     DHRemoveAvg = count / DHRemoveCounter.Count;
            //
            //     count = 0;
            //     break;

        }

    }

    public void ShowAvgs()
    {
        System.out.println("Average hashing function invocations for different operations:\n");

        if (LPInsertAvg > 0) {
            System.out.println("LP Insertion: " + LPInsertAvg);
        }
//        if (LPSearchHitAvg > 0)
//        {
//            System.out.println("LP Search Hit: " + LPSearchHitAvg);
//        }
//        if (LPSearchMissAvg > 0)
//        {
//            System.out.println("LP Search Miss: " + LPSearchMissAvg);
//        }
//        if (LPRemoveAvg > 0)
//        {
//            System.out.println("LP Remove: " + LPRemoveAvg);
//        }
//
//        if (DHInsertAvg > 0)
//        {
//            System.out.println("DH Insertion: " + DHInsertAvg);
//        }
//        if (DHSearchHitAvg > 0)
//        {
//            System.out.println("DH Search Hit: " + DHSearchHitAvg);
//        }
//        if (DHSearchMissAvg > 0)
//        {
//            System.out.println("DH Search Miss: " + DHSearchMissAvg);
//        }
//        if (DHRemoveAvg > 0)
//        {
//            System.out.println("DH Remove: " + DHRemoveAvg);
//        }
    }

    private void ClearTable() {
        Arrays.fill(table, 0);
    }
}
