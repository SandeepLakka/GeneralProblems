package io.github.sandeeplakka.general.problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {

    public static final String TEXT =
            "/* This is multi line comment\n" +
                    "as you can see I'm not bothered\n" +
                    "by what compiler or jvm thinks of me\n" +
                    "I'm invisible :D \n*/\n" +
                    "\n" +
                    "public static void main(String[] args) {\n" +
                    "   System.out.println(\"Hello World\");\n" +
                    "}\n";
    public static final String TEXT2 =
            "/* This is multi line comment\n" +
                    "as you can see I'm not bothered\n" +
                    "by what compiler or jvm thinks of me\n" +
                    "I'm invisible :D \n*/\n" +
                    "        /*Another one\n" +
                    "          for you\n" +
                    "         */\n" +
                    "\n" +
                    "public static void main(String[] args) {\n" +
                    "   System.out.println(\"Hello World\");\n" +
                    "}\n";

    public static void main(String[] args) {
        System.out.println(TEXT2);
        Pattern startOfMultiLineComment = Pattern.compile("/\\*");
        Pattern endOfMultiLineComment = Pattern.compile("\\*/");
        Matcher mlStarts = startOfMultiLineComment.matcher(TEXT2);
        Matcher mlEnds = endOfMultiLineComment.matcher(TEXT2);

        int mlStartIndex = -1;
        int mlEndIndex = -1;
        if (mlStarts.find()) mlStartIndex = mlStarts.start();
        if (mlEnds.find()) mlEndIndex = mlEnds.end();

        System.out.println(mlStarts.start() + "," + mlStarts.end());
        System.out.println(mlEnds.start() + "," + mlEnds.end());


        StringBuilder builder = new StringBuilder();
        builder.append(TEXT2.substring(0, mlStartIndex));
        builder.append(TEXT2.substring(mlEndIndex));

        System.out.println("------------------------");
        System.out.println(builder.toString());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(TEXT2.replaceAll("/\\*.*\\*/", "$1$2"));
        System.out.println("--@@____________________@@--");
        //lazy quantifier *?
        System.out.println(TEXT2.replaceFirst("\\/\\*.*?\\*\\/", ""));


    }
/*
    /*

    //*/
    //hello
    //*/

}
