package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class XMLGenerator extends ReportGenerator{
    @Override
    public Report instantiateReport() {
        return new XMLReport();
    }
}
