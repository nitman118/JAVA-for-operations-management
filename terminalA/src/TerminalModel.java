import desmoj.core.dist.ContDistExponential; // import desmoj package
import desmoj.core.dist.ContDistUniform; // import desmoj package
import desmoj.core.simulator.Model; // import desmoj package
import desmoj.core.simulator.ProcessQueue; // import desmoj package

public class TerminalModel extends Model { // Terminal Model class inherits (desmoj) Model

    ContDistExponential shipInterarrivalTime; // desmoj declaration for determining exponential
    // distribution, for ship inter arrival time
    ContDistUniform containerCountDistribution; // desmoj declaration for determining uniform
    // distribution, for container count
    ContDistUniform unloadTime; // desmoj declaration for determining
    // uniform distribution, for unload time
    ContDistUniform loadTime; // desmoj declaration for determining
    // uniform distribution, for load time
    ContDistUniform storageTime; // desmoj declaration for determining
    // uniform distribution, for storage time

    ProcessQueue<Container> inboundQueue; // desmoj queue of inbound container objects
    ProcessQueue<Container> outboundQueue; // desmoj queue of outbound container objects

    ProcessQueue<Crane> inboundCraneQueue; // desmoj queue of 'inbound' crane objects
    ProcessQueue<Crane> outboundCraneQueue; // desmoj queue of 'outbound' crane objects

    public TerminalModel(Model owner, String modelName, boolean showInReport,
            boolean showInTrace) { // subclass constructor
        super(owner, modelName, showInReport, showInTrace); // superclass constructor
    }

    public String description() { // description
        return "Model - Assignment (a)";
    }

    public void init() { // initialization method
        shipInterarrivalTime = new ContDistExponential(this, "ShipInterarrivalTime", //
                12, true, true); // exponential distribution for ship inter-arrival time,
                                 // format:
        // ( 'this' model as owner, description, mean arrival = 12 hours, show in
        // report, show in trace)
        shipInterarrivalTime.setNonNegative(true); // setting arrival time as non-negative as
                                                   // is
        // a possibility with exponential distribution

        containerCountDistribution = new ContDistUniform(this, "ContainerCount", //
                1.0, 100.0, true, true); // Uniform distribution for container count, format:
        // ( 'this' model as owner, description, minimum, maximum, show in report, show
        // in trace)

        unloadTime = new ContDistUniform(this, "UnloadTime", 0.18, 0.25, true, true); // Uniform
        // distribution for Unload Time of inbound containers, format: ( 'this' model as
        // owner,
        // description, minimum, maximum, show in report, show in trace)

        storageTime = new ContDistUniform(this, "StorageTime", 1.0, 2.0, true, true); // Uniform
        // distribution for Storage Time of containers, format: ( 'this' model as owner,
        // description, minimum, maximum, show in report, show in trace)

        loadTime = new ContDistUniform(this, "LoadTime", 0.16, 0.19, true, true); // Uniform
        // distribution for load Time of outbound containers, format: ( 'this' model as
        // owner,
        // description, minimum, maximum, show in report, show in trace)

        inboundQueue = new ProcessQueue<Container>(this, "InboundContainer", true, true); //
        // queue for inbound containers, format: ( this model object as owner,
        // description,
        // show in report, show in trace)

        outboundQueue = new ProcessQueue<Container>(this, "OutboundContainer", true, true); //
        // queue for outbound containers, format: ( this model object as owner,
        // description,
        // show in report, show in trace)

        inboundCraneQueue = new ProcessQueue<Crane>(this, "InboundCraneQueue", true, true); //
        // queue for crane for inbound containers, format: ( this model object as owner,
        // description, show in report, show in trace)

        outboundCraneQueue = new ProcessQueue<Crane>(this, "OutboundCraneQueue", true, true); //
        // queue for crane for outbound containers, format: ( this model object as
        // owner,
        // description, show in report, show in trace)
    }

    public void doInitialSchedules() { // method for defining initial schedules

        for (int i = 0; i < 2; i++) { // loop twice to generate 2 cranes for processing inbound
                                      // containers
            Crane crane = new Crane(this, "InCrane" + i, true); // create new crane object
            inboundCraneQueue.insert(crane); // insert this crane in inboundCraneQueue
        }

        for (int i = 0; i < 2; i++) { // loop twice to generate 2 cranes for processing
                                      // outbound containers
            Crane crane = new Crane(this, "OutCrane" + i, true); // create new crane object
            outboundCraneQueue.insert(crane); // insert this crane in outboundCraneQueue
        }

        ContainerGenerator generator = new ContainerGenerator(this, "Container Arrival", true); //
        // create new instance of ContainerGenerator, format ( owner model, description,
        // show in trace)
        generator.activate(); // activate generator life cycle

    }
}