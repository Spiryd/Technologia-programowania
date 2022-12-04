package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class HTMLGenerator extends ReportGenerator{
    @Override
    public Report instantiateReport() {
        return new HTMLReport();
    }
}
