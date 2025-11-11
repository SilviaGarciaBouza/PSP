package ejercicios.E08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Master {
    public static void main(String[] args) throws Exception {


    Scanner sc = new Scanner(System.in);
    List<String> integerList = new ArrayList<>();
    String num="0";
    int max;
        while (!num.equals("fin") ){
        System.out.println("introduce numeros: letra para detener");
        num= sc.nextLine();
        if(num != "fin"){
            integerList.add(num);
        }
    }
        String pathJAva= System.getProperty("java.class.path");

        ProcessBuilder pb= new ProcessBuilder("java", "-cp", pathJAva, "com.ejemplo.Subordjinate");
        if(!integerList.isEmpty()){
        pb.command().addAll(integerList);}
        pb.start().waitFor();
    }
}
