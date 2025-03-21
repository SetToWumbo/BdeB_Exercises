import java.util.Random;

public class Brent_test {


    public static void main(String[] args) {
//        Generate a 5x5 array filled with random integers between 1 and 50.
//        Print the array in a matrix format.
//        Compute the sum of each row and each column.
//        print those sums
        int[][] hi = new int[5][5];
        int[] bye = new int[hi.length];
        // int[] bye = printSumEachrow(hi);

        arrayN(hi);
        printArray(hi);
        System.out.println();
        printSumEachrow(hi, bye);
        System.out.println();
        Highestsumrow(bye);
        System.out.println();
        highestcollumn(hi, bye);
        System.out.println();
        highestC(bye);
    }

    /*
    notes for arrayN method:
    Because arrays are passed by reference, this method can be return type void since it will directly access the location
    where the array is stored in memory.
     */
    public static int[][] arrayN(int[][] array) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            System.out.println(); // why are you printing a new line in a method that isn't printing anything?
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = r.nextInt(1, 51);
            }
        }
        return array;// no need to return when the parameter for you method is an array.
    }
        /*
        Suggested simplified verison of above method:

        public static void fill(int[][] array){
            Random random = new random;
            for(int i = 0; i < array.length; i++){
                for(int j = 0; j < array[i].length; j++){
                    array[i][j] = random.nextInt(0, 51);
                }
            }
        }
         */


    /*
   nothing to add, looks good here!
    */
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
        }
    }

    public static void print(int[] array) {
        for (int j : array) System.out.print(j + " ");
    }
}

/*
Fundamentally, I feel like the behaviour for this method should be separated into 2 methods. Especially since its name
refers to 2 different actions.
one that sums a row and returns an array, and another that prints an array.

For example, the method sumRows would take in an nD array, and return a 1D array containing the sums of all the rows
contained in the nD array.

You would then call a print method on the output array. This would also help clarify the code above when you call
the method(s).
 */
public static int[] printSumEachrow(int[][] array, int[] darray) {
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[0].length; j++) {
            sum += array[i][j];
            darray[i] = sum;
        }
        System.out.println(sum);
        sum = 0;
    }
    return darray;
}

    /*
        int[] totals = sum(hi, ROW);

        Suggested revision of this method:
            public static int[] sum(int[][] array, enum Direction){
                int[] totals = new int[array.length];
                for(int i = 0; i < array.length; i++){
                 for(int j = 0; j < array[i].length; j++){
                     switch(Direction){
                     case ROW:
                        totals[i]+=array[i][j];
                     case COL:
                        totals[i]+=array[j][i];
                  }
                }
                return totals;
            }
     */

public static void Highestsumrow(int[] darray) {
    int highest = 0;
    for (int i = 0; i < darray.length; i++) {
        if (highest < darray[i]) {
            highest = darray[i];
        }
    }
    System.out.println(highest);
}

public static int[] highestcollumn(int[][] array, int[] o) {
    int sum = 0;
    for (int j = 0; j < array[0].length; j++) {
        for (int i = 0; i < array.length; i++) {
            sum += array[i][j];
            o[j] = sum;
        }
        System.out.println(sum);
        sum = 0;
    }
    return o;
}

public static void highestC(int[] l) {
    int highest = l[0];
    for (int i = 0; i < l.length; i++) {
        if (highest < l[i]) {
            highest = l[i];
        }
    }
    System.out.println(highest);
}
}
        }

