package sorts;
import java.util.Random;

/**
 * @author Sebastian Kleinerman
 * @class Java 111C
 * @title Sorts.java
 */

public class Sorts
{
   static int selectComparisons, shellComparisons;
	
   public static void main(String[] args) 
   {
	   //Selection Sort- 100 elements
	   Integer[] x = generateRandomArrayWithLength(100);
	   System.out.println("Selection Sort of Array with length " + x.length);
	   System.out.println("1st Value: " + x[0]);
	   
	   System.out.println("Number of Comparisons: " + comparisonsInSelectionSort(x, x.length));
	   System.out.println("New 1st Value: " + x[0]);
	   System.out.println("18th value: " + x[18]);
	   System.out.println("65th value: " + x[65]);
	   System.out.println();
	   
	   //Shell Sort- 100 elements
	   Integer[] y = generateRandomArrayWithLength(100);
	   System.out.println("Shell Sort of Array with length " + y.length);
	   System.out.println("1st Value: " + y[0]);
	   
	   System.out.println("Number of Comparisons: " + comparisonsInShellSort(y, 0, y.length - 1));
	   System.out.println("New 1st Value: " + y[0]);
	   System.out.println("18th Value: " + y[18]);
	   System.out.println("65th Value: " + y[65]);
	   System.out.println();
	   
	   //Selection Sort- 500 elements
	   Integer[] a = generateRandomArrayWithLength(500);
	   System.out.println("Comparison count of Arrays with length " + a.length);
	   System.out.println("Number of Comparisons for Selection: " + comparisonsInSelectionSort(a, a.length));
	   Integer[] aa = generateRandomArrayWithLength(500);
	   System.out.println("Number of Comparisons for Selection: " + comparisonsInSelectionSort(aa, aa.length));
	   
	   //Shell Sort- 500 elements
	   Integer[] b = generateRandomArrayWithLength(500);
	   System.out.println("Number of Comparisons for Shell: " + comparisonsInShellSort(b, 0, b.length - 1));
	   Integer[] bb = generateRandomArrayWithLength(500);
	   System.out.println("Number of Comparisons for Shell: " + comparisonsInShellSort(bb, 0, bb.length - 1) + "\n");
	   
	   //Selection Sort- 5000 elements
	   Integer[] a1 = generateRandomArrayWithLength(5000);
	   System.out.println("Comparison count of Arrays with length " + a1.length);
	   System.out.println("Number of Comparisons for Selection: " + comparisonsInSelectionSort(a1, a1.length));
	   Integer[] a2 = generateRandomArrayWithLength(5000);
	   System.out.println("Number of Comparisons for Selection: " + comparisonsInSelectionSort(a2, a2.length));
	   
	   //Shell Sort- 5000 elements
	   Integer[] b1 = generateRandomArrayWithLength(5000);
	   System.out.println("Number of Comparisons for Shell: " + comparisonsInShellSort(b1, 0, b1.length - 1));
	   Integer[] b2 = generateRandomArrayWithLength(5000);
	   System.out.println("Number of Comparisons for Shell: " + comparisonsInShellSort(b2, 0, b2.length - 1) + "\n");
	   
	   //Selection Sort- 500000 elements
	   Integer[] a3 = generateRandomArrayWithLength(500000);
	   System.out.println("Comparison count of Arrays with length " + a3.length);
	   System.out.println("Number of Comparisons for Selection: " + comparisonsInSelectionSort(a3, a3.length));
	   Integer[] a4 = generateRandomArrayWithLength(500000);
	   System.out.println("Number of Comparisons for Selection: " + comparisonsInSelectionSort(a4, a4.length));
	   
	   //Shell Sort- 500000 elements
	   Integer[] b3 = generateRandomArrayWithLength(500000);
	   System.out.println("Number of Comparisons for Shell: " + comparisonsInShellSort(b3, 0, b3.length - 1));
	   Integer[] b4 = generateRandomArrayWithLength(500000);
	   System.out.println("Number of Comparisons for Shell: " + comparisonsInShellSort(b4, 0, b4.length - 1) + "\n");
	   
	   //Selection Sort- 1000000 elements
	   Integer[] a5 = generateRandomArrayWithLength(1000000);
	   System.out.println("Comparison count of Arrays with length " + a5.length);
	   System.out.println("Number of Comparisons for Selection: " + comparisonsInSelectionSort(a5, a5.length));
	   Integer[] a6 = generateRandomArrayWithLength(1000000);
	   System.out.println("Number of Comparisons for Selection: " + comparisonsInSelectionSort(a6, a6.length));
	   
	   //Shell Sort- 1000000 elements
	   Integer[] b5 = generateRandomArrayWithLength(1000000);
	   System.out.println("Number of Comparisons for Shell: " + comparisonsInShellSort(b5, 0, b5.length - 1));
	   Integer[] b6 = generateRandomArrayWithLength(1000000);
	   System.out.println("Number of Comparisons for Shell: " + comparisonsInShellSort(b6, 0, b6.length - 1));
   }
   
