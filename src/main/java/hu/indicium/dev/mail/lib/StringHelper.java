package hu.indicium.dev.mail.lib;

public class StringHelper {
    public static String replacePlaceholder(String html, String placeholder, String text){
        return html.replaceAll("\\{\\{"+ placeholder +"}}",text);
    }
}
