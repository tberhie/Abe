

import java.util.Scanner;

public class WindChill {
  
   public static void main(String[] args) {
  
       double temperature;
       double wind_speed;
       double result=0;
       String progrmmer_name="Tsegazeab Berhie"; //you can change to your own Name
       System.out.println("WIND CHILL CALCULATOR");
       System.out.println("Please enter the Temperature in Faranheat(must be >=-45 and <=40): ");
       Scanner sc=new Scanner(System.in);
   temperature =sc.nextDouble();
       System.out.println("Please Enter the wind speed(Must be >=5 and <=60) ");
       wind_speed=sc.nextDouble();
       if(temperature>=-45 && temperature<=40 && wind_speed>=5 && wind_speed<=60){
           double base=wind_speed;
           double exp=0.16;
           result = Math.pow(base, exp);
      
             
           double wind_chill= 35.74+(0.6215*temperature-35.75*result)+(0.4275*temperature*result);
           System.out.println("Wind Chill Temperature: "+wind_chill+" degrees Fahrenheit");
          
          
          
          
       }else{
           System.out.println("Temperature in Faranheat(must be >=-45 and <=40): and wind speed(Must be >=5 and <=60)");
       }
      
       System.out.println("Programmer: "+progrmmer_name);

      
   }
  
}