import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegerToEnglishWord {

    public static String one(int num) {
        switch (num) {
            case 1: return " One";
            case 2: return " Two";
            case 3: return " Three";
            case 4: return " Four";
            case 5: return " Five";
            case 6: return " Six";
            case 7: return " Seven";
            case 8: return " Eight";
            case 9: return " Nine";
            case 10: return "Ten";
        }
        return "";
    }

    public static String ten(int num) {
        switch(num) {
            case 2: return " Twenty";
            case 3: return " Thirty";
            case 4: return " Forty";
            case 5: return " Fifty";
            case 6: return " Sixty";
            case 7: return " Seventy";
            case 8: return " Eighty";
            case 9: return " Ninety";
        }
        return "";
    }

    public static String lessThan20(int num) {
        switch (num) {
            case 11: return " Eleven";
            case 12: return " Twelve";
            case 13: return " Thirteen";
            case 14: return " Fourteen";
            case 15: return " Fifteen";
            case 16: return " Sixteen";
            case 17: return " Seventeen";
            case 18: return " Eighteen";
            case 19: return " Nineteen";
        }
        return "";
    }

    public static String twoDigit(int num) {
        String result = "";

        if (num <= 10)
            result += one(num);
        else if (num < 20)
            result += lessThan20(num);
        else if (num == 0) {
            result += "";
        }
        else {
            int tenBase = num / 10;
            result += ten(tenBase) + one(num % 10);
        }
        return result;
    }

    public static String threeDigit(int num) {
        String result = "";

        int hundred = num / 100;
        int restPart = num % 100;
        if (hundred == 0 && restPart != 0)
            result += twoDigit(restPart);
        else if (hundred != 0 && restPart != 0) {
            result += one(hundred) + " Hundred" + twoDigit(restPart);
        } else if (hundred != 0 && restPart == 0)
            result += one(hundred) + " Hundred";
        return result;
    }

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        String result = "";
        int million = 0;
        int thousand = 0;
        int restNum = 0;

        int billion = num / 1000000000;
        million = (num - (billion * 1000000000)) / 1000000;
        thousand = ((num - ((billion * 1000000000)) - million * 1000000) )/ 1000;
        restNum = (((num - (billion * 1000000000) - million * 1000000) - thousand * 1000));

        if (billion != 0) {
            result += threeDigit(billion) + " Billion";
        }
        if (million != 0) {
            result += threeDigit(million) + " Million";
        }
        if (thousand != 0) {
            result += threeDigit(thousand) + " Thousand";
        }
        if (restNum != 0) {
            result += threeDigit(restNum);
        }
        return result.trim();
    }

    public static void main(String args[]) {
        Consumer<String> out = System.out::println;
        out.accept(numberToWords(1234567));
        out.accept(numberToWords(123));
        out.accept(numberToWords(1234567891));
        out.accept(numberToWords(10));
        out.accept(numberToWords(20));
    }
}
