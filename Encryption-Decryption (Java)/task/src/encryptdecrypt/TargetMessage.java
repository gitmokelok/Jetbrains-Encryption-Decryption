package encryptdecrypt;

import java.lang.annotation.Target;

public class TargetMessage {

    public String algorithmName = "shift"; // possible values: shift, unicode
    public String operationType = "enc";
    public int numberOfLettersToShift = 0;
    public String fileInPath = "-1";
    public String fileOutPath = "-1";
    public char[] data = null;

    public TargetMessage(String[] inputText) {

        for (int i = 0; i < inputText.length; i = i+2) {
            switch(inputText[i]) {
                case "-mode" :
                    operationType = inputText[i+1];
                    break;
                case "-key" :
                    numberOfLettersToShift = Integer.parseInt(inputText[i+1]);
                    break;
                case "-data" :
                    data = inputText[i+1].toCharArray();
                    break;
                case "-in" :
                    fileInPath = inputText[i+1];
                    break;
                case "-out" :
                    fileOutPath = inputText[i+1];
                    break;
                case "-alg" :
                    algorithmName = inputText[i+1];
                    break;
            }
        }
    }

}
