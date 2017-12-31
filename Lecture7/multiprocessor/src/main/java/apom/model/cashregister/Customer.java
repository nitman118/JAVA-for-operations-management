package apom.model.cashregister;

import desmoj.core.simulator.SimProcess;

public class Customer extends SimProcess{

	CashRegisterModel myModel;

	public Customer(CashRegisterModel owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
		myModel = owner;
	}

	public void lifeCycle() {
		
		myModel.queue.insert(this);

		if (!myModel.cassierQueue.isEmpty()) {
			Cassier cassier = myModel.cassierQueue.removeFirst();
			cassier.activate();
		}

		passivate();
	}

}
