package com.leetcode.solutions;

class Problem8{
    public static void main(String[] args) {
        System.out.println(myAtoi("42") == 42);
        System.out.println(myAtoi("   -42") == -42);
        System.out.println(myAtoi("4193 a") == 4193);
        System.out.println(myAtoi("words and 234") == 0);
        System.out.println(myAtoi("3.14") == 3);
        System.out.println(myAtoi("+1") == 1);
        System.out.println(myAtoi("+-1") == 0);
        System.out.println(myAtoi("-+1") == 0);
        System.out.println(myAtoi("+0") == 0);
        System.out.println(myAtoi("010") == 10);
        System.out.println(myAtoi("-010") == -10);
        System.out.println(myAtoi("-001") == -1);
        System.out.println(myAtoi("  -0012a42") == -12);
        System.out.println(myAtoi("   +0 123") == 0);
        System.out.println(myAtoi("  78") == 78);
        System.out.println(myAtoi("  ") == 0);
        System.out.println(myAtoi("  0000000000012345678") == 12345678);
        System.out.println(myAtoi("-91283472386876876876879879732") == -2147483648);
        
    }

    public static int myAtoi(String str) {
        
 
        // trim white spaces
        str = str.trim();

        if (str == null || str.length() < 1)
		return 0;
    
        char flag = '+';
    
        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;
    
        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
    
        if (flag == '-')
            result = -result;
    
        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
    
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
    
        return (int) result;
        
    }

    public static int myAtoi1(String str) {
        long num = 0;
        int dec = 0;
        boolean signFlag = false;
        int l = str.length();
        for (int i=l-1; i>=0; i--){
            switch (str.charAt(i)){
                case '1':
                num = num + 1*(int) Math.pow(10, dec);
                dec++;
                break;
                case '2':
                num = num + 2*(int) Math.pow(10, dec);
                dec++;
                break;
                case '3':
                num = num + 3*(int) Math.pow(10, dec);
                dec++;
                break;
                case '4':
                num = num + 4*(int) Math.pow(10, dec);
                dec++;
                break;
                case '5':
                num = num + 5*(int) Math.pow(10, dec);
                dec++;
                break;
                case '6':
                num = num + 6*(int) Math.pow(10, dec);
                dec++;
                break;
                case '7':
                num = num + 7*(int) Math.pow(10, dec);
                dec++;
                break;
                case '8':
                num = num + 8*(int) Math.pow(10, dec);
                dec++;
                break;
                case '9':
                num = num + 9*(int) Math.pow(10, dec);
                dec++;
                break;
                case '.':
                num = 0;
                dec = 0;
                break;
                case '-':
                num = num * -1;
                case '+':
                    if (signFlag){
                        return 0;
                    }
                    signFlag = true;
                break;
                case '0':
                    dec++;
                    break;
                case ' ':
                default:
                    if (num>0){
                        num = 0;
                        dec = 0;
                    }
            }

            
        }
        if (num > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if (num < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int) num;
    }
}