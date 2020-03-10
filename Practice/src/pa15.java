/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pratik
 */
import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
public class pa15 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Sim1 [] s1 = new Sim1[4];
        for(int i=0; i<s1.length;i++)
        {
            int simId = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            double balance = sc.nextDouble();
            double ratePerSecond = sc.nextDouble();
            sc.nextLine();
            String circle = sc.nextLine();
            s1[i] = new Sim1(simId,name,balance,ratePerSecond,circle);
        }
        String c1 = sc.nextLine();
        double rps = sc.nextDouble();
        sc.close();
        Sim1 [] result = find(s1,c1,rps);
        for(Sim1 s : result)
        {
            System.out.println(s.getSimId());
        }
    }
    public static Sim1[] find(Sim1 [] s, String circle1, double ratePerSec)
    {
        int count=0;
        for(Sim1 s1 : s)
        {
            if(s1.getCircle().equals(circle1) && s1.getRatePerSecond() < ratePerSec)
            {
                count++;
            }
        }
        
        Sim1 [] temp = new Sim1[count];
        int j=0;
        for(Sim1 s1 : s)
        {
            temp[j++] = s1;
        }
        Arrays.sort(temp, new sortByBalance());
        return temp;
    }
}
class Sim1
{
    private final int simId;
    private final String name;
    private final double balance;
    private final double ratePerSecond;
    private final String circle;

    public Sim1(int simId, String name, double balance, double ratePerSecond, String circle) 
    {
        this.simId = simId;
        this.name = name;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }

    public int getSimId() 
    {
        return simId;
    }

    public String getName() 
    {
        return name;
    }

    public double getBalance() 
    {
        return balance;
    }

    public double getRatePerSecond() 
    {
        return ratePerSecond;
    }

    public String getCircle() 
    {
        return circle;
    }
    
}
class sortByBalance implements Comparator<Sim1>
{
    public int compare(Sim1 a, Sim1 b)
    {
        return (int) b.getBalance() - (int) a.getBalance();
    }
}
//1
//jio
//430
//1.32
//mumbai
//2
//idea
//320
//2.26
//mumbai
//3
//airtel
//500
//2.54
//mumbai
//4
//vodafone
//640
//3.21
//mumbai
//mumbai
//3.4