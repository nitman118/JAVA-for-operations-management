package apom.model.cashregister;

import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.TimeSpan;

public class Bagger extends SimProcess{

	CashRegisterModel myModel;
	boolean isBusy;

	public Bagger(CashRegisterModel owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
		myModel = owner;
	}

	public void lifeCycle() {
		
		while (true){
			if (myModel.baggerQueue.isEmpty()) {
				isBusy = false;
				passivate();
			}else{
				Customer nextCustomer = myModel.baggerQueue.removeFirst();
				hold(new TimeSpan(myModel.baggerServiceTime.sample()));
				nextCustomer.activate();
			}
		}
	}

}
