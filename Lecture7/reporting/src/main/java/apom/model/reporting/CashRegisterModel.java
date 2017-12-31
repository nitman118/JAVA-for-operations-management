package apom.model.reporting;

import java.util.ArrayList;
import java.util.List;
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
	Cassier cassier;
	
	//This is the list of performance data.
	List<PerformanceData> performanceData;

	public CashRegisterModel(Model owner, String modelName, boolean showInReport, boolean showInTrace) {
		super(owner, modelName, showInReport, showInTrace);
	}
	
	public String description() {
		return "You can add an arbitrary description here. It will be shown in the report.";
	}

	public void init() {
		serviceTime = new ContDistUniform(this, "ServiceTimeStream", 3.0, 7.0, true, false);
		interarrivalTime = new ContDistExponential(this, "CustomerArrivalTimeStream", 20.0, true, false);
		interarrivalTime.setNonNegative(true);

		queue = new ProcessQueue<Customer>(this, "Queue", true, true);
		
		//This is where the list of performance data gets initialized.
		performanceData = new ArrayList<PerformanceData>();
	}

	public void doInitialSchedules() {
		cassier = new Cassier(this, "Cassier", true);
		
		CustomerGenerator generator = new CustomerGenerator(this, "Customer Arrival", false);
		generator.activate();
	}

	public Double computeAvgWaitingTime(){
		Double totalWaitingTime = 0.0;
		for (PerformanceData pd: performanceData){
			Double waitingTime = pd.startProcessingTime - pd.caseStartTime;
			totalWaitingTime = totalWaitingTime + waitingTime;
		}
		return totalWaitingTime/performanceData.size();
	}
	
	public Double computeSDWaitingTime(){
		Double avgWaitingTime = computeAvgWaitingTime();
		Double totalSquaredDifference = 0.0;
		for (PerformanceData pd: performanceData){
			Double waitingTime = pd.startProcessingTime - pd.caseStartTime;
			totalSquaredDifference = totalSquaredDifference + Math.pow(waitingTime - avgWaitingTime, 2);
		}
		return Math.sqrt(totalSquaredDifference/performanceData.size());		
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
		
		//Here, processing is done. We can now do things with the list of performance data.
		System.out.println("Average waiting time: " + model.computeAvgWaitingTime());
		System.out.println("Standard deviation waiting time: " + model.computeSDWaitingTime());
	}	

}
