import java.time.LocalDate;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //1
//        System.out.println("Enter Date in format(XXXX-XX-XX):");
//        Scanner in=new Scanner(System.in);
//        String date=in.next();
//        dateComparison(date);

        //2
        //piNumberOutput();

        //3
        getLettersCount();

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

    //3. Считайте из текстового файла текст на английском языке и
    //выведите статистику по частоте использования букв в тексте
    //(т. е. буква — количество использований), причем первыми
    //должны выводиться буквы используемы чаще всего.
    public static void getLettersCount(){
        Map<String, Integer> dictionary = new HashMap<>();
        LinkedList<String> letters=new LinkedList<String>();
        try (FileReader fr = new FileReader("src/Text.txt")) {
            int data;
            while ((data = fr.read()) != -1) {
                letters.add(String.valueOf((char)data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String item:letters){
            if(!item.contains(" ")){
                if(!dictionary.containsKey(item)){
                    dictionary.put(item,1);
                }
                else{
                    dictionary.put(item,dictionary.get(item)+1);
                }
                System.out.println(item);
            }

        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(dictionary.entrySet());
        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        for (Map.Entry<String,Integer> item:list){
            System.out.println(item.getKey()+" : "+item.getValue());
        }

    }



}
