import java.util.regex.*;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class Second_B {

    private static int sum = 0;

    public static void main(String[] args) {

        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                sum += matching(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(sum);
    }

    private static int matching(String data) {

        Pattern setPattern = Pattern.compile("(\\d+ \\w+,? ?)+");
        Pattern redPattern = Pattern.compile("(\\d+) red");
        Pattern greenPattern = Pattern.compile("(\\d+) green");
        Pattern bluePattern = Pattern.compile("(\\d+) blue");

        Matcher setMatcher = setPattern.matcher(data);

        int red = 0;
        int green = 0;
        int blue = 0;

        while (setMatcher.find()) {
            Matcher redMatcher = redPattern.matcher(setMatcher.group(0));
            Matcher greenMatcher = greenPattern.matcher(setMatcher.group(0));
            Matcher blueMatcher = bluePattern.matcher(setMatcher.group(0));

            if (redMatcher.find()) {
                if (strToNumber(redMatcher.group(1)) > red)
                    red = strToNumber(redMatcher.group(1));
            }
            if (greenMatcher.find()) {
                if (strToNumber(greenMatcher.group(1)) > green)
                    green = strToNumber(greenMatcher.group(1));
            }
            if (blueMatcher.find()) {
                if (strToNumber(blueMatcher.group(1)) > blue)
                    blue = strToNumber(blueMatcher.group(1));
            }
        }

        return red * green * blue;
    }

    private static int strToNumber(String str) {
        switch (str) {
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            default:
                return Integer.parseInt(str);
        }
    }
}