//package designpatterns.chainofresponsability
//
//class ReportOne(): Reports() {
//    override fun generateReport(report: String) {
//        println("Generating report ONE ! :D ")
//    }
//
//    override fun canHandle(reportName: ReportName): Boolean = reportName == ReportName.REPORT_1
//
//
//    override fun nextHandler(): Reports? = ReportTwo()
//}