mport java.io.*;
import java.util.*;
import java.lang.*;
class TwoDimRaggedArrayUtility
{
   //definition of the method readFile
   //pass in a file and return a two dimensional ragged array of doubles
   public static double[][] readFile(File file)
   {
       double[][] raggedArr=new double[6][];
       String line;
       int i=0;
       try
       {
           //open the file
           BufferedReader br=new BufferedReader(new FileReader(file));      
           //read the file
           while((line=br.readLine())!=null)
           {
               String[] temp=line.split(" ");
               int size=temp.length;
               raggedArr[i]=new double[size];
               //covert into doubles
               for(int j=0;j<size;j++)
               {
                   raggedArr[i][j]= Double.parseDouble(temp[j]);
               }
               i++;
           }
           br.close();
       }
       catch(Exception ep)
       {
           ep.printStackTrace();
       }
       return raggedArr;
   }
   //definition of the method writeToFile
   //pass in a two dimensional ragged array of doubles and a file,
   //and writes the ragged array into the file. Each row is on a
   //separate line and each double is separated by a space.
   public static void writeToFile(double[][] raggedArr,File file)
   {

       try
       {
           //open the file
           BufferedWriter br=new BufferedWriter(new FileWriter(file));
           //read the array and print into file with spaces
           for(int i=0;i<raggedArr.length;i++)
           {
               for(int j=0;j<raggedArr[i].length;j++)
               {
                   br.write(raggedArr[i][j]+" ");
               }
               br.newLine();
           }
           br.close();
       }
       catch(Exception ep)
       {
           ep.printStackTrace();
       }

   }
   //definition of the method getTotal
   //pass in a two dimensional ragged array of doubles
   //and returns the total of the elements in the array.
   public static double getTotal(double[][] raggedArr)
   {
       double total=0;
       //find the sum of the values of the 2D array
       for(int i=0;i<raggedArr.length;i++)
       {
           for(int j=0;j<raggedArr[i].length;j++)
           {
               total += raggedArr[i][j];
           }
       }
       return total;
   }
   //definition of the method getAverage
   //pass in a two dimensional ragged array of doubles
   //and returns the average of the elements in the array
   public static double getAverage(double[][] raggedArr)
   {
       double total=0;
       int numOfElements=0;
       //find the sum of the values of the 2D array
       for(int i=0;i<raggedArr.length;i++)
       {
           for(int j=0;j<raggedArr[i].length;j++)
           {
               total += raggedArr[i][j];
               numOfElements += 1;
           }
       }
       //find and return the average
       return new Double(total/numOfElements);
   }
   //definition of the method getRowTotal
   //pass in a two dimensional ragged array of doubles and a row index
   //and returns the total of that row. Row index 0 is the first row in the array.
   public static double getRowTotal(double[][] raggedArr,int rowIndex)
   {
       double total=0;
       for(int j=0;j<raggedArr[rowIndex].length;j++)
       {
           total += raggedArr[rowIndex][j];

       }
       return total;
   }
   //definition of the method getColumnTotal
   //pass in a two dimensional ragged array of doubles
   //and a column index and returns the total of that column.
   public static double getColumnTotal(double[][] raggedArr,int colIndex)
   {
       double total=0;
       for(int i=0;i<raggedArr.length;i++)
       {
           if(colIndex<=raggedArr[i].length-1)
               total += raggedArr[i][colIndex];
       }
       return total;
   }
   //definition of the method getHighestInRow
   // pass in a two dimensional ragged array of doubles and a
   //row index and returns the largest element in that row.
   public static double getHighestInRow(double[][] raggedArr,int rowIndex)
   {
       double highest=raggedArr[rowIndex][0];
       for(int j=0;j<raggedArr[rowIndex].length;j++)
       {
           if(raggedArr[rowIndex][j]>highest)
               highest= raggedArr[rowIndex][j];

       }
       return highest;
   }
   //definition of the method getLowestInRow
   //takes a two dimensional ragged array of doubles and a
   //row index and returns the smallest element in that row.
   public static double getLowestInRow(double[][] raggedArr,int rowIndex)
   {
       double lowest=raggedArr[rowIndex][0];
       for(int j=0;j<raggedArr[rowIndex].length;j++)
       {
           if(raggedArr[rowIndex][j]<lowest)
               lowest= raggedArr[rowIndex][j];

       }
       return lowest;
   }
   //definition of the method getHighestInColumn
   //pass in a two dimensional ragged array of doubles
   //and a column index and returns the largest element in that column
   public static double getHighestInColumn(double[][] raggedArr,int colIndex)
   {
       double highest=raggedArr[0][colIndex];
       for(int i=0;i<raggedArr.length;i++)
       {
           if(colIndex<=raggedArr[i].length-1)
           {               
               if(raggedArr[i][colIndex]>highest)
                   highest= raggedArr[i][colIndex];
           }

       }
       return highest;     
   }
   //definition of the method getLowestInColumn
   //pass in a two dimensional ragged array of doubles and a column
   //index and returns the smallest element in that column
   public static double getLowestInColumn(double[][] raggedArr,int colIndex)
   {
       double lowest=raggedArr[0][colIndex];
       for(int i=0;i<raggedArr.length;i++)
       {
           if(colIndex<=raggedArr[i].length-1)
               if(raggedArr[i][colIndex]<lowest)
                   lowest= raggedArr[i][colIndex];

       }
       return lowest;  
   }
   //definition of the method getHighestInArray
   //pass in a two dimensional ragged array of doubles
   //and returns the largest element in the array.
   public static double getHighestInArray(double[][] raggedArr)
   {
       double highest=raggedArr[0][0];
       for(int i=0;i<raggedArr.length;i++)
       {
           for(int j=0;j<raggedArr[i].length;j++)
           {
               if(raggedArr[i][j]>highest)
                   highest= raggedArr[i][j];

           }
       }
       return highest;
   }
   //definition of the method getLowestInArray
   // pass in a two dimensional ragged array of doubles
   //and returns the smallest element in the array.
   public static double getLowestInArray(double[][] raggedArr)
   {
       double lowest=raggedArr[0][0];
       for(int i=0;i<raggedArr.length;i++)
       {
           for(int j=0;j<raggedArr[i].length;j++)
           {
               if(raggedArr[i][j]<lowest)
                   lowest= raggedArr[i][j];

           }
       }
       return lowest;
   }
}