import java.util.Random;
import java.util.Scanner;
public class task1 {
    public static String guess(int n,int num,int bound){
     if(num>bound) {
        return " ENTER THE NO WITH IN THE BOUND";
     }  
    if(n==num){
        
        return "YOU GUESSED THE CORRECT NUMBER";
    }else if(num>n){
        return "THE NUMBER IS TOO HIGH";

    }else{
           return "THE NUMBER IS TOO LOW";
    }
}
    public static void main(String[] args) {
             Random rand = new Random();
             Scanner sc=new Scanner(System.in);
          int score=0;
          int num;
          int bound=100;
          System.out.println("🎲 Guess the number between 1 and " + bound);
        System.out.println("You have 3 attempts.\n");
          for(int i=0;i<3;i++){// Limiting the Number of attempts to 3....
            int n = rand.nextInt(bound)+1; 
            System.out.println("ATTEMPT NO:"+(i+1)+"\nENTER THE NUMBER");
            num=sc.nextInt();
             
            String out=guess(n, num,bound);
            if(out.equals("YOU GUESSED THE CORRECT NUMBER")){
                score++;
            }
            System.out.println(out);
          }System.out.println("THE FINAL SCORE IS:"+score);

}
}
