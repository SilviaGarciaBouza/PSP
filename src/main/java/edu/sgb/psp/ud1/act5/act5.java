package edu.sgb.psp.ud1.act5;

public class act5 {
    //Muestra información detallada,
    // de aquellos procesos cuyo PID contiene el valor 264
    public static void main(String[] args) {
        System.out.println("tasklist /v /fi \"PID eq 264\" ");
        //Imprimir por pantalla todo aquel proceso donde el uso de
        // su memoria es mayor a 15000 y menor de 19000, por lo que
        // , todo proceso que esté comprendido en ese rango,
        //  será mostrado.
        System.out.println("tasklist /fi \"MEMUSAGE gt 15000\" /fi \"MEMUSAGE lt 19000\"");
        //ccv Busca todos los procesos que sean de chrome.exe o notepad.exe
        System.out.println("tasklist /fi \"imagename eq chrome.exe\"");
        System.out.println("tasklist /fi \"imagename eq notepad.exe\" ");

        //Extraer todos los procesos con un ID de proceso superior a 1000 y mostrarlas en
        // formato csv. Redirigirla a un fichero llamado procesos.csv
        System.out.println("tasklist /fo csv /fi \"Pid gt 1000\" >> procesos.csv");
        //Enumerar toda la información detallada para todos los procesos que se están
        // ejecutando actualmente
        System.out.println("tasklist /v /fi \"status eq RUNNING\"");
        //Abre el notepad, busca su pid y elimina el proceso mediante taskkill por pid
        System.out.println("tasklist /fi \"imagename eq notepad.exe\"");
        System.out.println("taskkill /pid 1234 /f");
        //Abre el notepad, pero ahora vamos a matar su proceso mediante taskkill por nombre
        System.out.println("taskkill /im notepad.exe /f");
    }
}

