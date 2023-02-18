import java.util.ArrayList;
import java.util.Random;

/*
Задача № 2. Дан произвольный список целых чисел, удалить из него четные числа.
 */
public class Sem_3_Hmw_Task2 {
    public static void main(String[] args) {                          // Формирование списка случайных чисел.
        var my_list = new ArrayList<Integer>();
        get_list(my_list);
        System.out.printf("\nИсходный список случайных чисел: %s", my_list);
        ArrayList<Integer> odd_list = selector(my_list);
        System.out.printf("\nСписок без четных чисел:         %s", odd_list);
    }

    // ФУНКЦИЯ ФОРМИРОВАНИЯ СПИСКА СЛУЧАЙНЫХ ЧИСЕЛ
    private static void get_list(ArrayList<Integer> origin) {
        Random random = new Random();
        int min = 10;                                                // Определяем диапазон чисел в массиве: [min, max)
        int max = 40;
        for (int i = 0; i < 10; i++) {                               // Длиной цикла устанавливаем размер массива.
            origin.add(random.nextInt(max - min + 1) + min);
        }
    }

    // ФУНКЦИЯ УДАЛЕНИЯ ИЗ СПИСКА ЧЕТНЫХ ЧИСЕЛ
    public static ArrayList<Integer> selector(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) % 2 == 0) {                               // Если остаток от %2 == 0, значит число четное
                list.remove(i);                                       // и соответствующий элемент удаляем из массива.
            }
        }
        return list;                                                  // Возвращаем отсортированный массив.
    }
}

