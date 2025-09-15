import java.util.Scanner;
public class task2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         System.out.print("Enter number of subjects: ");
        int subject=sc.nextInt();
        int n1=0;
        
        int sum=0;
        for(int i=1;i<=subject;i++){
            System.out.println("enter the subject " +(i)+ " marks");
              n1=sc.nextInt();
                sum=total(n1,sum);
        }
         
          System.out.println("Total Marks = " + sum);
          int a=average(sum,subject);
          System.out.println("Average Marks = " + a);
          String c=cal(a);
           System.out.println("Grade = " + c);
       sc.close();
    }
    public static int total(int n1,int sum){
       
         sum=sum+n1;
        return sum;
    }
    public static int average(int sum,int subject){
        int avg=sum/subject;
        return avg;
    }
    public static String cal(int avg){
        if(avg>=90&&avg<=100){
            return "A GRADE";
        }else if(avg>=80&&avg<90){
               return "B GRADE";

        }else if(avg>=70&&avg<80){
               return "C GRADE";
               
        }else if(avg>=60&&avg<70){
               return "D GRADE";
               
        }else if(avg>=50&&avg<60){
               return "E GRADE";
               
        }else{
            return "F GRADE";
        }
    }
}
