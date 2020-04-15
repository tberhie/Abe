public class HolidayBonus {

   public HolidayBonus() {

   }

   public static double[] calculateHolidayBonus (double[][] data,double high,double low,double other)

   {

       double[] bonus = new double [data.length];

       double cbonus =0;

       for (int i=0;i<data.length;i++)

           for(int j=0;j<data.length;j++)

           {

           if(data[i][j]==TwoDimRaggedArrayUtility.getHighestInColumn(data, j))

               cbonus +=high;

           else if (data[i][j]==TwoDimRaggedArrayUtility.getLowestInColumn(data, j)&&data[i][j]>0)

           cbonus +=low;

           else if (data[i][j]!=TwoDimRaggedArrayUtility.getHighestInColumn(data, j)&& data[i][j]!=TwoDimRaggedArrayUtility.getLowestInColumn(data, j)&& data[i][j]>0)

               cbonus +=other;

           else cbonus+=0;

       bonus[i]+=cbonus;

   }

   return bonus;
     
   }

   public static double calculateTotalHolidayBonus(double[][] data,double high,double low,double other)

       {

           double bonus [] =HolidayBonus.calculateHolidayBonus(data, high, low, other);

           double total =0;

           for (int i=0;i<bonus.length;i++)

           total +=bonus[i];

   return total;

  

       }

}