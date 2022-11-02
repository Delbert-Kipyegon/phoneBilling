import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.ZoneId;
import java.time.ZonedDateTime;
// import java.time.LocalTime;

public class PhoneBilling {

    public static void main(String[] args, double cost){

        // declare the required variables
        String number;
        double  duration;

        // get total talk time 
        duration = 4;

        // get number 
        number = "072961634";

        
        // get current time and hours
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime time = ZonedDateTime.now(zoneId);
        int hours = time.getHour();
        System.out.println(hours);


        // create regex to check number format
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
            // LocalTime Six_AM = LocalTime.parse("06:00:00");
            // LocalTime Six_PM = LocalTime.parse("18:00:00");
        
            
            // check the hours condition
            if (hours >= 06 && hours <= 18){
                 cost = duration * 4;
            }
                else{
                cost = duration * 3;
            }
        } else{
         cost = duration * 5;

        }


    }
    


}