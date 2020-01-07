import java.util.Scanner;

public class PluralFormAssignment {
    public static String PluralForm(String Eword, String word) {
        if ((Eword.charAt(Eword.length() - 1) == '!') && (Eword.charAt(Eword.length() - 2) == 'y')) {
            word = word.replace("y","ies");
            return word;
        }
        if (Eword.charAt(Eword.length() - 1) == 's' || Eword.charAt(Eword.length()- 1) == 'x' || Eword.charAt(Eword.length()- 1) == 'z') {
            return word + "es";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'h') && (Eword.charAt(Eword.length() - 2) == 'c')) {
            return word + "es";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'h') && (Eword.charAt(Eword.length() - 2) == 's')) {
            return word + "es";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'o') && (Eword.charAt(Eword.length() - 2) != 'a')) {
            return word + "es";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'o') && (Eword.charAt(Eword.length() - 2) == 'a')) {
            return word + "s";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'o') && (Eword.charAt(Eword.length() - 2) != 'e')) {
            return word + "es";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'o') && (Eword.charAt(Eword.length() - 2) == 'e')) {
            return word + "s";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'o') && (Eword.charAt(Eword.length() - 2) != 'i')) {
            return word + "es";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'o') && (Eword.charAt(Eword.length() - 2) == 'i')) {
            return word + "s";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'o') && (Eword.charAt(Eword.length() - 2) != 'o')) {
            return word + "es";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'o') && (Eword.charAt(Eword.length() - 2) == 'o')) {
            return word + "s";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'o') && (Eword.charAt(Eword.length() - 2) != 'u')) {
            return word + "es";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'o') && (Eword.charAt(Eword.length() - 2) == 'u')) {
            return word + "s";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'y') && (Eword.charAt(Eword.length() - 2) == 'a')) {
            return word + "s";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'y') && (Eword.charAt(Eword.length() - 2) == 'b')) {
            word = word.replace("y","");
            return word + "ies";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'y') && (Eword.charAt(Eword.length() - 2) == 'e')) {
            return word + "s";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'y') && (Eword.charAt(Eword.length() - 2) == 'n')) {
            word = word.replace("y","");
            return word + "ies";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'y') && (Eword.charAt(Eword.length() - 2) == 'i')) {
            return word + "s";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'y') && (Eword.charAt(Eword.length() - 2) == 'p')) {
            word = word.replace("y","");
            return word + "ies";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'y') && (Eword.charAt(Eword.length() - 2) == 'o')) {
            return word + "s";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'y') && (Eword.charAt(Eword.length() - 2) == 'd')) {
            word = word.replace("y","");
            return word + "ies";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'y') && (Eword.charAt(Eword.length() - 2) == 'u')) {
            return word + "s";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'y') && (Eword.charAt(Eword.length() - 2) == 'l')) {
            word = word.replace("y","");
            return word + "ies";
        }
        if ((Eword.charAt(Eword.length() - 1) == 'f')) {
            word = word.replace("f","v");
            return word + "es";
        }
        else {
            return word + "s";
        }
    }
    public static void main(String[] args) {
        System.out.println("This program converts an English word to its plural form.");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("English word: ");
        String Eword = sc.nextLine();
        String word = Eword;
        if (word.charAt(word.length() - 1) == '.') {
            word = word.replace(".","");
            System.out.println("Plural form: " + PluralForm(Eword, word) + ".");
        }
        else if (word.charAt(word.length() - 1) == '!') {
            word = word.replace("!","");
            System.out.println("Plural form: " + PluralForm(Eword, word) + "!");
        }
        else if (word.charAt(word.length() - 1) == ',') {
            word = word.replace(",","");
            System.out.println("Plural form: " + PluralForm(Eword, word) + ",");
        }
        else if (word.charAt(word.length() - 1) == '?') {
            word = word.replace("?","");
            System.out.println("Plural form: " + PluralForm(Eword, word) + "?");
        }
        else if (word.charAt(word.length() - 1) == ';') {
            word = word.replace(";","");
            System.out.println("Plural form: " + PluralForm(Eword, word) + ";");
        }
        else {
        System.out.println("Plural form: " + PluralForm(Eword, word));
        }
    }
}