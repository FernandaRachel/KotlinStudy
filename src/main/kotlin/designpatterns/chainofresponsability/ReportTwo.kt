//package designpatterns.chainofresponsability
//
//class ReportTwo: Reports() {
//    override fun generateReport(report: String) {
//        println("Generating report TWO ! :D ")
//    }
//
//    override fun canHandle(reportName: ReportName): Boolean = reportName == ReportName.REPORT_2
//
//
//    override fun nextHandler(): Reports? = ReportThree()
//}