package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class JSONGenerator extends ReportGenerator{
    @Override
    public Report instantiateReport() {
        return new  JSONReport();
    }
}
