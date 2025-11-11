package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class E06 {
    public static void main(String[] args) throws Exception{


        String name = "";
        ProcessBuilder pb = new ProcessBuilder("taskkill");
        Process p= pb.start();
        List<String> l= getList(p).stream().filter(s->s.contains(name)).toList();


    }
    static List<String> getList(Process p) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
        List<String> myList=new ArrayList<>();
        while (b.readLine() != null){
            myList.add(b.readLine());
        }
        return myList;
    }
}

