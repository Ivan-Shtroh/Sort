import java.util.Arrays;
import java.util.Scanner;

public class Sort {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str2 = sc.nextLine();
        String[] a = str2.split(" ");
        int[] arr1 = new int[n];
        int count = 0;
        for (String i : a) {
            arr1[count++] = Integer.parseInt(i);
        }

        int chetCount = 0;
        int nechCount = 0;

        for (int value : arr1) { //посчитаем четные и нечетные числа
            if (value % 2 == 0) {
                chetCount++;
            } else {
                nechCount++;
            }
        }
        sc.close();
        // k - количество переставленных элементов
        int k = 0;

        if (Math.abs(chetCount - nechCount) > 1) { // если количество четных и нечетных отличается больше, чем на 1 - переставить элементы последовательности с требуемым условием невозможно
            System.out.println(-1);
        } else if (chetCount == 0 || nechCount == 0) { //если нечетных или четных чисел нет
            System.out.println(0); //то перестановки не нужны
            System.out.print(arr1[0]); // и этот элемент единственный (т.к. (chetCount - nechCount)<=1)
        } else { // если перестановки возможны

            //определим первый элемент
            if (chetCount > nechCount) { //если четных больше, начинаем с четного
                if ((arr1[0] % 2) != 0) { //если первый элемент нечетный
                    int temp = arr1[0];
                    for (int i = 1; i < n; i++) {
                        if ((arr1[i] % 2) == 0) { //ставим на первое место (0-инд.) четный элемент
                            arr1[0] = arr1[i];
                            arr1[i] = temp;
                            k++;
                        }
                    }
                }
            } else if (chetCount < nechCount) { //если нечетных больше, начинаем с нечетного
                if ((arr1[0] % 2) == 0) { //если первый элемент нечетный
                    int temp = arr1[0];
                    for (int i = 1; i < n; i++) {
                        if ((arr1[i] % 2) != 0) {
                            arr1[0] = arr1[i];
                            arr1[i] = temp;
                            k++;
                        }
                    }
                }
            }

            //после того, как первый элемент определен, отсортируем оставшиеся элементы

            int i = 0;
            for (int j = 1; j < arr1.length; j++) {
                if ((arr1[i] % 2) == (arr1[j] % 2)) { //если рядом 2 четных или 2 нечетных элемента
                    int temp = arr1[j];
                    for (int m = j; m < arr1.length; m++) {
                        if ((arr1[m] % 2) != (arr1[j] % 2)) {
                            arr1[j] = arr1[m];
                            arr1[m] = temp;
                            k++;
                            break;
                        }
                    }
                }
                i++;
            }

            System.out.println(k);

            String str1 = Arrays.toString(arr1).replaceAll("[\\[\\],]", " ").trim();
            System.out.print(str1);
        }

    }
}