package apom.model.cashregister;

import java.util.concurrent.TimeUnit;

import desmoj.core.dist.ContDistExponential;
import desmoj.core.dist.ContDistUniform;
import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.TimeInstant;

public class CashRegisterModel extends Model{

	ContDistExponential interarrivalTime;
	ContDistUniform serviceTime;

	ProcessQueue<Customer> queue;
	Cassier cassier1;
	Cassier cassier2;

	public CashRegisterModel(Model owner, String modelName, boolean showInReport, boolean showInTrace) {
		super(owner, modelName, showInReport, showInTrace);
	}
	
	public String description() {
		return "You can add an arbitrary description here. It will be shown in the report.";
	}

	public void init() {
		serviceTime = new ContDistUniform(this, "ServiceTimeStream", 3.0, 7.0, true, false);
		interarrivalTime = new ContDistExponential(this, "CustomerArrivalTimeStream", 5.0, true, false);
		interarrivalTime.setNonNegative(true);

		queue = new ProcessQueue<Customer>(this, "Queue", true, true);
	}

	public void doInitialSchedules() {
		cassier1 = new Cassier(this, "Cassier1", true);		
		
		cassier2 = new Cassier(this, "Cassier2", true);		
		
		CustomerGenerator generator = new CustomerGenerator(this, "Customer Arrival", false);
		generator.activate();
	}
	
	public static void main(java.lang.String[] args) {
		CashRegisterModel model = new CashRegisterModel(null, "Cash Register", true, true);
		Experiment experiment = new Experiment("Cash Register Experiment", TimeUnit.SECONDS, TimeUnit.MINUTES, null);
		model.connectToExperiment(experiment);

		experiment.setShowProgressBar(false);
		experiment.stop(new TimeInstant(1500, TimeUnit.MINUTES));

		experiment.start();
		experiment.report();
		experiment.finish();
	}

}
