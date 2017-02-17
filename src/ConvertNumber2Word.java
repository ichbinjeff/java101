/**
 * Created by jli on 4/14/16.
 */
public class ConvertNumber2Word {
    String[] digits = new String[] {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    String[] teen = new String[] {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eightteen", "nineteen"};
    String[] ten = new String[] {"ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    String[] bigNum = new String[] {"", "thousand", "million", "billion"};

    public String convertNum2Word(int num) {
        int count = 0;
        String rst = "";
        //100 002 220
        while (num > 0) {
            if (num % 1000 != 0) {
                rst = convert100(num % 1000) + " " + bigNum[count] + " " + rst;
            }
            num /= 1000;
            count ++;
        }
        return rst;
    }

    //1
    //14
    //23
    //36
    //102
    public String convert100(int num) {
        String rst = "";
        if (num / 100 > 0) {
            rst = digits[num / 100 - 1] + " hundred";
            num %= 100;
        }

        if (num == 0) {
            return rst;
        } else {
            if (num < 10) {
                rst = rst +  digits[num - 1];
            } else if (num == 10) {
                rst = rst +  ten[0];
            } else if (num > 11 && num < 19) {
                rst = rst +  teen[num % 10 - 1];
            } else if (num >= 20) {
                rst += " " + ten[num / 10 - 1];
                if (num % 10 == 0) {
                    return rst;
                } else {
                    rst += " " + digits[num % 10 - 1];
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        ConvertNumber2Word CNW = new ConvertNumber2Word();
        CNW.convertNum2Word(10092220);
        System.out.print("dine");
    }

}
