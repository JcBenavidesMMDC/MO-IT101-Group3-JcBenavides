package payrollsystem;
import java.util.Scanner;

public class EmployeeArray {
    Scanner in = new Scanner(System.in);
    String[] empId = {"1", "2", "3"};
    String[] empLname = {"Garcia", "Lim", "Aquino"};
    String[] empFname = {"Manuel III", "Antonio", "Bianca Sofia"};
    String[] empBday = {"10/11/1983", "06/19/1988", "08/04/1989"};
    String[] empAddr = {"Valero Carpark Building Valero Street 1227, Makati City", "San Antonio De Padua 2, Block 1 Lot 8 and 2, Dasmarinas, Cavite", "Rm. 402 4/F Jiao Building Timog Avenue Cor. Quezon Avenue 1100, Quezon City"};
    String[] empPhNo = {"966-860-270", "171-867-411", "966-889-370"};
    String[] empSss = {"44-4506057-3", "52-2061274-9", "30-8870406-2"};
    String[] empPhHealth = {"820126853951", "331735646338", "177451189665"};
    String[] empTin = {"442-605-657-000", "683-102-776-000", "971-711-280-000"};
    String[] empPagIbig = {"691295330870", "663904995411", "171519773969"};
    double[] empSalary = {90000, 60000, 60000};
    double[] empSemiMonthlyRate = {45000, 30000, 30000}; //empSalary divided by 2
    double[] empHourlyRate = {535.71, 357.14, 357.14};

    
//    public double EmployeeDetails(){
//        System.out.print("Enter employee ID: ");
//        int inputId = in.nextInt();
//        
//        System.out.println("Employe Details -----------------------------------------------------------------------------------");
//        inputId--; // decrements inputId for example if user enters 1 it will decrement to zero
//        System.out.println("emplyoee ID: " + empId[inputId]);
//        System.out.println("Last Name: " + empLname[inputId]);
//        System.out.println("First Name: " + empFname[inputId]);
//        System.out.println("Birthday: " + empBday[inputId]);
//        System.out.println("Address: " + empAddr[inputId]);
//        System.out.println("Phone Number: " + empPhNo[inputId]);
//        System.out.println("SSS#: " + empSss[inputId]);
//        System.out.println("PhilHealth#: " + empPhHealth[inputId]);
//        System.out.println("TIN#: " + empTin[inputId]);
//        System.out.println("PagIbig#: " + empPagIbig[inputId]);
//        System.out.println("Salary: " + empSalary[inputId]);
//        System.out.println("Gross Semi-monthly Rate: " + empSemiMonthlyRate[inputId]);
//        System.out.println("Hourly Rate: " + empHourlyRate[inputId]);
//        System.out.println("\"-----------------------------------------------------------------------------------\"");
//        double hourlyRate = empHourlyRate[inputId];
//        return hourlyRate;
//    }
}
