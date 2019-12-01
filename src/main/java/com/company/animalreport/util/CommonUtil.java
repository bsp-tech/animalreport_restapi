/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.animalreport.util;

import java.util.Random;

/**
 *
 * @author sarkhanrasullu
 */
public class CommonUtil {

    private static Random r = new Random();

    public static String nDigit(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += r.nextInt(10);
        }

        return result;
    }

}
