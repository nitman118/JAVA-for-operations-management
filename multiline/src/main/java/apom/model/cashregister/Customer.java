package apom.model.cashregister;

import desmoj.core.simulator.SimProcess;

public class Customer extends SimProcess{

	CashRegisterModel myModel;
	Cassier myCassier;

	public Customer(CashRegisterModel owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
		myModel = owner;
	}

	public void lifeCycle() {
		
		if (myModel.queue1.size() < myModel.queue2.size()){
			myModel.queue1.insert(this);
			myCassier = myModel.cassier1;
		}else{
			myModel.queue2.insert(this);						
			myCassier = myModel.cassier2;
		}

		if (!myCassier.isBusy) {
			myCassier.isBusy = true;
			myCassier.activate();
		}

		passivate();
	}

}
