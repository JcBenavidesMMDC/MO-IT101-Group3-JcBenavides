 package payrollsystem; 

public class PayrollSystem extends EmployeeArray {   
    int logInHour; 
    int logInMinute; 
    int logOutHour;  
    int logOutMinute;
    int lunchBreak = 60;
    int overallMinutesWorked = 0;
    double overallSalary = 0;
    byte count = 1;
    short days = 0;
//    double hourlyRate;
    
    public double EmployeeDetails(){
        System.out.print("Enter employee ID: ");
        int inputId = in.nextInt();
        
        System.out.println("Employe Details -----------------------------------------------------------------------------------");
        inputId--; // decrements inputId for example if user enters 1 it will decrement to zero
        System.out.println("emplyoee ID: " + empId[inputId]);
        System.out.println("Last Name: " + empLname[inputId]);
        System.out.println("First Name: " + empFname[inputId]);
        System.out.println("Birthday: " + empBday[inputId]);
        System.out.println("Address: " + empAddr[inputId]);
        System.out.println("Phone Number: " + empPhNo[inputId]);
        System.out.println("SSS#: " + empSss[inputId]);
        System.out.println("PhilHealth#: " + empPhHealth[inputId]);
        System.out.println("TIN#: " + empTin[inputId]);
        System.out.println("PagIbig#: " + empPagIbig[inputId]);
        System.out.println("Salary: " + empSalary[inputId]);
        System.out.println("Gross Semi-monthly Rate: " + empSemiMonthlyRate[inputId]);
        System.out.println("Hourly Rate: " + empHourlyRate[inputId]);
        System.out.println("\"-----------------------------------------------------------------------------------\"");
        double hourlyRate = empHourlyRate[inputId];
        return hourlyRate;
    }
    public double HoursWorkSalary(double empDetails){
        overallSalary = 0; // Reset overallSalary. Without this line it will pertain the value from the previous loop
        overallMinutesWorked = 0; //same as what mentioned above ^
        System.out.print("Insert working days attended: ");
        days = in.nextShort();
        
        while (count <= days){
        
        System.out.println("Day " + count);
        System.out.print("Enter Log in hour (format HH): ");
        logInHour = in.nextInt();
        System.out.print("Enter Log in minute (format mm): ");
        logInMinute = in.nextInt();
        System.out.print("Enter Log out hour (format HH): ");
        logOutHour = in.nextInt();
        System.out.print("Enter Log out minute (format mm): ");
        logOutMinute = in.nextInt();

        int minutesWorkedDuration = ((logOutHour * 60 + logOutMinute) - (logInHour * 60 + logInMinute)) - lunchBreak; //converts work duration in minutes //the problem is here for ln42
        overallMinutesWorked += minutesWorkedDuration; //accumulates the total minutes worked as the loop progresses
//        System.out.println("***totalMinutesWorked: " + overallMinutesWorked);
//        System.out.println("***Total Minutes Worked: " + minutesWorkedDuration);
        int totalHoursWorked = minutesWorkedDuration / 60;
        int remainingMinutes = minutesWorkedDuration % 60;
        System.out.println("Total Hours Worked: " + totalHoursWorked + " hours and " + remainingMinutes + " minutes.");
//        double totalMinutesWorked2 = MinutesWorkedDuration;

        double totalMinutesWorked = minutesWorkedDuration;
        if (totalMinutesWorked > 469 && totalMinutesWorked < 481) { // 469 is the minutes of 8:11 //overtime is not working      
        int x = (int)totalMinutesWorked;//converts double to int
        int result = 480 - x;
//        System.out.println("***result: " + result); // debug line
        totalMinutesWorked = result + totalMinutesWorked; //hoursWorkCalc should be double
//        System.out.println("***totalMinutesWorked: " + totalMinutesWorked);  // debug line
        }
        
        double minToHourConv = totalMinutesWorked / 60; // 60 is a constant number for converting minutes to hours
//        System.out.println("***minToHourConv: " + minToHourConv); // debug line
        double totalSalary = minToHourConv * empDetails; //reminder empDetails has the value of hourlyRate from EmployeeDetails
        overallSalary += totalSalary;
        System.out.println("Total Salary Based on Hours Worked: " + totalSalary);
//        System.out.println("***overallSalary: " + overallSalary);
        System.out.println("-----------------------------------------------------------------------------------");
        
        count++;
        } //LOOPS ENDS HERE
        
        count = 1; //resets ("Day " + count) to 1. Without this line the program will read the previous count value
          
        int totalHours = overallMinutesWorked / 60;
        int remainingMinutes = overallMinutesWorked % 60;
//        System.out.println("***totalMinutesWorked: " + overallMinutesWorked);
        System.out.println("Total Hours Worked Overall: " + totalHours + " hours and " + remainingMinutes + " minutes.");
        System.out.println("Gross Salary: " + overallSalary);       
        //NOTE: return overallSalary for the deductions
        return overallSalary;
    }
    
