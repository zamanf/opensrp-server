package org.ei.drishti.reporting.controller;

import org.ei.drishti.common.domain.ReportingData;
import org.ei.drishti.reporting.repository.ReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReportDataController {
    private ReportsRepository reportsRepository;

    @Autowired
    public ReportDataController(ReportsRepository reportsRepository) {
        this.reportsRepository = reportsRepository;
    }

    @RequestMapping(value = "/report/submit", method = RequestMethod.POST)
    @ResponseBody
    public String submit(@RequestBody ReportingData reportingData) {
        if (reportingData.type().equals("serviceProvided")) {
            reportsRepository.save(reportingData.get("anmIdentifier"), reportingData.get("externalId"),
                    reportingData.get("indicator"), reportingData.get("date"), reportingData.get("village"), reportingData.get("subCenter"), reportingData.get("phc"));
        }
        return "Success.";
    }
}
