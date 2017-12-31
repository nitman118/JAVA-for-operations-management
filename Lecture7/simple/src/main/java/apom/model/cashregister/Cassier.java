package apom.model.cashregister;

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
				hold(new TimeSpan(myModel.serviceTime.sample()));
				nextCustomer.activate();
			}
		}
	}

}
