package org.ei.drishti.service.reporting;

import org.ei.drishti.common.domain.Indicator;
import org.ei.drishti.domain.Location;
import org.ei.drishti.domain.Mother;
import org.ei.drishti.form.domain.FormSubmission;
import org.ei.drishti.repository.AllMothers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.ei.drishti.common.AllConstants.CommonFormFields.SUBMISSION_DATE_FIELD_NAME;

@Component
public class MotherReporter implements IReporter {

    private MotherReportingService motherReportingService;
    private AllMothers allMothers;

    @Autowired
    public MotherReporter(MotherReportingService motherReportingService, AllMothers allMothers) {
        this.motherReportingService = motherReportingService;
        this.allMothers = allMothers;
    }

    @Override
    public void report(FormSubmission submission, String reportIndicator, Location location) {
        Mother mother = allMothers.findByCaseId(submission.entityId());
        motherReportingService.reportToBoth(mother, Indicator.from(reportIndicator), submission.getField(SUBMISSION_DATE_FIELD_NAME), location);
    }
}