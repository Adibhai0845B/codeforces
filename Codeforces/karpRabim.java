import java.util.*;
public class karpRabim {
       private final int PRIME = 101;
    private long calculate(String s){
      long hash = 0;
      for(int i =0;i<s.length();i++){
        hash+=s.charAt(i)*Math.pow(PRIME,i);
      }
      return hash;
    }
    private long update(long prevhash,char old,char new,int parrent){  
    }
    }
