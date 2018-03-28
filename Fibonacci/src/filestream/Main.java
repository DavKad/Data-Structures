package filestream;

import java.io.*;
import java.util.*;


public class Main
{
    String line;
    int number;
    
    public void FileReader(String name)
    {
        File FileToRead = new File(name);
        try {
            BufferedReader FileReaded = new BufferedReader(new FileReader(FileToRead));
             
            try {
                while ((line = FileReaded.readLine()) != null)
                {
                    number = Integer.parseInt(line);
                }
  
            } catch (IOException ex) {
                 System.out.println(ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
             System.out.println(ex.getMessage());
        }
    }
    
    public void FileSaver(String name, String table)
    {
        File FileToSave = new File(name);
        try {
            try (BufferedWriter FileSaved = new BufferedWriter(new FileWriter(FileToSave, true))) {
                FileSaved.write(table);
               
                FileSaved.newLine();
                FileSaved.close();
            }
        } catch (IOException ex) {
             System.out.println(ex.getMessage());
        }  
    }
    
    public void FileTimeSaver(String name, String time)
    {
        File FileToSave = new File(name);
        try {
            try (BufferedWriter FileSaved = new BufferedWriter(new FileWriter(FileToSave, true))) {
                FileSaved.write(time + " ms");
                FileSaved.newLine();
                FileSaved.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    void makeFibb()
    {
        long start =  System.currentTimeMillis();
        Main FileAction = new Main();
        String data;

        FileAction.FileReader("plik.txt");
        long f, f0 = 0, f1 = 1;
        long[] table = new long[FileAction.number];
        
 
        for(int i = 0; i < FileAction.number; i++)
            {
                 if (i > 1) 
                   {
                        f  = f0 + f1;
                        f0 = f1;
                        f1 = f;
                    }
                    else 
                        f = i;
                   table[i] = f;   
            }   

        for (int i = 0; i < table.length; i++)
            {
                System.out.println(table[i]);
                data = Integer.toString((int)table[i]);
                FileAction.FileSaver("fib.csv",data);
            }

        long stop = System.currentTimeMillis();
        long result = (stop-start);
        String time = Integer.toString((int) result);
        FileAction.FileTimeSaver("fib.csv",time); 
        System.out.println("Czas wykonania: " + result + " ms");
    }
    public long recursionFibb(int n) {
        return n<2? n : recursionFibb(n - 1) + recursionFibb(n - 2);
    }
    public void Menu()
    {
        boolean control = true;
        while (control) 
        {            
            //Menu optioons
            System.out.println("Menu");
            System.out.println("1. Fibbanaci");
            System.out.println("2. Wyjście");
        
            //Get user choice
            System.out.println("Wybierz opcje");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            
            //Correctly menu
            switch(choice)
            {
                case 1:
                   long start =  System.currentTimeMillis();
                   
                   Main FileAction = new Main();
                   FileAction.FileReader("plik.txt");

                   System.out.println(FileAction.recursionFibb(FileAction.number));
                   
                   long stop = System.currentTimeMillis();
                   long result = (stop-start);
                   String time = Integer.toString((int) result);
                   FileAction.FileTimeSaver("fib.csv",time); 
                   System.out.println("Czas wykonania: " + result + " ms");
                   control = false;
                   break;
                                    
                case 2:
                   control = false; 
                   break;
                    
                default:
                   System.out.println("Nieodpowiednia opcja");
            }
            
        }
    }
    
    public static void main(String[] args) 
    {
       Main RunProgram = new Main();
       RunProgram.Menu();      
    }
}
