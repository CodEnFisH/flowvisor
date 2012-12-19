package org.flowvisor.message;

import org.flowvisor.classifier.FVClassifier;
import org.flowvisor.log.FVLog;
import org.flowvisor.log.LogLevel;
import org.flowvisor.slicer.FVSlicer;
import org.openflow.protocol.OFVendor;
import org.openflow.protocol.OFError.OFBadRequestCode;

public class FVVendor extends OFVendor implements Classifiable, Slicable {

	@Override
	public void classifyFromSwitch(FVClassifier fvClassifier) {
		// Just blindly forward vendor messages
		FVMessageUtil.untranslateXidAndSend(this, fvClassifier);
	}

	@Override
	public void sliceFromController(FVClassifier fvClassifier, FVSlicer fvSlicer) {
		// Just blindly forward vendor messages
		FVMessageUtil.translateXidAndSend(this, fvClassifier, fvSlicer);
	}

}
