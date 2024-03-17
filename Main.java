
package payrollsystem;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        PayrollSystem pS = new PayrollSystem();
        Scanner in = new Scanner(System.in);
        byte end = 0;
        String prompt;
        
        
        while(end < 1){
        byte endIftLoop = 0; //must declared within the while statement to reset the value.
            
        double empDetails = pS.EmployeeDetails(); //supposedly hourlyRate but renamed to empDetails
//        System.out.println("***hourlyRate: " + empDetails); //debugline
        double grossSalary = pS.HoursWorkSalary(empDetails);
//        System.out.println("***grossSalary: " + grossSalary); //testline
        
        double sss = PayrollSystem.SSS(grossSalary); //this is the code line for calling the method I think.
//        System.out.println("***sss:" + sss);
        double philHealth = PayrollSystem.PhilHealth(grossSalary);
//        System.out.println("***philHealth: " + philHealth);
        double pagIbig = PayrollSystem.PagIbig(grossSalary);
//        System.out.println("***pagIbig: " + pagIbig);
        double withHoldingTax = PayrollSystem.WitholdingTax(grossSalary, sss, philHealth, pagIbig);
        
        while(endIftLoop < 1){
        System.out.print("\nInsert another employee y/n?: ");
        prompt = in.nextLine();
        
        if(prompt.equals("n") || prompt.equals("N")){
            end++;
            endIftLoop++;
        }
        else if(prompt.equals("y") || prompt.equals("Y")){
            endIftLoop++;
            System.out.println("");
        }
        else if(!prompt.equals("y") || !prompt.equals("Y")){
            System.out.println("\nInvalid input try again");
        }
        
        }       
    }
          
    }
    
}
