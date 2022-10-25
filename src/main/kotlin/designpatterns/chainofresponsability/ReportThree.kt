//package designpatterns.chainofresponsability
//
//class ReportThree: Reports {
//    override fun generateReport(report: String) {
//        println("Generating report TWO ! :D ")
//    }
//
//    override fun canHandle(reportName: ReportName): Boolean = reportName == ReportName.REPORT_3
//
//
//    override fun nextHandler(): Reports? = null
//}