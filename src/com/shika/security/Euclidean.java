package com.shika.security;

public class Euclidean {

    private int Q;
    private int A1 = 1;
    private int A2 = 0;
    private int A3 ;
    private int B1 = 0;
    private int B2 = 1;
    private int B3;
    
    private int A1_i;
    private int A2_i;
    private int A3_i;
    private int B1_i;
    private int B2_i;
    private int B3_i;
    
    public int GetMultiplicativeInverse(int number , int baseN)
    {
        int MultiplicativeInverse = 0;
            A3 = baseN;
            B3 = number;
        while (B3>1)
        {
          Q = A3/B3; 
          A1_i = B1;
          A2_i = B2;
          A3_i = B3;
          B1_i = A1-(Q*B1);
          B2_i =A2-(Q*B2) ;
          B3_i = A3%B3;
          
          if(B3_i == 1 || B3_i== 0)
          {
              break;
          }
          
          A1= A1_i;
          A2=A2_i;
          A3=A3_i;
          B1=B1_i;
          B2=B2_i;
          B3=B3_i;            
        }
        
        if(B3_i == 1)
        {
            if(B2_i < 0)
           MultiplicativeInverse = B2_i + baseN ;
            else 
           MultiplicativeInverse = B2_i;
           
        }
        else
        {
            MultiplicativeInverse = -1;
        }
        return MultiplicativeInverse;
    }
    
}
