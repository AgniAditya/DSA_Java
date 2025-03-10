import java.util.ArrayList;

public class Subsequence {
   public Subsequence() {
   }

   public static void main(String[] var0) {
      String var1 = "abc";
      // Removed redundant ArrayList initialization.
      System.out.println(subseqlist("", var1));
   }

   // Recursive method to print subsequences
   static void subseq(String var0, String var1) {
      if (var1.isEmpty()) {
         System.out.println(var0);
      } else {
         // Include the first character of var1 in the subsequence
         subseq(var0 + var1.charAt(0), var1.substring(1));
         // Exclude the first character of var1 from the subsequence
         subseq(var0, var1.substring(1));
      }
   }

   // Recursive method to collect subsequences into a list
   static void subseq(String var0, String var1, ArrayList<String> var2) {
      if (var1.isEmpty()) {
         var2.add(var0);
      } else {
         subseq(var0 + var1.charAt(0), var1.substring(1), var2);
         subseq(var0, var1.substring(1), var2);
      }
   }

   // Returns all subsequences as a list
   static ArrayList<String> subseqlist(String var0, String var1) {
      ArrayList<String> var2 = new ArrayList<>();  // Corrected the declaration.
      if (var1.isEmpty()) {
         var2.add(var0);
         return var2;
      } else {
         // Include the first character of var1 in the subsequence
         var2.addAll(subseqlist(var0 + var1.charAt(0), var1.substring(1)));
         // Exclude the first character of var1 from the subsequence
         var2.addAll(subseqlist(var0, var1.substring(1)));
         return var2;
      }
   }
}
