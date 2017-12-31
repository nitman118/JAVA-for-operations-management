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
	ContDistUniform cassierServiceTime;
	ContDistUniform baggerServiceTime;

	ProcessQueue<Customer> cassierQueue;
	ProcessQueue<Customer> baggerQueue;
	Cassier cassier;
	Bagger bagger;

	public CashRegisterModel(Model owner, String modelName, boolean showInReport, boolean showInTrace) {
		super(owner, modelName, showInReport, showInTrace);
	}
	
	public String description() {
		return "You can add an arbitrary description here. It will be shown in the report.";
	}

	public void init() {
		cassierServiceTime = new ContDistUniform(this, "CassierServiceTimeStream", 3.0, 7.0, true, false);
		baggerServiceTime = new ContDistUniform(this, "BaggerServiceTimeStream", 4.0, 6.0, true, false);
		interarrivalTime = new ContDistExponential(this, "CustomerArrivalTimeStream", 20.0, true, false);
		interarrivalTime.setNonNegative(true);

		cassierQueue = new ProcessQueue<Customer>(this, "CassierQueue", true, true);
		baggerQueue = new ProcessQueue<Customer>(this, "BaggerQueue", true, true);
	}

	public void doInitialSchedules() {
		cassier = new Cassier(this, "Cassier", true);		
		
		bagger = new Bagger(this, "Bagger", true);
		
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
