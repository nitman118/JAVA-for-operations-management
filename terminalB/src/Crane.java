import desmoj.core.simulator.Model; // import desmoj package
import desmoj.core.simulator.SimProcess; // import desmoj package
import desmoj.core.simulator.TimeSpan; // import desmoj package

public class Crane extends SimProcess {

    TerminalModel myModel; // class attribute

    boolean isInbound; // class attribute ( boolean to determine whether crane is processing
                       // inbound container)

    public Crane(Model owner, String name, boolean showInTrace) { // subclass constructor
        super(owner, name, showInTrace); // superclass constructor
        myModel = (TerminalModel) owner; // passing owner object to myModel (type-casted)
    }

    public void lifeCycle() { // class method dealing with life-cycle of crane
        while (true) { // infinite loop

            if (this.isInbound) { // activate 'inbound' crane if container is inbound

                if (myModel.inboundQueue.isEmpty()) { // if inbound queue is empty (i.e no
                                                      // inbound containers to process)
                    myModel.inboundCraneQueue.insert(this); // insert this crane to inbound
                                                            // crane queue ( i.e. it is idle )
                    passivate(); // sleep
                }

                else { // if inbound queue is not empty ( i.e. there are inbound containers to
                       // process )
                    Container nextInContainer = myModel.inboundQueue.removeFirst(); // remove
                                                                                    // inbound
                                                                                    // container
                                                                                    // object
                                                                                    // and
                                                                                    // assign
                                                                                    // it to
                    // 'nextInContainer'
                    nextInContainer.myContainerData.startUnloadTime = myModel.presentTime()
                            .getTimeAsDouble(); // record
                    // unload
                    // time
                    // of
                    // inbound
                    // container
                    hold((new TimeSpan(myModel.unloadTime.sample()))); // hold for a sample of
                                                                       // unload time
                    nextInContainer.myContainerData.endUnloadTime = myModel.presentTime()
                            .getTimeAsDouble(); // record
                    // time
                    // at
                    // which
                    // unloading
                    // of
                    // inbound
                    // container
                    // finished
                    nextInContainer.activate(); // activate container life-cycle
                }
            }

            else { // activate 'outbound' crane if container is outbound

                if (myModel.outboundQueue.isEmpty()) { // if out-bound container queue is empty
                    myModel.outboundCraneQueue.insert(this); // insert outbound crane into
                                                             // outboundcrane queue (i.e. idle)
                    passivate(); // sleep
                }

                else { // if out-bound container queue is not empty

                    Container nextOutContainer = myModel.outboundQueue.removeFirst(); // remove
                                                                                      // outbound
                                                                                      // container
                                                                                      // from
                                                                                      // queue
                                                                                      // and
                                                                                      // assign
                                                                                      // it to
                    // 'nextOutContainer'
                    nextOutContainer.myContainerData.startLoadTime = myModel.presentTime()
                            .getTimeAsDouble(); // record time at which outbound container
                                                // starts loading
                    hold(new TimeSpan(myModel.loadTime.sample())); // hold it for a sample of
                                                                   // load time
                    nextOutContainer.myContainerData.endLoadTime = myModel.presentTime()
                            .getTimeAsDouble(); // record time at which loading finishes
                    nextOutContainer.activate(); // activate the container life cycle (
                                                 // continues from passivate)
                }
            }
        }

    }
}
