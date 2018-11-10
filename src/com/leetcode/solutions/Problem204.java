package com.leetcode.solutions;

class Problem204{
    public static void main(String[] args) {
        System.out.println(countPrimes(10) == 4);
        System.out.println(countPrimes(100) == 25);
        System.out.println(countPrimes(1) == 0);
        System.out.println(countPrimes(0) == 0);
        System.out.println(countPrimes(3) == 1);
        System.out.println(countPrimes(4) == 2);
        System.out.println(countPrimes(999983) == 78497);
    }

    public static int countPrimes(int n) {
        boolean[] composites = new boolean[n];
        for (int i=2; i<n; i++){
            if (composites[i] == false){
                for (int j=2; i*j<n; j++){
                    composites[i*j] = true;
                }
            }
        }
        int count=0;
        for (int i=2; i<n; i++){
            if (!composites[i]){
                count++;
            }
        }
        return count;
    }

    public static int countPrimesSlow(int n) {
        if (n <= 2){
            return 0;
        }
        int givenNum = n;
        int composites = 0;
        n--;
        while (n>1){
            for (int i = (int)Math.sqrt(n); i>1; i--){
                if (n%i == 0){
                    composites++;
                    break;
                }
            }
            n--;
        }
        return givenNum-composites-2;
    }
}