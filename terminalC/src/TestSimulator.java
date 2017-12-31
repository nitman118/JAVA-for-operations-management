import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;

import desmoj.core.report.Message;
import desmoj.core.report.MessageReceiver;
import desmoj.core.report.Reporter;
import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.TimeInstant;

public class TestSimulator implements MessageReceiver {

    int nrMessages = 0;
    static TerminalModel model;
    static Experiment experiment;
    static TestSimulator dataCollector;

    @BeforeClass
    public static void setUpBeforeClass() {
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

    @Override
    public void receive(Message m) {
        nrMessages++;
    }

    @Override
    public void receive(Reporter r) {
    }

    @Test
    public void testWorks() {
        assertTrue("The simulation model does not do anything.", dataCollector.nrMessages > 0);
    }

    @Test
    public void testNoErrors() {
        assertFalse("The simulation model produces errors.", experiment.hasError());
    }

    @Test
    public void testRushOrdersExist() {
        assertTrue("There were never any rush orders.", model.rushOrderInboundQueue.averageLength() > 0.0);
    }

    @Test
    public void testRegularOrdersExist() {
        assertTrue("There were never any regular orders.", model.inboundQueue.averageLength() > 0.0);
    }

    @Test
    public void testArrivalTime() {
        assertTrue("The interarrival time distribution of rush orders is not configured correctly",
                model.rushOrderShipInterarrivalTime.getNonNegative());
        double totalTime = 0.0;
        for (int i = 0; i < 100; i++) {
            totalTime += model.rushOrderShipInterarrivalTime.sample();
        }
        assertTrue("The interarrival time distribution of rush orders does not produce a correct sample.",
                totalTime > 3800 && totalTime < 5800);
    }
}