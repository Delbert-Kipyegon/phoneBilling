import java.util.regex.Matcher; // show the pattern 
import java.util.regex.Pattern; // what is to be matched against the pattern
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class PhoneBilling {

    public static void main(String[] args){

        // declare the required variables
        String number;
        double  duration;
        double totalCost;


        // get total talk time 
        duration = 4;

        // get number 
        number = "072961634"; // safaricom

        
        // get current time and hours
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime time = ZonedDateTime.now(zoneId);
        int hours = time.getHour();
        System.out.println( hours + ":00 Hrs ");


        // create regex to check number format of network
        String regex = "07[012459]";
        Pattern  testRgx = Pattern.compile( regex) ;   
        Matcher matcher = testRgx.matcher(number); 
        boolean matchFound = matcher.find();
        if(matchFound) {
        System.out.println("Calling same network");
        } else {
         System.out.println("Calling other Network");
        }
        

        
        // if call is to same network then uses the time to find cost
        // else uses a constant number
        if (matchFound){
            
            // check the hours condition
            System.out.println("Should check for hours");
            
            if (hours >= 06 && hours <= 18){
                 totalCost = duration * 4;
                System.out.println("Day");

                // including VAT
                if(duration > 2){
                    totalCost *= 1.16;
                    System.out.println("Your call has exceeded 2 minutes");
                    System.out.println("The Total Cost is " + totalCost);
                }else{
                    System.out.println("The Total Cost is " + totalCost);
                }
                System.out.println(totalCost);
            }
                else{
                totalCost = duration * 3;
                System.out.println("Night");

                    // including VAT
                    if(duration > 2){
                        totalCost *= 1.16;
                        System.out.println("Your call has exceeded 2 minutes");
                        System.out.println("The Total Cost is " + totalCost);
                    }else{
                        System.out.println("The Total Cost is " + totalCost);
                    }
            }
        } else{
        System.out.println("Should skip hrs check");
        totalCost = duration * 5;
         // including VAT
         if(duration > 2){
            totalCost *= 1.16;
            System.out.println("Your call has exceeded 2 minutes");
            System.out.println("The Total Cost is " + totalCost);
        }else{
            System.out.println(totalCost);
        }
        

        }

       
    }
    


}