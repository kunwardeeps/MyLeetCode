package com.leetcode.solutions;

class Problem12{
    public static void main(String[] args) {
        System.out.println(intToRoman(3).equals("III"));
        System.out.println(intToRoman(4).equals("IV"));
        System.out.println(intToRoman(9).equals("IX"));
        System.out.println(intToRoman(8).equals("VIII"));
        System.out.println(intToRoman(58).equals("LVIII"));
        System.out.println(intToRoman(1994).equals("MCMXCIV"));
        System.out.println(intToRoman(217).equals("CCXVII"));
        System.out.println(intToRoman1(545).equals("DXLV"));
        System.out.println(intToRoman(145).equals("CXLV"));
        System.out.println(intToRoman(48).equals("XLVIII"));
        System.out.println(intToRoman(3999).equals("MMMCMXCIX"));
    }

    /**
     * Better solution
     */
    public static String intToRoman1(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
        StringBuilder sb = new StringBuilder();
    
        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    public static String intToRoman(int num) {
        String str = "", dig="";
        char high = ' ', low = ' ', mid = ' ';
        int d = 0,m = 1;
        while (num != 0){
            d = num%10;
            if (d==0){
                num = num/10;
                m = m*10;
                continue;
            }
            else if (d>=5){
                high = getChar(m*10);
                mid = getChar(m*5);
                low = getChar(m);
            }
            else if (d<5){
                high = getChar(m*5);
                mid = getChar(m);
                low = mid;
            }
            if (d%5==4){
                str = Character.toString(low) + Character.toString(high) + str;
            }
            else {
                dig = "";
                if (d>=5){
                    dig = mid + dig;
                }
                while (d%5 != 0){
                    dig = dig + low;
                    d--;
                }
                str = dig + str;
            }
            num = num/10;
            m = m*10;
        }
        //System.out.println(str);
        return str;
    }

    public static char getChar(int i){
        switch(i){
            case 1: return 'I';
            case 5: return 'V';
            case 10: return 'X';
            case 50: return 'L';
            case 100: return 'C';
            case 500: return 'D';
            case 1000: return 'M';
            default: return '0';
        }
    }
}