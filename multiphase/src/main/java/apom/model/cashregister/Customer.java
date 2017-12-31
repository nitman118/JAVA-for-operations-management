package apom.model.cashregister;

import desmoj.core.simulator.SimProcess;

public class Customer extends SimProcess{

	CashRegisterModel myModel;

	public Customer(CashRegisterModel owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
		myModel = owner;
	}

	public void lifeCycle() {
		
		myModel.cassierQueue.insert(this);

		if (!myModel.cassier.isBusy) {
			myModel.cassier.isBusy = true;
			myModel.cassier.activate();
		}

		passivate();

		myModel.baggerQueue.insert(this);

		if (!myModel.bagger.isBusy) {
			myModel.bagger.isBusy = true;
			myModel.bagger.activate();
		}

		passivate();
	}

}
