import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.TimeSpan;

public class Container extends SimProcess {

    TerminalModel myModel;

    public Container(Model owner, String name, boolean showInTrace) {
        super(owner, name, showInTrace);
        myModel = (TerminalModel) owner;
    }

    public void lifeCycle() {
        myModel.inboundQueue.insert(this);

        if (!myModel.inboundCraneQueue.isEmpty()) {
            Crane craneIn = myModel.inboundCraneQueue.removeFirst();
            
            craneIn.activate();
        }

        passivate();

        hold(new TimeSpan(myModel.storageTime.sample()));

        myModel.outboundQueue.insert(this);

        if (!myModel.outboundCraneQueue.isEmpty()) {

            Crane craneOut = myModel.outboundCraneQueue.removeFirst();
            
            craneOut.activate();

        }

        passivate();

    }

}
