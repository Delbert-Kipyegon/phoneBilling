// this program takes time and the phone number used in a call the returns the cost used
// the number determines the network which determines the call

// declare required variables 
let  number, duration, cost, time;

// get total time 
duration = 4;

// get number 
number = "0772961634";

// create regex to check number format
let testRgx = /07[012459]/;
testRgx.test(number);

// get current time
time  = new Date();
let hours = time.getHours();

// if call is to same network then uses the time to find cost
// else uses a constant number
if (testRgx.test(number) == true){
            
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

// VAT condition
if (duration > 2){
    // cost = cost * 1.16;
    cost *= 1.16;
}

console.log("The time of call is " + hours);
console.log("The cost is " + cost);
console.log("the number is " + number);
console.log("The total duration is " + duration);




