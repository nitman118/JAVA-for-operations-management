import desmoj.core.simulator.Model; // import desmoj package
import desmoj.core.simulator.SimProcess; // import desmoj package
import desmoj.core.simulator.TimeSpan; // import desmoj package

public class RushOrderContainerGenerator extends SimProcess { // Rush Order Container generator
                                                              // class, inherits SimProcess

    TerminalModel myModel; // class attribute

    public RushOrderContainerGenerator(Model owner, String name, boolean showInTrace) { // subclass
        // constructor
        super(owner, name, showInTrace); // superclass constructor
        myModel = (TerminalModel) owner; // passing owner object to myModel (type-casted)
    }

    public void lifeCycle() { // class method dealing with life-cycle of container generator
        while (true) { // infinite loop
            int n = myModel.containerCountDistribution.sample().intValue(); // generate a
            // random sample
            // for container
            // count in a ship

            for (int i = 0; i < n; i++) { // generate n containers
                Container container = new Container(myModel, "Container", true); // generate
                // container
                // object
                container.isRush = true; // boolean to signify that container if of type 'rush'
                container.activate(); // activate container

            }

            hold(new TimeSpan(myModel.rushOrderShipInterarrivalTime.sample())); // hold for a
                                                                                // sample of
            // rush order ship inter-arrival
            // time
        }
    }
}
