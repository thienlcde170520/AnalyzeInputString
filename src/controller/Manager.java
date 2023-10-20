
package controller;

import common.Algorithms;
import common.Library;
import view.Menu;


public class Manager extends Menu<String>{
    static String[] mc = {"Input Data.","Exit."};
    
    private Library l;
    private Algorithms al;
    public Manager(){
        super("======= Analyze Program =======",mc);
        l = new Library();
        al = new Algorithms();
    }

    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                al.AnalyzeProgram();
                break;
            case 2:
                System.out.println("Exit the program successfully!");
                System.exit(0);
                break;
        }
    }
}
