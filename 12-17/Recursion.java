import java.io.File;

public class Recursion {
    public static void main(String[] args) {
        File file = new File("D:/Test");
        FileRecursion(file);
    }
    static void FileRecursion(File file){
        if(file.isDirectory()){
            File files[]= file.listFiles();
            for(File f:files) {
                FileRecursion(f);
                System.out.println(f.getName());
            }
        }
    }
}
