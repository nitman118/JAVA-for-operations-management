package apom.model.reporting;

import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.TimeSpan;

public class CustomerGenerator extends SimProcess{

	CashRegisterModel myModel; 
	
	public CustomerGenerator(CashRegisterModel owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
		myModel = owner;
	}

	public void lifeCycle() {
		while (true) {			
			Customer customer = new Customer(myModel, "Customer", true);
			customer.activate();
			hold(new TimeSpan(myModel.interarrivalTime.sample()));
		}
	}
}
