import desmoj.core.dist.ContDistExponential;
import desmoj.core.dist.ContDistUniform;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.ProcessQueue;

public class TerminalModel extends Model {

    ContDistExponential shipInterarrivalTime;
    ContDistUniform containerCountDistribution;
    ContDistUniform unloadTime;
    ContDistUniform loadTime;
    ContDistUniform storageTime;

    ProcessQueue<Container> inboundQueue;
    ProcessQueue<Container> outboundQueue;

    ProcessQueue<Crane> inboundCraneQueue;
    ProcessQueue<Crane> outboundCraneQueue;
    
    Crane craneIn;
    Crane craneOut;
    

    public TerminalModel(Model owner, String modelName, boolean showInReport, boolean showInTrace) {
        super(owner, modelName, showInReport, showInTrace);
    }

    public String description() {
        return "You can add an arbitrary description here. It will be shown in the report.";
    }

    public void init() {
        shipInterarrivalTime = new ContDistExponential(this, "ShipInterarrivalTime", 12, true, true);
        shipInterarrivalTime.setNonNegative(true);

        containerCountDistribution = new ContDistUniform(this, "ContainerCount", 1.0, 100.0, true, true);

        unloadTime = new ContDistUniform(this, "UnloadTime", 0.18, 0.25, true, true);

        storageTime = new ContDistUniform(this, "StorageTime", 1.0, 2.0, true, true);

        loadTime = new ContDistUniform(this, "LoadTime", 0.16, 0.19, true, true);

        inboundQueue = new ProcessQueue<Container>(this, "InboundContainer", true, true);

        outboundQueue = new ProcessQueue<Container>(this, "OutboundContainer", true, true);

        inboundCraneQueue = new ProcessQueue<Crane>(this, "InboundCraneQueue", true, true);

        outboundCraneQueue = new ProcessQueue<Crane>(this, "OutboundCraneQueue", true, true);
    }

    public void doInitialSchedules() {
        
        for (int i = 0; i < 2; i++){
            craneIn = new Crane(this, "InCrane" + i, true);
            inboundCraneQueue.insert(craneIn);
          }
        
        for (int i = 0; i < 2; i++){
            craneOut = new Crane(this, "OutCrane" + i, true);
            outboundCraneQueue.insert(craneOut);
          }
        
        ContainerGenerator generator = new ContainerGenerator(this, "Container Arrival", true);
        generator.activate();
          
    }
}