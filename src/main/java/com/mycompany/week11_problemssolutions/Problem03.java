/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week11_problemssolutions;
import java.util.Scanner;


/**
 *
 * Solve problem 03:
 * We can easily verify that none of the entries in the first seven rows of Pascal's triangle are divisible by 7:

 	 	 	 	 	 	 1
 	 	 	 	 	 1	 	 1
 	 	 	 	 1	 	 2	 	 1
 	 	 	 1	 	 3	 	 3	 	 1
 	 	 1	 	 4	 	 6	 	 4	 	 1
 	 1	 	 5	 	10	 	10	 	 5	 	 1
1	 	 6	 	15	 	20	 	15	 	 6	 	 1
However, if we check the first one hundred rows, we will find that only 2361 of the 5050 entries are not divisible by 7.

Find the number of entries which are not divisible by 7 in the first one billion (109) rows of Pascal's triangle.
* 
 */
public class Problem03 
{
    
    public static long pascalTriangle(long i, long j)
    {
        if (j == 0)
        {
            return 1;
        } // End if.
        else if (j == i)
        {
            return 1;
        } // End else if.
        else
        {
            return pascalTriangle(i - 1, j - 1) + pascalTriangle(i - 1, j);
        } //  End else.
    }
    
    public static long findNotDivisibleBy7(long n)
    {
        long count = 0;
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                if (notDivisibleBy7(pascalTriangle(i, j)))
                {
                    count++;
                } // End if.
            } // End for.
        } // End for.
        
        return count;
    }
    
    public static boolean notDivisibleBy7(long n)
    {
        return n % 7 != 0; // End if.
    }
    
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter the number of rows you would like to check here: ");
        
        long rows = scan.nextLong();
        
        long numNotDivisibleBy7 = findNotDivisibleBy7(rows);
        
        System.out.println("Rows processed: " + rows + "\n" +
                           "Numbers not divisible by 7: " + numNotDivisibleBy7);
    }
}