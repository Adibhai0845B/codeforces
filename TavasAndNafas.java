import java.util.Scanner;

public class TavasAndNafas {
    
    private static final String[] units = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", 
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int a = Integer.parseInt(s);
        if(a<20){
           System.out.print(units[a]);
        }
        else{
            int b = a/10;
            int c = a%10;
            if(c==0){
                 System.out.println(tens[b]);
            }
            else{
  System.out.print(tens[b]+"-"+units[c]);
        }
    }
    }
}
