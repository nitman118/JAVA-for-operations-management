package apom.model.cashregister;

import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.TimeSpan;

public class Cassier extends SimProcess{

	CashRegisterModel myModel;
	boolean isBusy;
	ProcessQueue<Customer> myQueue;

	public Cassier(CashRegisterModel owner, String name, boolean showInTrace, ProcessQueue<Customer> queue) {
		super(owner, name, showInTrace);
		myModel = owner;
		myQueue = queue;
		isBusy = false;
	}

	public void lifeCycle() {
		
		while (true){
			if (myQueue.isEmpty()) {
				isBusy = false;
				passivate();
			}else{
				Customer nextCustomer = myQueue.removeFirst();
				hold(new TimeSpan(myModel.serviceTime.sample()));
				nextCustomer.activate();
			}
		}
	}

}
