class BetterLoop
{
   /*public static void main(String[] args) {
      int[] values = {1, 2, 8};
      int v = 3;
      boolean isFalse = contains(values, v);
      System.out.println(isFalse);
   }
   */

   public static boolean contains(int [] values, int v)
   {
      /* TO DO: if value v is in the array, return true.
         If not, return false.  Use a "foreach" loop.
      */

      for (int val : values) {
         if (val == v) {
            return true;
         }
      }

      return false;  // A bit optimistic, but a real boolean value.
   }
}
