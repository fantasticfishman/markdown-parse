// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        int Onumber = 0;
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length() && Onumber <1000) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            if(nextOpenBracket == -1){
                break;
            }
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            if(nextCloseBracket == -1){
                break;
            }
            int openParen = markdown.indexOf("(", nextCloseBracket);
            if(openParen == -1){
                break;
            }
            int closeParen = markdown.indexOf(")", openParen);
            if(closeParen == -1){
                break;
            }
            // boolean shatter = true;
            // Onumber++;
            // while(shatter == true || Onumber < 1000){
            //     String check = markdown.substring(openParen+1, closeParen);
            //     if(check.contains("(")){
            //         shatter = false;
            //         openParen = markdown.indexOf("(", openParen+1);
            //         Onumber++;
            //         //break;
            //     }
            // }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}