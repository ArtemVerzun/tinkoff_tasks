import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во этажей");
        int n = in.nextInt();

        int[] lifts = new int[n];
        int[] lifts2 = new int[n];
        int min1 = 1000;
        int min2 = 1000;

        //ввод лифтов с какого на какой этаж едут
        System.out.println("Введите этажи в две колонки");
        System.out.println("-------------------------");
        for (int i = 0; i < n; i++) {
            lifts[i] = in.nextInt();
            lifts2[i] = in.nextInt();
        }

        int max_count_lifts = 0; //итоговое миксимальное кол-во лифтов
        int new_floor = 0; //новый этаж

        //находим минимум среди первой колонки этажей
        for (int i = 0; i < lifts.length; i++) {
            if (lifts[i] < min1) {
                min1 = lifts[i];
            }
        }
        //находим минимум среди второй колонки этажей
        for (int i = 0; i < lifts2.length; i++) {
            if (lifts2[i] < min2) {
                min2 = lifts2[i];
            }
        }

        new_floor = min2; //новый этаж
        max_count_lifts++;
        n--; //уменьшаем кол-во лифтов

        //проходим по всем оставшимся лифтам
        for (int j = 0; j < n-1; j++){
            //в первой колонке этажей
            for (int i = 0; i < lifts.length; i++) {
                //находим на котором мы сейчас находимся
                if (lifts[i] == new_floor) {
                    //во второй колонке этажей
                    for (int ii = 0; ii < lifts2.length; ii++) {
                        //если индексы этажей совпали
                        if (ii == i) {
                            min2 = lifts2[ii]; //новый минимум во 2й колонке
                        }
                    }
                }
            }
            new_floor = min2; //новый этаж на котором мы находимся
            max_count_lifts++;
        }
        //итоговое максимальное кол-во лифтов
        System.out.println("-------------------------");
        System.out.print("Максимальное кол-во лифтов: " + max_count_lifts);
    }

}