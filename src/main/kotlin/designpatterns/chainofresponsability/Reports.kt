package designpatterns.chainofresponsability


open abstract class Reports {
    open fun generateReport(report: String) {
        println("Generating report $report ! :D ")
    }

    open fun canHandle(reportName: ReportName): Boolean = true

    open fun nextHandler(): Reports? = null
}

// handler pra chamar a chain

// report interface

// report 1
// report 2
// report 3

//