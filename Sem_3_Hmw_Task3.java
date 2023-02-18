import java.util.ArrayList;
import java.util.Random;

/*
Задача № 3. Задан целочисленный список ArrayList.
Найти минимальное, максимальное и среднее арифметическое этого списка.
 */
public class Sem_3_Hmw_Task3 {
    public static void main(String[] args) {
        // ВЫЗОВ МЕТОДОВ ФОРМИРОВАНИЯ МАССИВА И РАССЧЕТА ПОКАЗАТЕЛЕЙ
        var my_list = new ArrayList<Integer>();
        get_list(my_list);
        System.out.printf("\nИсходный список случайных чисел: %s", my_list);
        give_numbers(my_list);
    }

    // ФУНКЦИЯ ФОРМИРОВАНИЯ СПИСКА СЛУЧАЙНЫХ ЧИСЕЛ
    private static void get_list(ArrayList<Integer> origin) {
        Random random = new Random();
        int min = 10;                                               // Определяем диапазон чисел в массиве: [min, max)
        int max = 40;
        for (int i = 0; i < 10; i++) {                               // Длиной цикла устанавливаем размер массива.
            origin.add(random.nextInt(max - min + 1) + min);
        }
    }

    // ФУНКЦИЯ ПОИСКА МИНИМАЛЬНОГО, МАКСИМАЛЬНОГО И СРЕДНЕГО АРИФМЕТИЧЕСКОГО ЧИСЕЛ МАССИВА
    private static void give_numbers(ArrayList<Integer> origin_list) {
        int min = origin_list.get(0);
        int max = origin_list.get(0);
        double sum_elements = 0;
        for (int j : origin_list) {                                  // Определим максимальное число списка.
            if (j > max)
                max = j;
            else if (j < min) {
                min = j;                                             // Определим минимальное число списка.
            }
            sum_elements += j;                                       // Проведем рассчет суммы всех элементов.
        }
        double number_elements = origin_list.size();                 // Получим количество элементов списка.
        double middle = sum_elements / number_elements;
        System.out.printf("\nМинимальное число списка:    %d", min);
        System.out.printf("\nМаксимальное число списка:   %d", max);
        System.out.printf("\nСреднее арифметическое:      %f", middle);
    }
}
