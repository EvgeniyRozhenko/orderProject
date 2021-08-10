package com.solvd.orderProject.wordUtils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Set;

public class WordUtils {
    private static final Logger LOGGER = LogManager.getLogger(WordUtils.class);

    public static StringBuilder getHTMLFromURL(String addressURL) {
        StringBuilder text = new StringBuilder();
        String buffer;
        try(BufferedReader allInput = new BufferedReader(new InputStreamReader(Objects.requireNonNull(getURL(addressURL)).openStream()));) {
            while ((buffer = allInput.readLine()) != null ) {
                text.append(buffer);
            }
            return text;
        }
        catch (IOException e) {
            LOGGER.error("The string could not be parsed!");
        }

        return text;
    }

    private static URL getURL(String addressURL) {
        try {
            return new URL(addressURL);
        } catch (MalformedURLException e) {
            LOGGER.error((Marker) e,"The malformed URL has occurred!");
        }

        return null;
    }

    public static String[] cleanHTMLText(StringBuilder htmlText) {
        String str = StringUtils.replaceEach(htmlText.toString(),
                new String[]{"<", ">", "!", "?", "=", "_", "(", ")", "{", "}", "[", "]", "\"", ",", ".",
                        "'", ":", "/", "\\", "&&", "++", "||", ";", "+"},
                new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
                        " ", " ", " ", " ", " ", " ", " ", " "});
        return str.split(" ");

    }

    public static StringBuilder search(String[] text, Set<String> words) {
        StringBuilder builder = new StringBuilder();
        int[] counter = new int[words.size()];
        int index = 0;

        for (String word : words) {
            for (String value : text) {

                if ((word.compareToIgnoreCase(value)) == 0) {
                    counter[index] += 1;
                }
            }
            builder.append(word).append(" ").append("-").append(" ").append(counter[index]).append('\n');
            ++index;
        }

        return builder;
    }

    public static void fileWriter(StringBuilder words, String relativeFilePath) {
        File localFile = Paths.get(relativeFilePath).toAbsolutePath().toFile();
        try {
            FileUtils.writeStringToFile(localFile, words.toString(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.error(e.getStackTrace());
        }
    }
}
