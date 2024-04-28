package Lesson18;

public class Probka {
    public static void main(String[] args) {
        String str1="Bu probkalar";
        String str2="da bezdirdi";
        String str3=" e bizi";
        String sentence;
        sentence=str1+""+str2+""+str3;
        System.out.println(sentence);
        StringBuilder mystring= new StringBuilder("Mercy to the guilty is cruelty to the victim");
        mystring.append("\nKim demisdi yadimda deyil");
        System.out.println(mystring);
    }
}
