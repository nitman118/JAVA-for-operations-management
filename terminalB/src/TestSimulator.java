import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;

import desmoj.core.report.Message;
import desmoj.core.report.MessageReceiver;
import desmoj.core.report.Reporter;
import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.TimeInstant;

public class TestSimulator implements MessageReceiver{
	
	static TerminalModel model;
	static Experiment experiment;
	static TestSimulator dataCollector;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		model = new TerminalModel(null, "Terminal Model", true, true);
		experiment = new Experiment("Terminal Experiment", TimeUnit.HOURS, TimeUnit.DAYS, null);
		model.connectToExperiment(experiment);

		experiment.setShowProgressBar(false);
		experiment.stop(new TimeInstant(1500, TimeUnit.DAYS));
		experiment.tracePeriod(new TimeInstant(0), new TimeInstant(100, TimeUnit.DAYS));
		experiment.debugPeriod(new TimeInstant(0), new TimeInstant(50, TimeUnit.DAYS));

		dataCollector = new TestSimulator();
		experiment.addTraceReceiver(dataCollector);
		
		experiment.start();
		experiment.report();
		experiment.finish();
	}
	
	public static List<ContainerMeasurement> getTestMeasurements(){
		List<ContainerMeasurement> measurements = new ArrayList<ContainerMeasurement>();
		
		ContainerMeasurement m = new ContainerMeasurement();
		m.arrivalTime = 1;
		m.startUnloadTime = 2;
		m.endUnloadTime = 3;
		m.startStorageTime = 4;
		m.endStorageTime = 5;
		m.startLoadTime = 6;
		m.endLoadTime = 7;
		m.shipIdentifier = 1;
		measurements.add(m);
		
		m = new ContainerMeasurement();
		m.arrivalTime = 1;
		m.startUnloadTime = 1;
		m.endUnloadTime = 2;
		m.startStorageTime = 3;
		m.endStorageTime = 4;
		m.startLoadTime = 4;
		m.endLoadTime = 5;
		m.shipIdentifier = 2;
		measurements.add(m);

		m = new ContainerMeasurement();
		m.arrivalTime = 3;
		m.startUnloadTime = 3;
		m.endUnloadTime = 4;
		m.startStorageTime = 5;
		m.endStorageTime = 6;
		m.startLoadTime = 7;
		m.endLoadTime = 9;
		m.shipIdentifier = 2;
		measurements.add(m);

		m = new ContainerMeasurement();
		m.arrivalTime = 4;
		m.startUnloadTime = 5;
		m.endUnloadTime = 6;
		m.startStorageTime = 6;
		m.endStorageTime = 7;
		m.startLoadTime = 7;
		m.endLoadTime = 8;
		m.shipIdentifier = 3;
		measurements.add(m);
		
		return measurements;
	}

	@Override
	public void receive(Message m) {
	}

	@Override
	public void receive(Reporter r) {
	}

	@Test
	public void testAverageCycleTime() {
		assertTrue("The average cycle time is not computed correctly.", model.computeAverageCycleTime(getTestMeasurements()) == 5.0);
	}

	@Test
	public void testNrContainers() {
		assertTrue("The number of containers that is processed is not computed correctly.", model.nrContainers(getTestMeasurements()) == 4);
	}

	@Test
	public void testNrShips() {
	    
	    
		assertTrue("The number of ships that is processed is not computed correctly.", model.nrShips(getTestMeasurements()) == 3);
	}
}