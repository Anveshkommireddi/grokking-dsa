package com.learn.java.misc;

import java.util.HashMap;
import java.util.Map;

public class FileRename {
    public static void main(String[] args) {
        String oldFileName = "anvesh_1654785148574.p12";
        System.out.println("oldName ::: " + oldFileName);
        boolean isMatch = oldFileName.matches(".*_\\d{13}$|.*_\\d{13}\\.(cer|pfx|p12)$");
        String newFileName = null;
        if (isMatch) {
            int val = oldFileName.lastIndexOf("_");
            newFileName = oldFileName.replace(oldFileName.substring(val + 1, val + 14), String.valueOf(System.currentTimeMillis()));
        } else {
            boolean extensionMatch = oldFileName.matches(".*\\.(cer|pfx|p12)$");
            if (extensionMatch) {
                newFileName = oldFileName.substring(0, oldFileName.length() - 4).concat("_").concat(String.valueOf(System.currentTimeMillis())).concat(oldFileName.substring(oldFileName.length() - 4, oldFileName.length()));
            } else {
                newFileName = oldFileName.concat("_").concat(String.valueOf(System.currentTimeMillis()));
            }
        }
        System.out.println("newName ::: " + newFileName);
    }
}
