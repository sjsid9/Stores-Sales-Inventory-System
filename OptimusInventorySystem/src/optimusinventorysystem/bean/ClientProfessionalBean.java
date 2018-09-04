/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimusinventorysystem.bean;

/**
 *
 * @author Rajesh
 */
public class ClientProfessionalBean {

    private int client_ID;
    private String profession;
    private String designation;
    private String office_Phone;
    private String office_Address;
    private double annual_Income;
    private double income_Other;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getAnnual_Income() {
        return annual_Income;
    }

    public void setAnnual_Income(double annual_Income) {
        this.annual_Income = annual_Income;
    }

    public int getClient_ID() {
        return client_ID;
    }

    public void setClient_ID(int client_ID) {
        this.client_ID = client_ID;
    }

    public double getIncome_Other() {
        return income_Other;
    }

    public void setIncome_Other(double income_Other) {
        this.income_Other = income_Other;
    }

    public String getOffice_Address() {
        return office_Address;
    }

    public void setOffice_Address(String office_Address) {
        this.office_Address = office_Address;
    }

    public String getOffice_Phone() {
        return office_Phone;
    }

    public void setOffice_Phone(String office_Phone) {
        this.office_Phone = office_Phone;
    }


    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    
}
