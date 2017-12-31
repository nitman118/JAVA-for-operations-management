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

		if (!myModel.cassier1.isBusy) {
			myModel.cassier1.isBusy = true;
			myModel.cassier1.activate();
		}else if (!myModel.cassier2.isBusy) {
			myModel.cassier2.isBusy = true;
			myModel.cassier2.activate();
		}

		passivate();
	}

}
