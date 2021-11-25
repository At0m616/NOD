import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
    НОД
    Введи с клавиатуры 2 целых положительных числа.
    Выведи в консоли наибольший общий делитель.

    1 получаем простые множители
    2 находим общие множители
    3 умножаем их, получаем НОД
    */

public class Nod {

    public static List<Integer> simpleMultiplier(int input) {
        List<Integer> resultList = new ArrayList<>();
        int multiplier = 2;
        int value = input;

        while (value > 1) {
            if (value % multiplier == 0) {
                resultList.add(multiplier);
                value /= multiplier;
                multiplier = 2;
            } else {
                multiplier++;
            }
        }
        return resultList;

    }

    public static int commonMultiple(List<Integer> compare1, List<Integer> compare2) {
        compare1.retainAll(compare2);
        return compare1.stream().reduce(1, (i1, i2) -> i1 * i2);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNum = sc.nextInt();
        int secondNum = sc.nextInt();

        if (firstNum == secondNum) {
            System.out.println(firstNum);
            return;
        }

        List<Integer> res = simpleMultiplier(firstNum);
        List<Integer> res2 = simpleMultiplier(secondNum);

        System.out.println(commonMultiple(res, res2));
    }
}

