package com.company;
import java.util.Scanner;

public class Main {
static Scanner tal = new Scanner(System.in);
static Scanner tekst = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int userChoice;

        boolean goOn = true;
        System.out.println("Velkommen til caesar cipher");
        System.out.println("for at komme i gang skal jeg blot vide havd du vil, der er fælgende muligheder:");
        while (goOn) {
            System.out.println("1: Enkrypter Besked" +
                    "\n2: Dekrypter Besked" +
                    "\n0: Afslutter programmet "+
                    "\nIndtast et tal:");
            userChoice = sc.nextInt();
            if (userChoice == 2) {
                decryptCaesarMenu();
                System.out.println("");
            }
            else if (userChoice == 1) {
                encryptCaesarMenu();
                System.out.println("");
            }
            else if (userChoice == 0) {
                goOn = false;
            }else{
                System.out.println("Du indtastede: " + userChoice);
            }
        }
        System.out.println("Programmet er afsluttet");
    }

    // NumberCipher
    public static void encryptNumberMenu() {
    }
    public static void decryptNumberMenu() {
    }
    public static String listOfNumbersToText( int[] numbers ) {
        int i;
        char temp;
        char[] tempResultat = new char[numbers.length];

        for(i = 0; i < numbers.length; i++){
            temp = numberToLetter(numbers[i]);
            tempResultat[i] = temp;
        }
        String resultat = String.valueOf(tempResultat);
        return resultat;
    }
    public static char numberToLetter( int number ) {
        char[] alfabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ".toCharArray();
        char result = alfabet[number];
        return result;
    }
    public static int[] textToListOfNumbers( String text ) {
        int resultat[] = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            char tempLetter = text.charAt(i);
            int tempNumber = letterToNumber(tempLetter);
            resultat[i] = tempNumber;
        }
        return resultat;
    }
    public static int letterToNumber( char letter ) {
        char[] alfabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ".toCharArray();
        char capLet = Character.toUpperCase(letter);
        int nummer = 0;
        for (int i = 0; i < alfabet.length; i++){
            char bogstavViTjekker = alfabet[i];
            if( capLet == bogstavViTjekker) {
                nummer = i;
            }
        }
        return nummer;
    }
    public static void encryptCaesarMenu(){
        Scanner scEncryptText = new Scanner(System.in);
        Scanner scEncryptShift = new Scanner(System.in);
        System.out.println("Indtast din tekst here:");
        String userPlaintext = scEncryptText.nextLine();
        System.out.println("Indtast shiftværdi:");
        int userShiftVærdi = scEncryptShift.nextInt();
        String resultat = caesarEncrypt(userPlaintext,userShiftVærdi);
        System.out.println("Den enkrypterede besked er: ");
        System.out.println(resultat);
    }
    public static void decryptCaesarMenu(){
        Scanner scDecryptText = new Scanner(System.in);
        Scanner scDecryptShift = new Scanner(System.in);
        System.out.println("Indtast din ciphertext here:");
        String userPlaintext = scDecryptText.nextLine();
        System.out.println("Indtast shiftværdi:");
        int userShiftVærdi = scDecryptShift.nextInt();
        String result = caesarDecrypt(userPlaintext,(-userShiftVærdi));
        System.out.println("Den dekrypterede besked er: ");
        System.out.println(result);
    }
    public static String caesarDecrypt( String ciphertext, int shift){
        int[] numberList = textToListOfNumbers(ciphertext);
        int[] numberListShifted = shiftListOfNumbers(numberList,shift);
        String result = listOfNumbersToText(numberListShifted);
        return result;
    }
    public static String caesarEncrypt( String plaintext, int shift){
        int[] numberList = textToListOfNumbers(plaintext);
        int[] numberListShifted = shiftListOfNumbers(numberList,shift);
        String result = listOfNumbersToText(numberListShifted);
        return result;
    }

    public static int[] shiftListOfNumbers( int[] numbers , int shift){
        int listOfNumbers[] = new int[numbers.length];
        int i;
        for (i = 0; i < numbers.length; i++){
            listOfNumbers[i] = shiftNumber(numbers[i],shift);
        }
        return listOfNumbers;
    }
    public static int shiftNumber( int number, int shift ){
        if(number == 0){
            return number;
        }
        int shiftedNumber = number + shift;
        if(shiftedNumber > 29){
            shiftedNumber = shiftedNumber - 29;
        }
        if(shiftedNumber <= 0){
            shiftedNumber = shiftedNumber + 29;
        }
        return shiftedNumber;
    }
}