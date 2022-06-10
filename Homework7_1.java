
import java.util.*;
class Homework7_1{
   public static int fib(int n){
       if(n <= 1)
           return n;
       return fib(n-1) + fib(n-2);
   }
   public static int getPowerOfXtoN(int xBase, int nExp){
       if(nExp == 0)
           return 1;
       return xBase * getPowerOfXtoN(xBase, nExp-1);
   }
   public static int helper(String target, String[] words, int start, int end){
       if(start > end)
           return -1;
       int mid = start + (end - start)/2;
       if(words[mid].equals(target))
           return mid;
       if(words[mid].compareTo(target) < 0)
           return helper(target, words, mid+1, end);
       return helper(target, words, start, mid-1);
   }
   public static int binarySearch(String target, String[] words){
       Arrays.sort(words);
       return helper(target, words, 0, words.length-1);
   }
   public static int organizeParade(int paradeLength){
       if(paradeLength == 2) return 3;
       if(paradeLength == 1) return 2;
       return organizeParade(paradeLength-1) + organizeParade(paradeLength-2);
   }
   public static int numJarsNeeded(int candyCount, int jarCapacity){
       if(candyCount == jarCapacity) return 0;
       if(candyCount < jarCapacity)
           return 2;
       return 2 + numJarsNeeded(candyCount/2, jarCapacity) + (candyCount%2 == 0 ? 0 : 2);
   }
   public static void main(String[] args) {
       System.out.println("Fib(3): "+fib(3));
       System.out.println("getPowerOfXtoN(-2,3): "+getPowerOfXtoN(-2,3));
       System.out.println("organizeParade(4): "+organizeParade(4));
       System.out.println("numJarsNeeded(10,2): "+numJarsNeeded(10,2));
       System.out.println("numJarsNeeded(16,4): "+numJarsNeeded(16,4));
       String[] arr = {"abd", "msd", "vk", "kw", "ss"};
       System.out.println("Binary search: "+binarySearch("vk", arr));
   }
}