import desmoj.core.simulator.Model; // import desmoj package
import desmoj.core.simulator.SimProcess; // import desmoj package
import desmoj.core.simulator.TimeSpan; // import desmoj package

public class Container extends SimProcess { // container class inherits SimProcess

    TerminalModel myModel; // class attribute
    ContainerMeasurement myContainerData; // create object per container to collect
                                          // measurements

    public Container(Model owner, String name, boolean showInTrace) { // subclass constructor
        super(owner, name, showInTrace); // superclass constructor
        myModel = (TerminalModel) owner; // passing owner object to myModel (type-casted)
        myContainerData = new ContainerMeasurement(); // instantiating ContainerMeasurement
                                                      // object
    }

    public void lifeCycle() { // class method dealing with life-cycle of container
        myModel.inboundQueue.insert(this); // add container to inbound queue
        myContainerData.arrivalTime = myModel.presentTime().getTimeAsDouble(); // record
                                                                               // arrival
                                                                               // time of
                                                                               // container

        if (!myModel.inboundCraneQueue.isEmpty()) { // if the crane queue for processing
                                                    // inbound
            // containers is not empty (i.e there is an
            // idle crane for processing inbound containers)
            Crane crane = myModel.inboundCraneQueue.removeFirst(); // remove first idle crane
                                                                   // from
            // queue
            crane.isInbound = true; // set boolean to true to signify that the container being
            // processed is in inbound queue
            crane.activate(); // activate crane
        }

        passivate(); // sleep

        myContainerData.startStorageTime = myModel.presentTime().getTimeAsDouble(); // record
                                                                                    // the
                                                                                    // time at
                                                                                    // which
                                                                                    // container
                                                                                    // is
                                                                                    // sent to
                                                                                    // storage

        hold(new TimeSpan(myModel.storageTime.sample())); // hold for a sample of storage time

        myContainerData.endStorageTime = myModel.presentTime().getTimeAsDouble(); // record the
                                                                                  // time
                                                                                  // at which
                                                                                  // storage
                                                                                  // time
                                                                                  // ends

        myModel.outboundQueue.insert(this); // insert container into outbound queue

        if (!myModel.outboundCraneQueue.isEmpty()) { // if outbound crane queue is not empty (
                                                     // i.e
            // there is an idle crane for processing
            // outbound containers)

            Crane crane = myModel.outboundCraneQueue.removeFirst(); // remove idle crane
            crane.isInbound = false; // signify that this is not inbound container
            crane.activate(); // activate the crane

        }

        passivate(); // sleep
        myModel.measurements.add(myContainerData); // add container data to measurements list

    }

}
