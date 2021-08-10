package com.solvd.orderProject.wordUtils;

import java.util.HashSet;
import java.util.Set;

public class WordSearchRunner {

    public static void main(String[] args) {

        String[] arr = WordUtils.cleanHTMLText(WordUtils.getHTMLFromURL("https://solvdhealth.com/terms-of-use/"));
        Set<String> words = new HashSet<>(){
            {
                add("text");
                add("and");
                add("health");
                add("SOLVD");
            }
        };
        StringBuilder foundAndCountedWordt = WordUtils.search(arr, words);
        WordUtils.fileWriter(foundAndCountedWordt, "src\\main\\resources\\ResultOfCounting.txt");
    }
}
