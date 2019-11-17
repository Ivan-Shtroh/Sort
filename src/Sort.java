import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int amountOfElem = Integer.parseInt(sc.nextLine());
        String elements = sc.nextLine();
        String[] elementsArrayStr = elements.split(" ");
        int[] elementsArray = new int[amountOfElem];
        int count = 0;
        for (String i : elementsArrayStr) {
            elementsArray[count++] = Integer.parseInt(i);
        }

        int chetCount = 0;
        int nechCount = 0;

        for (int value : elementsArray) { //посчитаем четные и нечетные числа
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
            System.out.print(elementsArray[0]); // и этот элемент единственный (т.к. (chetCount - nechCount)<=1)
        } else { // если перестановки возможны

            //определим первый элемент
            if (chetCount > nechCount) { //если четных больше, начинаем с четного
                if ((elementsArray[0] % 2) != 0) { //если первый элемент нечетный
                    int temp = elementsArray[0];
                    for (int i = 1; i < amountOfElem; i++) {
                        if ((elementsArray[i] % 2) == 0) { //ставим на первое место (0-инд.) четный элемент
                            elementsArray[0] = elementsArray[i];
                            elementsArray[i] = temp;
                            k++;
                            break;
                        }
                    }
                }
            } else if (chetCount < nechCount) { //если нечетных больше, начинаем с нечетного
                if ((elementsArray[0] % 2) == 0) { //если первый элемент нечетный
                    int temp1 = elementsArray[0];
                    for (int a = 1; a < amountOfElem; a++) {
                        if ((elementsArray[a] % 2) != 0) {
                            elementsArray[0] = elementsArray[a];
                            elementsArray[a] = temp1;
                            k++;
                            break;
                        }
                    }
                }
            }

            //после того, как первый элемент определен, отсортируем оставшиеся элементы
            int i = 0;
            for (int j = 1; j < elementsArray.length; j++) {
                if ((elementsArray[i] % 2) == (elementsArray[j] % 2)) { //если рядом 2 четных или 2 нечетных элемента
                    int temp2 = elementsArray[j];
                    for (int m = j; m < elementsArray.length; m++) {
                        if (elementsArray[m] % 2 != (elementsArray[j] % 2)) {
                            elementsArray[j] = elementsArray[m];
                            elementsArray[m] = temp2;
                            k++;
                            break;
                        }
                    }
                }
                i++;
            }

            System.out.println(k);

            String result = Arrays.toString(elementsArray).replaceAll("[\\[\\],]", "").trim();
            System.out.print(result);
        }

    }
}
