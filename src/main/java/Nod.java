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

    private final int firstNum;
    private final int secondNum;

    public Nod(int firstNum, int secondNum) {
        if (firstNum < 1 || secondNum < 1) {
            throw new IllegalArgumentException();
        }
        //firstNum always < secondNum
        if (firstNum < secondNum) {
            this.firstNum = firstNum;
            this.secondNum = secondNum;
        } else {
            this.firstNum = secondNum;
            this.secondNum = firstNum;
        }
    }

    public int getFirstNum() {
        return firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public int getNod() {

        if (firstNum == secondNum) {
            return firstNum;
        }
        List<Integer> firstNumMultiplierList = simpleMultiplier(firstNum);
        List<Integer> secondNumMultiplierList = simpleMultiplier(secondNum);
        return commonMultiple(firstNumMultiplierList, secondNumMultiplierList);
    }

    private static List<Integer> simpleMultiplier(int input) {
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

    private static int commonMultiple(List<Integer> compare1, List<Integer> compare2) {
        compare1.retainAll(compare2);
        return compare1.stream().reduce(1, (i1, i2) -> i1 * i2);
    }

}

