package apom.model.reporting;

import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.TimeSpan;

public class Cassier extends SimProcess{

	CashRegisterModel myModel;
	boolean isBusy;

	public Cassier(CashRegisterModel owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
		myModel = owner;
	}

	public void lifeCycle() {
		
		while (true){
			if (myModel.queue.isEmpty()) {
				isBusy = false;
				passivate();
			}else{
				Customer nextCustomer = myModel.queue.removeFirst();
				//This is the moment at which processing starts. Set the 'startProcessingTime' for this moment.
				nextCustomer.myPerformanceData.startProcessingTime = myModel.presentTime().getTimeAsDouble();
				hold(new TimeSpan(myModel.serviceTime.sample()));
				//This is the moment at which processing has completed. Set the 'completeProcessingTime' for this moment.
				nextCustomer.myPerformanceData.completeProcessingTime = myModel.presentTime().getTimeAsDouble();
				nextCustomer.activate();
			}
		}
	}

}
