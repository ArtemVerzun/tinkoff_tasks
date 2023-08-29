import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите число доменов: ");
        int dom = in.nextInt();
        int selectCount = 8;
        String[] selectedArr = new String[dom];
        String[] srcArr = {"S", "T", "A", "R"};
        Random rnd = new Random();

        //Создание доменов
        for (int k = 0; k < dom; k++) {
            selectedArr[k] ="";
            int bd = rnd.nextInt(selectCount)+2;
            for (int i = 0; i < bd; i++) {
                selectedArr[k] += srcArr[rnd.nextInt(srcArr.length)];
            }
            System.out.println(k+1 + ". " + selectedArr[k]);
        }

        System.out.print("\nВведите число покупателей: ");
        int cust = in.nextInt();
        String[] First = new String[cust];
        String[] Last = new String[cust];
        System.out.println("Введите первые и последние символы. ");


        //Требования от покупателя
        for (int k = 0; k < cust; k++) {
            System.out.print((k+1)+" покупатель. ");
            First[k] = in.next();
            Last[k] = in.next();
        }
        System.out.println("_______________________");

        //проверка на кол-во подходящих доменов
        for(int i = 0; i < cust; i++)
        {
            int count = 0;
            for(int k = 0; k < dom; k++)
            {
                boolean start = selectedArr[k].startsWith(First[i]);
                boolean end = selectedArr[k].endsWith(Last[i]);
                if((start)&&(end)){
                    count++;
                    System.out.println("индекс подходящего домена: " + (k+1));
                }

            }

            System.out.print(count + " домен(а) подходит для " + (i+1)+"го " + "покупателя" +  "\n\n");
        }
    }
}
