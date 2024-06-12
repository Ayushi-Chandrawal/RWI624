//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //153=1*1*1+5*5*5+3*3*3=153

            int number = 125,originalnumber, reminder,result=0;
            originalnumber=number;
            while(originalnumber!=0){
                reminder=originalnumber%10;
                result += Math.pow(reminder,3);
                originalnumber= originalnumber/10;

            }
            if(result==number){
                System.out.println(number+ " is an armstorng");
            }else{
                System.out.println(number+ " is not an armstonrg");
            }
    }
}
