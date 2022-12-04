package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class PDFGenerator extends ReportGenerator{
    @Override
    public Report instantiateReport() {
        return new PDFReport();
    }
}
