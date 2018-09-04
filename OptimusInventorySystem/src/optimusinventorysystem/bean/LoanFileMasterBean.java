/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimusinventorysystem.bean;

/**
 *
 * @author Rajesh
 */
public class LoanFileMasterBean {

    private int file_ID;
    private String creation_Date;
    private int plan_ID;
    private int client_ID;
    private double loan_Amount;
    private String loan_Status;
    private int client_ID_Proof;
    private int client_Residence_Proof;
    private int client_Income_Proof;
    private int client_Bank_Statement;
    private String remarks;
    private String clientName;
    private String planName;
    private int user_ID;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getClient_Bank_Statement() {
        return client_Bank_Statement;
    }

    public void setClient_Bank_Statement(int client_Bank_Statement) {
        this.client_Bank_Statement = client_Bank_Statement;
    }

    public int getClient_ID() {
        return client_ID;
    }

    public void setClient_ID(int client_ID) {
        this.client_ID = client_ID;
    }

    public int getClient_ID_Proof() {
        return client_ID_Proof;
    }

    public void setClient_ID_Proof(int client_ID_Proof) {
        this.client_ID_Proof = client_ID_Proof;
    }

    public int getClient_Income_Proof() {
        return client_Income_Proof;
    }

    public void setClient_Income_Proof(int client_Income_Proof) {
        this.client_Income_Proof = client_Income_Proof;
    }

    public int getClient_Residence_Proof() {
        return client_Residence_Proof;
    }

    public void setClient_Residence_Proof(int client_Residence_Proof) {
        this.client_Residence_Proof = client_Residence_Proof;
    }

    public String getCreation_Date() {
        return creation_Date;
    }

    public void setCreation_Date(String creation_Date) {
        this.creation_Date = creation_Date;
    }

    public int getFile_ID() {
        return file_ID;
    }

    public void setFile_ID(int file_ID) {
        this.file_ID = file_ID;
    }

    public double getLoan_Amount() {
        return loan_Amount;
    }

    public void setLoan_Amount(double loan_Amount) {
        this.loan_Amount = loan_Amount;
    }

    public String getLoan_Status() {
        return loan_Status;
    }

    public void setLoan_Status(String loan_Status) {
        this.loan_Status = loan_Status;
    }

    public int getPlan_ID() {
        return plan_ID;
    }

    public void setPlan_ID(int plan_ID) {
        this.plan_ID = plan_ID;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }
    
}