   /**
    * Method to generate a random array with a set length
    * @param int length
    * @return Integer[]
    */
   public static Integer[] generateRandomArrayWithLength(int length)
   {
	   Random gen = new Random();
	   Integer[] array = new Integer[length];
	   
	   for (int i = 0; i < array.length; i++)
		   array[i] = gen.nextInt();
	   
	   return array;
   }
	
   /**
    * Selection sort to count number of comparisons made during a sort
    * @param T[] a
    * @param int n
    * @return static int selectComparisons
    */
   public static <T extends Comparable<? super T>> int comparisonsInSelectionSort(T[] a, int n)
   {
	  selectComparisons = 0;
	  
      for (int index = 0; index < n - 1; index++)
      {
          int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
          swap(a, index, indexOfNextSmallest);
      }
      
      return selectComparisons;
   }
   
   /**
    * Shell sort to count number of comparisons made during a sort 
    * @param T[] a
    * @param int first
    * @param int last
    * @return static int shellComparisons
    */
   public static < T extends Comparable < ? super T >> int comparisonsInShellSort(T[] a, int first, int last)   
   {
	   int n = last - first + 1;
	   int space = n / 2;
	   shellComparisons = 0;
	   
	   while (space > 0)
	   {
		   for (int begin = first; begin < first + space; begin++)
			   incrementalInsertionSort(a, begin, last, space);
		   space = space / 2;
	   }
	   
	   return shellComparisons;
   }

   /**
    * Method to get index of smallest element
    * @param T[] a
    * @param int first
    * @param int last
    * @return int indexOfMin
    */
   private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last)
   {
      T min = a[first];
      int indexOfMin = first;
      
      for (int index = first + 1; index <= last; index++)
      {
         if (a[index].compareTo(min) < 0)
         {
            min = a[index];
            indexOfMin = index;
            selectComparisons++;
         }
      }   
      
      return indexOfMin;
   }

   /**
    * Method to swap two objects in an array
    * @param Object[] a
    * @param int i
    * @param int j
    */
   private static void swap(Object[] a, int i, int j)
   {
      Object temp = a[i];
      a[i] = a[j];
      a[j] = temp; 
   }
   
   /**
    * Method to add 1 space any time the index spacing is even
    * @param T[] a
    * @param int first
    * @param int last
    * @param int space
    */
   private static <T extends Comparable<? super T>> void incrementalInsertionSort(T[] a, int first, int last, int space)
   {
	   int unsorted, index;
	   
	   for (unsorted = first + space; unsorted <= last; unsorted = unsorted + space)
	   {
		   T nextToInsert = a[unsorted];
		   index = unsorted - space;
		   
		   //shellComparisons++;
		   while ((index >= first) && (nextToInsert.compareTo(a[index]) < 0))
		   {
			   a[index + space] = a[index];
			   index = index - space;
			   shellComparisons++;
		   }
		   a[index + space] = nextToInsert;
	   }
   }
   
}
