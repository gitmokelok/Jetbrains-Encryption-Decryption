package encryptdecrypt;

import java.io.IOException;

public class AlgorithmRunner {
    private EncodingDecodingAlgorithm algorithm;

    public void setAlgorithm(EncodingDecodingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void encrypt(TargetMessage message) throws IOException {
        this.algorithm.encrypt(message);
    }
    public void decrypt(TargetMessage message) throws IOException {
        this.algorithm.decrypt(message);
    }


}
