import java.io.File;
import java.nio.file.Files;

public class Circulation {
    public static void main(String[] args) {
        File file = new File("D:/Test");
        File files[] = file.listFiles();
        int i = 0;
        while (i < files.length) {
            if (file.isDirectory()) {
                File files1[] = files[i].listFiles();
                if (files1 != null) {
                    int j = 0;
                    while (j < files1.length) {
                        System.out.println("files[j] = " + files1[j]);
                        j++;
                    }
                }
                System.out.println("files[i] = " + files[i]);
                i++;
            }
        }
    }
}
