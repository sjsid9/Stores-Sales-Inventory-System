/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimusinventorysystem.bean;

/**
 *
 * @author Rajesh
 */
public class ClientResponsibilityBean {

    private int client_ID;
    private double tax_Deduction;
    private double loan_EMI;
    private double insurance_EMI;
    private double house_Rent;
    private int dependents;
    private double personal_Expenditure;
    private double health_Expenditure;

    public int getClient_ID() {
        return client_ID;
    }

    public void setClient_ID(int client_ID) {
        this.client_ID = client_ID;
    }

    public int getDependents() {
        return dependents;
    }

    public void setDependents(int dependents) {
        this.dependents = dependents;
    }

    public double getHealth_Expenditure() {
        return health_Expenditure;
    }

    public void setHealth_Expenditure(double health_Expenditure) {
        this.health_Expenditure = health_Expenditure;
    }

    public double getHouse_Rent() {
        return house_Rent;
    }

    public void setHouse_Rent(double house_Rent) {
        this.house_Rent = house_Rent;
    }

    public double getInsurance_EMI() {
        return insurance_EMI;
    }

    public void setInsurance_EMI(double insurance_EMI) {
        this.insurance_EMI = insurance_EMI;
    }

    public double getLoan_EMI() {
        return loan_EMI;
    }

    public void setLoan_EMI(double loan_EMI) {
        this.loan_EMI = loan_EMI;
    }

    public double getPersonal_Expenditure() {
        return personal_Expenditure;
    }

    public void setPersonal_Expenditure(double personal_Expenditure) {
        this.personal_Expenditure = personal_Expenditure;
    }

    public double getTax_Deduction() {
        return tax_Deduction;
    }

    public void setTax_Deduction(double tax_Deduction) {
        this.tax_Deduction = tax_Deduction;
    }
}
