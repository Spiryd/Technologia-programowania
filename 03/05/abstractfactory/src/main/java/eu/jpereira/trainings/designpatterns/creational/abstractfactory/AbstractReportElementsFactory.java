package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

public abstract class AbstractReportElementsFactory {
    public abstract ReportBody createReportBody();
    public abstract ReportFooter createReportFooter();
    public abstract ReportHeader createReportHeader();
}
