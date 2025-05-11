import java.util.*;

import Circullarll.Node;
public class gams {
    public static void main(String[] args) {
    }
    public static int helper(Node root,int sum){
        if(root=null){
            return 0;
        }
        sum=sum*10+root.value;
      if(root.left==null&&root.right==null){
        return sum;
      }
      return   helper(root.left, sum)+helper(root.right, sum); 
    }
}
