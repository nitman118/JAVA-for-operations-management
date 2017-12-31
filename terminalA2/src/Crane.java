import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.TimeSpan;

public class Crane extends SimProcess {

    TerminalModel myModel;
    
    

    public Crane(Model owner, String name, boolean showInTrace) {
        super(owner, name, showInTrace);
        myModel = (TerminalModel) owner;
    }

    public void lifeCycle() {
        while (true) {

            if (this.equals(myModel.craneIn)) {

                if (myModel.inboundQueue.isEmpty()) {
                    myModel.inboundCraneQueue.insert(this);
                    passivate();
                }

                else {
                    Container nextInContainer = myModel.inboundQueue.removeFirst();
                    hold((new TimeSpan(myModel.unloadTime.sample())));
                    nextInContainer.activate();
                }
            }

            else {

                if (myModel.outboundQueue.isEmpty()) {
                    myModel.outboundCraneQueue.insert(this);
                    passivate();
                }

                else {

                    Container nextOutContainer = myModel.outboundQueue.removeFirst();
                    hold(new TimeSpan(myModel.loadTime.sample()));
                    nextOutContainer.activate();
                }
            }
        }

    }
}
