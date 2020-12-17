import com.sun.org.apache.xpath.internal.SourceTreeManager;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        File file = new File("D:/Test");
        File files[] = file.listFiles();
        for(File f:files){
            if(f.isDirectory()){
                File files1[] = f.listFiles();
                for(File f1:files1){
                    if(f1.isDirectory()){
                        File files2[]= f1.listFiles();
                        for(File f2:files2){
                            System.out.println("f2.getName() = " + f2.getName());

                        }
                    }
                    System.out.println("f1.getName() = " + f1.getName());
                }
            }
            System.out.println(f.getName());
        }
    }
}

