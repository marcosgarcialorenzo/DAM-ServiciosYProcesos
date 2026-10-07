import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        Process p = pb.start();
    }
}