package apom.model.reporting;

import desmoj.core.simulator.SimProcess;

public class Customer extends SimProcess{

	CashRegisterModel myModel;
	PerformanceData myPerformanceData;

	public Customer(CashRegisterModel owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
		myModel = owner;
		//Create performance data at creation of the case
		myPerformanceData = new PerformanceData();
	}

	public void lifeCycle() {
		
		//This is the start (of the lifecycle) of the case, set the 'caseStartTime' for this moment.
		myPerformanceData.caseStartTime = myModel.presentTime().getTimeAsDouble();
		
		myModel.queue.insert(this);

		if (!myModel.cassier.isBusy) {
			myModel.cassier.isBusy = true;
			myModel.cassier.activate();
		}

		passivate();
		
		//Now the case is done. Add the performance data to the list of all performance data.
		myModel.performanceData.add(myPerformanceData);
	}

}
