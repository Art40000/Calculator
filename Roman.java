//Класс Roman при инициализации принимает строку и позицию, по ним определяет значение и длину содержащегося чмсла
public class Roman {
    public int iVal;
    public int iLenght;

    Roman(String str, int i) {

        int ie = i;
        char c ='I';
        String substr;

        while ((ie < (str.length()-1)) && isRoman(str, ie))
            c = str.charAt(++ie);
        if (isRoman(str, ie))
            ie++;
        substr = str.substring(i, ie);
        iVal = romanToInteger(substr);
        iLenght = ie - i;
    }

    //метод проверяет относится ли данная позиция в строке к римскому числу
    boolean isRoman(String str, int i) {
        char c = str.charAt(i);
        if ((c == 'I') || (c == 'V') || (c == 'X') || (c == 'L') || (c == 'C') || (c == 'D') || (c == 'M'))
            return true;
        else
            return false;
    }

    //возвращает значение римского число
    public int romanToInteger(String roman) {

        int number = 0;
        for (int i = 0; i < roman.length(); i++) {
            char c = roman.charAt(i);
            switch (c) {
                case 'I':
                    number = (i != roman.length() - 1 && (roman.charAt(i + 1) == 'V' || roman.charAt(i + 1) == 'X'))
                            ? number - 1
                            : number + 1;
                    break;
                case 'V':
                    number += 5;
                    break;
                case 'X':
                    number = (i != roman.length() - 1 && (roman.charAt(i + 1) == 'L' || roman.charAt(i + 1) == 'C'))
                            ? number - 10
                            : number + 10;
                    break;
                case 'L':
                    number += 50;
                    break;
                case 'C':
                    number = (i != roman.length() - 1 && (roman.charAt(i + 1) == 'D' || roman.charAt(i + 1) == 'M'))
                            ? number - 100
                            : number + 100;
                    break;
                case 'D':
                    number += 500;
                    break;
                case 'M':
                    number += 1000;
                    break;
            }
        }

        return number;
    }

    private static final int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    private static final String[] romanLiterals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    //метод переводит число в строку с римсиким числом
    public static String integerToRoman(int number) {

        int i = getFloorIndex(number);
        if (number == values[i]) {
            return romanLiterals[i];
        }

        return romanLiterals[i] + integerToRoman(number - values[i]);
    }
    // вспомогательный метод для метода integerToRoman
    private static int getFloorIndex(int number) {
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                return i;
            }
        }
        return -1;
    }
}