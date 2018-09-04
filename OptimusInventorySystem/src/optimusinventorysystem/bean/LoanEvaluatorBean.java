/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package optimusinventorysystem.bean;

/**
 *
 * @author Rajesh
 */
public class LoanEvaluatorBean {
Double year;
String monthlyPayments;

String canBeIssued;

    public String getCanBeIssued() {
        return canBeIssued;
    }

    public void setCanBeIssued(String canBeIssued) {
        this.canBeIssued = canBeIssued;
    }

    public String getMonthlyPayments() {
        return monthlyPayments;
    }

    public void setMonthlyPayments(String monthlyPayments) {
        this.monthlyPayments = monthlyPayments;
    }

    public Double getYear() {
        return year;
    }

    public void setYear(Double year) {
        this.year = year;
    }

   
}
