////////////////////////////////////////////////////////////////////////
//
//     Copyright (c) 2009-2014 Denim Group, Ltd.
//
//     The contents of this file are subject to the Mozilla Public License
//     Version 2.0 (the "License"); you may not use this file except in
//     compliance with the License. You may obtain a copy of the License at
//     http://www.mozilla.org/MPL/
//
//     Software distributed under the License is distributed on an "AS IS"
//     basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
//     License for the specific language governing rights and limitations
//     under the License.
//
//     The Original Code is ThreadFix.
//
//     The Initial Developer of the Original Code is Denim Group, Ltd.
//     Portions created by Denim Group, Ltd. are Copyright (C)
//     Denim Group, Ltd. All Rights Reserved.
//
//     Contributor(s): Denim Group, Ltd.
//
////////////////////////////////////////////////////////////////////////

package com.denimgroup.threadfix.cli.api2_1;

import com.denimgroup.threadfix.cli.util.JsonTestUtils;
import com.denimgroup.threadfix.cli.util.TestUtils;
import com.denimgroup.threadfix.data.entities.Application;
import com.denimgroup.threadfix.data.entities.Scan;
import com.denimgroup.threadfix.remote.response.RestResponse;
import org.junit.Test;

/**
 * Created by mcollins on 6/5/14.
 */
public class ScanTests {

    String[] scanFields = {
            "numberTotalVulnerabilities",
            "numberRepeatResults",
            "numberRepeatFindings",
            "numberOldVulnerabilities",
            "numberNewVulnerabilities",
            "numberClosedVulnerabilities",
            "numberResurfacedVulnerabilities",
            "numberInfoVulnerabilities",
            "numberLowVulnerabilities",
            "numberMediumVulnerabilities",
            "numberHighVulnerabilities",
            "numberCriticalVulneraibilities",
            "importTime",
            "scannerName",
            "id",
            "findings"
    };

    String[] scanFindingFields = {
            "nativeId",
            "displayId",
            "id",
            "sourceFileLocation",
            "calculatedUrlPath",
            "calculatedFilePath",
            "longDescription",
            "attackString",
            "attackRequest",
            "attackResponse",
            "scannerDetail",
            "scannerRecommendation",
            "rawFinding",
            "dependency",
            "surfaceLocation",
            "dataFlowElements"
    };

    @Test
    public void testScanUpload() {
        RestResponse<Application> applicationRestResponse = TestUtils.createApplication();

        String id = JsonTestUtils.getId(applicationRestResponse);

        RestResponse<Scan> scanRestResponse = TestUtils.getConfiguredClient().uploadScan(id, TestUtils.getScanPath());

        JsonTestUtils.assertHasFields(scanRestResponse, scanFields);
        JsonTestUtils.assertHasArrayOfObjectsWithFields(scanRestResponse, "findings", scanFindingFields);
    }



}
