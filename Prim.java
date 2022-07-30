//Класс Prim при инициализации принимает строку и позицию, по ним определяет тип символа
// (число, мат. операция см. Token), определяет его значение и длину, присваивает эти значения полям класса
public class Prim {
    Token t;
    int iVal;
    int iL;
    Prim (String str, int i) throws CalcException{

        if( i >= str.length() )
            throw new CalcException("Doesn't satisfy the condition: two operand one operation");

        char c = str.charAt(i);
        switch (c) {
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                t=Token.NUMB_AR;
                iL = 1;
                iVal = Character.getNumericValue(c);
                break;
            case '1':
                if (i < str.length() - 1) {
                    if (str.charAt(i + 1) == '0') {
                        t=Token.NUMB_AR;
                        iL = 2;
                        iVal = 10;
                        break;
                    } else {
                        t=Token.NUMB_AR;
                        iL = 1;
                        iVal = 1;
                        break;
                    }
                }
                else {
                    t=Token.NUMB_AR;
                    iL = 1;
                    iVal = 1;
                    break;
                }
            case 'I':
            case 'V':
            case 'X':
            case 'L':
            case 'C':
            case 'D':
            case 'M':
                Roman rom = new Roman(str, i);
                t=Token.NUMB_ROM;
                iL = rom.iLenght;
                iVal = rom.iVal;
                break;
            case '+':
                t=Token.PLUS;
                iL = 1;
                iVal = 0;
                break;
            case '-':
                t=Token.MINUS;
                iL = 1;
                iVal = 0;
                break;

            case '*':
                t=Token.MUL;
                iL = 1;
                iVal = 0;
                break;
            case '/':
                t=Token.DIV;
                iL = 1;
                iVal = 0;
                break;
            case ' ':
                int ie=i;
                while ((ie < (str.length()-1)) && (c== ' '))
                    c = str.charAt(++ie);
                t=Token.SPACE;
                iL = ie-i;
                iVal = 0;
                break;
            default:
                throw new CalcException("Unsuitable symbol");

        }
    }
}
