package encryptdecrypt;

import java.io.IOException;

public interface EncodingDecodingAlgorithm {
    public void encrypt(TargetMessage message) throws IOException;
    public void decrypt(TargetMessage message) throws IOException;
}
