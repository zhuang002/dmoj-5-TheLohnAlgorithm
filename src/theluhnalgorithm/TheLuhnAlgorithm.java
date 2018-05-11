/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theluhnalgorithm;

import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class TheLuhnAlgorithm {

    private static Scanner sc=new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int i=0;i<5;i++) {
            for (int j=0;j<5;j++) {
                String s=sc.next();
                int n=getCheckDigit(s);
                System.out.print(n);
            }
            System.out.println();
        }
    }

    private static int getCheckDigit(String s) {
        int sum=0;
        for (int i=s.length()-1;i>=0;i-=2) {
            sum+=sumDigits((s.charAt(i)-'0')*2);   
        }

        for (int i=s.length()-2;i>=0;i-=2) {
            sum+=s.charAt(i)-'0';
        }
        sum%=10;
        if (sum==0) return 0;
        return 10-sum%10;
    }

    private static int sumDigits(int n) {
        if (n<10) return n;
        int sum=0;
        while (n>0) {
            sum+=n%10;
            n/=10;
        }
        return sumDigits(sum);
    }
}
