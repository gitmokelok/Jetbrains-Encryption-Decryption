package encryptdecrypt;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        //args = "-mode enc -key 5 -data \"Welcome_to_hyperskill!\"".split("\s");
        //args = "-mode dec -key 5 -data Bjqhtrj_yt_mdujwxpnqq!".split("\s");
        //args = "-mode dec -key 10 -alg shift -data dbokcebo".split("\s");
        //args = "mode enc -key 5 -data Welcome_to_hyperskill! -alg unicode".split("\s");
        //args = "-key 5 -alg unicode -data \\jqhtrj%yt%m~ujwxpnqq& -mode dec".split("\s");

        TargetMessage targetMessage = new TargetMessage(args);
        AlgorithmRunner algorithmRunner = new AlgorithmRunner();

        switch (targetMessage.algorithmName) {
            case "shift":
                algorithmRunner.setAlgorithm(new ShiftAlgorithm());
                break;
            case "unicode":
                algorithmRunner.setAlgorithm(new UnicodeAlgorithm());
                break;
        }

        if (targetMessage.operationType.equals("enc")) {
            algorithmRunner.encrypt(targetMessage);
        } else {
            algorithmRunner.decrypt(targetMessage);
        }
    }
}
