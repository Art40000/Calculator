//Класс Proc обрабатыват входную строку вычисляя значение выражения
public class Proc {

    int iRes;
    String sRes;  // строка для римских чисел
    boolean roman= false;

    Proc(String str)throws CalcException{

        int i = 0;
        int iNum1, iNum2;
        Token tOpp;

        Prim pr = new Prim(str, i);
        if (pr.t == Token.SPACE) { //пропускаем пробелы
            i += pr.iL;
            pr = new Prim(str, i);
        }

        if ((pr.t != Token.NUMB_AR) && (pr.t != Token.NUMB_ROM)) //проверяем соответствуют ли первые после пробелов символы числам
            throw new CalcException("Doesn't satisfy the condition: two operand one operation");

        if (pr.t == Token.NUMB_ROM)
            roman = true;
        iNum1 = pr.iVal;
        i += pr.iL;
        pr = new Prim(str, i);
        if (pr.t == Token.SPACE) {//пропускаем пробелы
            i += pr.iL;
            pr = new Prim(str, i);
        }
        tOpp = pr.t;
        //проверяем соответствут ли символ мат. опперации
        if ((tOpp != Token.MUL) && (tOpp != Token.DIV) && (tOpp != Token.PLUS) && (tOpp != Token.MINUS))
            throw new CalcException("Doesn't satisfy the condition: two operand one operation");
        i += pr.iL;

        pr = new Prim(str, i);
        if (pr.t == Token.SPACE) {//пропускаем пробелы
            i += pr.iL;
            pr = new Prim(str, i);
        }

        if ((pr.t != Token.NUMB_AR) && (pr.t != Token.NUMB_ROM))
            throw new CalcException("Doesn't satisfy the condition: two operand one operation");
        if ( ( (pr.t == Token.NUMB_AR) && roman)||( (pr.t == Token.NUMB_ROM) && !roman) )
            throw new CalcException("It is used different number systems");
        iNum2 = pr.iVal;
        i += pr.iL;

        while (i < str.length()-1) {//проходим строку до конца проверяя не ли лишних символов и оппераций
            pr = new Prim(str, ++i);
            if (pr.t != Token.SPACE)
                throw new CalcException("Doesn't satisfy the condition: two operand one operation");
        }


        switch (tOpp) {
            case MUL:
                iRes = iNum1 * iNum2;
                break;
            case DIV:
                iRes = iNum1 / iNum2;
                break;
            case PLUS:
                iRes = iNum1 + iNum2;
                break;
            case MINUS:
                iRes = iNum1 - iNum2;
                break;
        }

        if (roman) {// для римских чисел переводим результат в соответсвующую строку
            if (iRes > 0)
                sRes = Roman.integerToRoman(iRes);
            else
                throw new CalcException("Roman number can't be negative or zero");
        }
    }
}
