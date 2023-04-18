package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ShiftAlgorithm implements EncodingDecodingAlgorithm {

    @Override
    public void encrypt(TargetMessage message) throws IOException {
        if(!"-1".equals(message.fileInPath) && !"-1".equals(message.fileOutPath)) {
            encryptFileText(message);
        } else {
            char[] targetTextAsChars = message.data;
            for (char c : targetTextAsChars) {
                System.out.print(getEncryptedChar(c, message.numberOfLettersToShift));
            }
            System.out.println();
        }
    }

    @Override
    public void decrypt(TargetMessage message) throws IOException {
        if(!"-1".equals(message.fileInPath) && !"-1".equals(message.fileOutPath)) {
            decryptFileText(message);
        } else {
            char[] targetTextAsChars = message.data;
            for (char c : targetTextAsChars) {
                System.out.print(getDecryptedChar(c, message.numberOfLettersToShift));
            }
            System.out.println();
        }
    }

    public char getDecryptedChar(char inputChar, int skipNumberOfLetters) {
        //a = 97, z = 122

        if (Character.isLetter(inputChar)) {

            int targetCharIntegerValue = (int)Character.toLowerCase(inputChar) - skipNumberOfLetters ; //0
            if (targetCharIntegerValue < (int) 'a') {
                targetCharIntegerValue = (int) 'z' - ((int) 'a' -  targetCharIntegerValue) + 1;
            }
            return Character.isLowerCase(inputChar) ? (char) targetCharIntegerValue : Character.toUpperCase((char) targetCharIntegerValue) ;
        } else {
            return inputChar;
        }
    }

    public char getEncryptedChar(char inputChar, int skipNumberOfLetters) {
        //a = 97, z = 122

        if (Character.isLetter(inputChar)) {
            int targetCharIntegerValue = (int)Character.toLowerCase(inputChar) + skipNumberOfLetters ; //0
            if (targetCharIntegerValue > (int) 'z') {
                targetCharIntegerValue = targetCharIntegerValue - (int) 'z' + (int) 'a' - 1 ;
            }
            return Character.isLowerCase(inputChar) ? (char) targetCharIntegerValue : Character.toUpperCase((char) targetCharIntegerValue) ;
        } else {
            return inputChar;
        }
    }

    private void encryptFileText(TargetMessage message) throws IOException {
        char[] inFileTextAsCharArray = new String(Files.readAllBytes(Paths.get(message.fileInPath))).toCharArray();
        StringBuilder sb = new StringBuilder();
        System.out.println(new String(Files.readAllBytes(Paths.get(message.fileInPath))));
        for (char c: inFileTextAsCharArray) {
            sb.append(getEncryptedChar(c, message.numberOfLettersToShift));
        }
        System.out.println(sb);

        File outFile = new File(message.fileOutPath);
        try(FileWriter writer = new FileWriter(outFile)) {
            writer.write(sb.toString());
        }
    }

    private void decryptFileText(TargetMessage message) throws IOException {
        char[] inFileTextAsCharArray = new String(Files.readAllBytes(Paths.get(message.fileInPath))).toCharArray();
        StringBuilder sb = new StringBuilder();
        System.out.println(new String(Files.readAllBytes(Paths.get(message.fileInPath))));
        for (char c: inFileTextAsCharArray) {
            sb.append(getDecryptedChar(c, message.numberOfLettersToShift));
        }
        System.out.println(sb);

        File outFile = new File(message.fileOutPath);
        try(FileWriter writer = new FileWriter(outFile)) {
            writer.write(sb.toString());
        }
    }






}
