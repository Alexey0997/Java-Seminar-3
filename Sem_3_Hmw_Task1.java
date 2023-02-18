import java.util.Arrays;
/*
Задача № 1. Реализовать алгоритм сортировки слиянием.
 */
public class Sem_3_Hmw_Task1 {
    public static void main(String[] args) {
        int n = 10;                                                      // Зададим длину массива.
        int[] my_array = new int[n];
        for (int i = 0; i < n; i++) {                                   // Сформируем массив случайных чисел.
            my_array[i] = ((int)(Math.random() * 11));
        }
        System.out.print("\nИсходный массив случайных чисел:  ");       // Печать исходного массива.
        System.out.println(Arrays.toString(my_array));
        sort_array(my_array, n);
        System.out.print("Массив, отсортированный слиянием: ");         // Печать результата.
        System.out.println(Arrays.toString(my_array));
    }

    // ФУНКЦИЯ СОРТИРОВКИ МАССИВА
    // Аргументы функции: исходный массив и его длина.
    public static void sort_array(int[] my_array, int n) {
        if (n < 2) {                                                   // Если длина массива менее 2 элементов,
            return;                                                    // то его сортировка не требуется.
        }
        int middle = n / 2;                                            // Определим точку раздела массива на две части.
        int[] left = new int[middle];                                  // Создадим подмассив для левой части my_array.
        int[] right = new int[n - middle];                             // Создадим подмассив для правой части my_array.
        System.arraycopy(my_array, 0, left, 0, middle);
        if (n - middle >= 0) {
            System.arraycopy(my_array, middle, right, 0, n - middle);
        }
        sort_array(left, middle);                                      // Продолжим деление подмассивов с помощью рекурсии
        sort_array(right, n - middle);                              // до отдельных элементов.
        merge(my_array, left, right, middle, n - middle);
    }

    // ФУНКЦИЯ СЛИЯНИЯ МАССИВОВ
    // Аргументы функции: исходный массив, левая и правая части, длины частей.
    public static void merge(int[] my_array, int[] left_arr, int[] right_arr, int left, int right) {
        int i = 0, j = 0, k = 0;                                       // Зададем начальные значения индексов массивов.
        while (i < left && j < right) {                                // Проводим сравнение элементов правого и левого
            if (left_arr[i] <= right_arr[j]) {                         // подмассивов и помещаем нименьший элемент
                my_array[k++] = left_arr[i++];                         // во входной массив.
            }
            else {
                my_array[k++] = right_arr[j++];
            }
        }
        while (i < left) {
            my_array[k++] = left_arr[i++];
        }
        while (j < right) {
            my_array[k++] = right_arr[j++];
        }
    }
}