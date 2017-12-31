import desmoj.core.simulator.Model; // import desmoj package
import desmoj.core.simulator.SimProcess; // import desmoj package
import desmoj.core.simulator.TimeSpan; // import desmoj package

public class ContainerGenerator extends SimProcess { // Container generator class, inherits
    // SimProcess

    TerminalModel myModel; // class attribute
    int ships = 0; // class attribute to count ships

    public ContainerGenerator(Model owner, String name, boolean showInTrace) { // subclass
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
                container.myContainerData.shipIdentifier = ships; // add ship number to
                                                                  // container data
                container.activate(); // activate container

            }
            ships++; // increment ship

            hold(new TimeSpan(myModel.shipInterarrivalTime.sample())); // hold for a sample of
                                                                       // ship inter-arrival
                                                                       // time
        }

    }
}
