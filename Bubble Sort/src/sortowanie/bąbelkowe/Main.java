package sortowanie.bąbelkowe;

import java.io.*;
import java.util.*;

public class Main
{
    ArrayList<Integer> list = new ArrayList();
    String line;
    public void FileReader(String name)
    {
        File FileToRead = new File(name);
        try {
            BufferedReader FileReaded = new BufferedReader(new FileReader(FileToRead));
            
            try {
                while ((line = FileReaded.readLine()) != null)
                {
                    list.add(Integer.parseInt(line));
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
                FileSaved.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    public void Menu()
    {
        boolean control = true;
        while(control)
        {
            //Menu options
            System.out.println("Menu");
            System.out.println("1. Posortuje elementy");
            System.out.println("2. Wyjście");
            
            //Get user choice
            Scanner input = new Scanner(System.in);
            System.out.println("Wybierz opcje");
            int choice = input.nextInt();
            
            //Correctly menu
            switch(choice)
            {
                case 1:
                    long start = System.currentTimeMillis();
                    Main file = new Main();
                    file.FileReader("plik.txt");

                    int capture;
                    String data;
                    int[] table =  new int[file.list.size()];

                    for(int i = 0; i < table.length; i++)
                    {
                        table[i] =(int)file.list.get(i);
                    }

                     System.out.println("Przed sortowaniem: ");

                     for (int i = 0; i < table.length; i++)
                     {
                         System.out.println(table[i]);
                     }

                     for (int i = 0; i < file.list.size() - 1; i++)
                     {
                         for(int j = 0; j < file.list.size() - 1; j++)
                         {         
                             if (table[j]>table[j+1])
                             {
                                 capture = table[j];
                                 table[j] = table[j + 1];
                                 table[j + 1] = capture;  
                             }
                         }
                     } 

                     System.out.println("Po sortowaniu:");

                     for (int i = 0; i < table.length; i++)
                     {
                         System.out.println(table[i]);
                         data = Integer.toString(table[i]);
                         file.FileSaver("sort.csv",data);
                     }
                     System.out.println("Zapisano do pliku:");
                     long stop = System.currentTimeMillis();
                     long result = (stop-start);

                     System.out.println("Czas wykonania: " + result + " ms");
                     String time = Integer.toString((int) result);
                     file.FileTimeSaver("sort.csv",time);    
                     
                     control = false;
                     break;
                
                case 2:
                    control = false;
                    break;
                
                default:
                    System.out.println("Nieodpowiednia opcjha");    
            }
       }
        
    }
    
    public static void main(String[] args) 
    {
        Main RunProgram = new Main();
        RunProgram.Menu();
        
//        Konwertowanie int[] do Stringa do zapisu.
//
//        String stringTable = Arrays.toString(table);
//
//        System.out.println(stringTable);

        
        
        
    }
}