/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimusinventorysystem.bean;

/**
 *
 * @author Rajesh
 */
public class LoanIssueMasterBean {

    private int loan_ID;
    private String issue_Date;
    private double loan_Duration_Year;
    private double emi;
    private String check_No;
    private String Check_Bank;
    private String loan_Amount;
    private int file_ID;

    public String getLoan_Amount() {
        return loan_Amount;
    }

    public void setLoan_Amount(String loan_Amount) {
        this.loan_Amount = loan_Amount;
    }

    public String getCheck_Bank() {
        return Check_Bank;
    }

    public void setCheck_Bank(String Check_Bank) {
        this.Check_Bank = Check_Bank;
    }

    public String getCheck_No() {
        return check_No;
    }

    public void setCheck_No(String check_No) {
        this.check_No = check_No;
    }

    public double getEmi() {
        return emi;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }

    public int getFile_ID() {
        return file_ID;
    }

    public void setFile_ID(int file_ID) {
        this.file_ID = file_ID;
    }

    public String getIssue_Date() {
        return issue_Date;
    }

    public void setIssue_Date(String issue_Date) {
        this.issue_Date = issue_Date;
    }

    public double getLoan_Duration_Year() {
        return loan_Duration_Year;
    }

    public void setLoan_Duration_Year(double loan_Duration_Year) {
        this.loan_Duration_Year = loan_Duration_Year;
    }

    public int getLoan_ID() {
        return loan_ID;
    }

    public void setLoan_ID(int loan_ID) {
        this.loan_ID = loan_ID;
    }
    
}
