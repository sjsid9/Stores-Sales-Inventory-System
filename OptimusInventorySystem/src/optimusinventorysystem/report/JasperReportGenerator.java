/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimusinventorysystem.report;

import optimusinventorysystem.bean.*;
import java.io.InputStream;
import java.sql.Connection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Rajesh
 */
public class JasperReportGenerator {

      InputStream designFilePath;
      //String designFilePath;

    public JasperReportGenerator(InputStream designFilePath) {
        this.designFilePath = designFilePath;
        generateReport();
    }
    void generateReport() {
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(designFilePath);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            Connection con = DBConnection.getConnection();
             System.out.println(con);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);
            JasperViewer.viewReport(jasperPrint, false);
            } catch (Exception e) {
            System.out.println("Exception in generationg report, generateReport() of JasperReportGenerator: "+e);
        }

    }
}
