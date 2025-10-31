package practicas.p02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Master {
    public static void main(String[] args) throws FileNotFoundException {


        System.out.println("Escribe la ruta a analizar: ");
        Scanner sc= new Scanner(System.in);
        String path= sc.nextLine();
        System.out.println("Escribe el numero de procesos: ");
        int n= Integer.parseInt(sc.nextLine());
        int linesTotalFile=0;
        try(
        BufferedReader br= new BufferedReader(new FileReader("path.txt"));
        ){
            String line;
            while ((line = br.readLine()) != null) {
                linesTotalFile++;
            }

        }catch (Exception e){

        }
        int linesCadaProcess= linesTotalFile/n;
        int linesSObrantes= linesTotalFile%n;

        String pathR= "";
        for(int i=0; i<n;i++) {
            ProcessBuilder pb= new ProcessBuilder("java", "Worker", pathR, String.valueOf((i< linesSObrantes)? linesCadaProcess +1 : linesCadaProcess));
        }




    }
}