    static double SSS(double grossSalary){
        //reference https://docs.google.com/spreadsheets/d/1YKa0iDKP4aOLlS8pa5Y1ZnTsnUN_IokCo15fFd855X4/edit#gid=0
        double sssDeduction = 0.0;
        if(grossSalary <= 3250){
             sssDeduction = 135.00;
        }
        else if(grossSalary >= 3250  && grossSalary <= 3750){
             sssDeduction = 157.50;
        }
        else if(grossSalary >= 3750  && grossSalary <= 4250){
             sssDeduction = 180.00;
        }        
        else if(grossSalary >= 4250  && grossSalary <= 4750){
             sssDeduction = 202.50;
        }
        else if(grossSalary >= 4750  && grossSalary <= 5250){
             sssDeduction = 225.00;
        }        
        else if(grossSalary >= 5250  && grossSalary <= 5750){
             sssDeduction = 247.50;
        }
        else if(grossSalary >= 5750  && grossSalary <= 6250){
             sssDeduction = 270.00;
        }        
        else if(grossSalary >= 6250  && grossSalary <= 6750){
             sssDeduction = 292.50;
        }
        else if(grossSalary >= 6750  && grossSalary <= 7250){
             sssDeduction = 315.00;
        }        
        else if(grossSalary >= 7250  && grossSalary <= 7750){
             sssDeduction = 337.50;
        }
        else if(grossSalary >= 7750  && grossSalary <= 8250){
             sssDeduction = 360.00;
        }        
        else if(grossSalary >= 8250  && grossSalary <= 8750){
             sssDeduction = 382.50;
        }
        else if(grossSalary >= 8750  && grossSalary <= 9250){
             sssDeduction = 405.00;
        }        
        else if(grossSalary >= 9250  && grossSalary <= 9750){
             sssDeduction = 427.50;
        }
        else if(grossSalary >= 9750  && grossSalary <= 10250){
             sssDeduction = 450.00;
        }        
        else if(grossSalary >= 10250  && grossSalary <= 10750){
             sssDeduction = 472.50;
        }
        else if(grossSalary >= 10750  && grossSalary <= 11250){
             sssDeduction = 495.00;
        }        
        else if(grossSalary >= 11250  && grossSalary <= 11750){
             sssDeduction = 517.50;
        }
        else if(grossSalary >= 11750  && grossSalary <= 12250){
             sssDeduction = 540.00;
        }       
        else if(grossSalary >= 12250  && grossSalary <= 12750){
             sssDeduction = 517.50;
        }
        else if(grossSalary >= 12750  && grossSalary <= 13250){
             sssDeduction = 540.00;
        }       
        else if(grossSalary >= 13250  && grossSalary <= 13750){
             sssDeduction = 607.50;
        }
        else if(grossSalary >= 13750  && grossSalary <= 14250){
             sssDeduction = 630.00;
        }        
        else if(grossSalary >= 14250  && grossSalary <= 14750){
             sssDeduction = 652.50;
        }
        else if(grossSalary >= 14750  && grossSalary <= 15250){
             sssDeduction = 675.00;
        }        
        else if(grossSalary >= 15250  && grossSalary <= 15750){
             sssDeduction = 697.50;
        }
        else if(grossSalary >= 15750  && grossSalary <= 16250){
             sssDeduction = 720.00;
        }       
        else if(grossSalary >= 16250  && grossSalary <= 16750){
             sssDeduction = 742.50;
        }
        else if(grossSalary >= 16750  && grossSalary <= 17250){
             sssDeduction = 765.00;
        }        
        else if(grossSalary >= 17250  && grossSalary <= 17750){
             sssDeduction = 787.50;
        }
        else if(grossSalary >= 17750  && grossSalary <= 18250){
             sssDeduction = 810.00;
        }        
        else if(grossSalary >= 18250  && grossSalary <= 18750){
             sssDeduction = 832.50;
        }
        else if(grossSalary >= 18750  && grossSalary <= 19250){
             sssDeduction = 855.00;
        }        
        else if(grossSalary >= 19250  && grossSalary <= 19750){
             sssDeduction = 877.50;
        }
        else if(grossSalary >= 19750  && grossSalary <= 20250){
             sssDeduction = 900.00;
        }        
        else if(grossSalary >= 20250  && grossSalary <= 20750){
             sssDeduction = 922.50;
        }
        else if(grossSalary >= 20750  && grossSalary <= 21250){
             sssDeduction = 945.00;
        }        
        else if(grossSalary >= 21250 && grossSalary <= 21750){
             sssDeduction = 922.50;
        }
        else if(grossSalary >= 21750 && grossSalary <= 22250){
             sssDeduction = 945.00;
        }       
        else if(grossSalary >= 22250 && grossSalary <= 22750){
             sssDeduction = 1012.50;
        }
        else if(grossSalary >= 22750 && grossSalary <= 23250){
             sssDeduction = 1035.00;
        }       
        else if(grossSalary >= 22250 && grossSalary <= 22750){
             sssDeduction = 1012.50;
        }
        else if(grossSalary >= 22750 && grossSalary <= 23250){
             sssDeduction = 1035.00;
        }        
        else if(grossSalary >= 23250 && grossSalary <= 23750){
             sssDeduction = 1057.50;
        }
        else if(grossSalary >= 23750 && grossSalary <= 24250){
             sssDeduction = 1080.00;
        }        
        else if(grossSalary >= 24250 && grossSalary <= 24750){
             sssDeduction = 1057.50;
        }
        else if(grossSalary > 24750){
             sssDeduction = 1080.00;
        }
        System.out.println("SSS Contribution: " + sssDeduction);
        return sssDeduction;        
    }
    static double PhilHealth(double grossSalary){
        //reference https://docs.google.com/spreadsheets/d/1ZaLG84WdAfvIju3S656S7S1viO6AmuElAHhK6efDbTU/edit#gid=0
        double premiumRate = grossSalary * 0.03;
//        System.out.println("***preiumRate: " + premiumRate);
        double empShare = premiumRate * 0.5;
        System.out.println("PhilHealth Contribution: " + empShare);
        return empShare;
    }
    static double PagIbig(double grossSalary){
        //reference https://docs.google.com/spreadsheets/d/1BWapYIfRJf6wGx-PC92Gj1YQ9wzpNnYBoV7_4LcKxOk/edit#gid=0
        double pagIbigContr;
        if(grossSalary >= 1000 && grossSalary <= 1500){
            double empContrRate = 0.01;
            double emplyrContrRate = 0.02;
            double total = empContrRate + emplyrContrRate;
            pagIbigContr = grossSalary - total;
        }
        else if(grossSalary >= 1500 && grossSalary <= 2500){ //2500 will reach 100
            double empContrRate = 0.01;
            double emplyrContrRate = 0.02;
            double total = empContrRate + emplyrContrRate;
            pagIbigContr = grossSalary - total;
        }else{
            pagIbigContr = 100;
        }
        System.out.println("Pag-Ibig Contribution: " + pagIbigContr);
        return pagIbigContr;
    }
    static double WitholdingTax(double grossSalary, double sss, double philHealth, double pagIbig){
        //refernce https://docs.google.com/spreadsheets/d/1RcYFHYjmoUdTJmLUgxslEDrWRxgrW_w7-D_TNPMvM8k/edit#gid=0
        double totalDeduct = sss + philHealth + pagIbig;
        System.out.println("TOTAL DEDUCTIONS: " + totalDeduct);
        double taxIncome = grossSalary - totalDeduct;
        System.out.println("TAXABLE INCOME: " + taxIncome);
        double withHoldingTax = 0;
        
        if (taxIncome <= 20832){
            withHoldingTax = 0;
        }
        else if (taxIncome > 20832 && taxIncome <= 33333){
            withHoldingTax = (taxIncome - 20833)*0.2; 
        }
        else if (taxIncome > 33333 && taxIncome <= 66667){
            withHoldingTax = (taxIncome - 33333)*0.25 + 2500; 
        }
        else if (taxIncome > 66667 && taxIncome <= 166667){
            withHoldingTax = (taxIncome - 66667)*0.3 + 10833; 
        }
        else if (taxIncome > 166667 && taxIncome <= 666667){
            withHoldingTax = (taxIncome - 166667)*0.32 + 40833.33; 
        }
        else if (taxIncome > 666667){
            withHoldingTax = (taxIncome - 666667)*0.35 + 200833.33; 
        }
        System.out.println("WITHHOLDING TAX: " + withHoldingTax);
        double netSalary = taxIncome - withHoldingTax;
        System.out.println("Net Salary: " + netSalary);
        return netSalary;
    }
}
