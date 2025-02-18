import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1
//        System.out.println("Enter Date in format(XXXX-XX-XX):");
//        Scanner in=new Scanner(System.in);
//        String date=in.next();
//        dateComparison(date);

        //2
        piNumberOutput();

    }




//    1. Ввести с консоли дату. Сравнить ее с текущей датой в системе. Вывести
//    отличающиеся части (год, месяц) на экран
    public static void dateComparison(String dateOne){
        LocalDate todayDate=LocalDate.now();
        LocalDate dateToCompair=LocalDate.parse(dateOne);
        if(dateToCompair==todayDate){
            System.out.println(todayDate+"="+dateToCompair);
        }
        else{
            if(todayDate.getYear()!=dateToCompair.getYear()){
                System.out.println(todayDate.getYear()+" != "+dateToCompair.getYear());
            }
            if(todayDate.getMonthValue()!=dateToCompair.getMonthValue()){
                System.out.println(todayDate.getMonthValue()+" != "+dateToCompair.getMonthValue());
            }
            if(todayDate.getDayOfMonth()!=dateToCompair.getDayOfMonth()){
                System.out.println(todayDate.getDayOfMonth()+" != "+dateToCompair.getDayOfMonth());
            }
        }
    }

//    2. Выведите на экран 10 строк со значением числа Пи. Причем в первой
//    строке должно быть 2 знака после запятой, во второй 3, в третьей 4 и т.д.

    public  static void  piNumberOutput(){
        double pi=Math.PI;
        int num=3;
        String formattedDouble = String.format("%.2f", pi);
        for (int i=0;i<10;i++){
            System.out.println(formattedDouble);
            formattedDouble = String.format("%."+num+"f", pi);
            num++;
        }
    }

}
