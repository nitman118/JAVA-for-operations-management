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
			if (myModel.cassierQueue.isEmpty()) {
				isBusy = false;
				passivate();
			}else{
				Customer nextCustomer = myModel.cassierQueue.removeFirst();
				hold(new TimeSpan(myModel.cassierServiceTime.sample()));
				nextCustomer.activate();
			}
		}
	}

}
