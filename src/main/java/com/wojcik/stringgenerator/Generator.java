package com.wojcik.stringgenerator;

import com.wojcik.stringgenerator.dto.GenerateRequest;

import java.util.HashSet;
import java.util.Random;

public class Generator {

    public static String generate(GenerateRequest request) {
        long combination = getCombination(request.getMax(), request.getChars());
        if (request.getNumberOfStrings() <= combination) {
            StringBuilder sb = new StringBuilder();
            HashSet<String> stringHashSet = new HashSet<>();

            while (stringHashSet.size() < request.getNumberOfStrings()) {
                Random random = new Random();
                stringHashSet.add(getRandomString(random.nextInt(request.getMax() - request.getMin()) + request.getMin(), request.getChars()));
            }
            for (String s : stringHashSet) {
                sb.append(s).append("\n");
            }
            return sb.toString();
        } else
            throw new IllegalArgumentException(String.format("Cannot generate enough lines. Expected number of strings:%s, maximal possible combination %s",
                    request.getNumberOfStrings(), combination));
    }

    public static long getCombination(int max, String chars) {
        long n = factorialCalculator(max);
        long k = factorialCalculator(max - chars.length());
        return n / k;
    }

    static String getRandomString(int n, String chars) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (chars.length() * Math.random());
            sb.append(chars
                    .charAt(index));
        }
        return sb.toString();
    }

    public static long factorialCalculator(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

}
