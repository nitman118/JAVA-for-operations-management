import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.TimeSpan;

public class ContainerGenerator extends SimProcess{
    
    TerminalModel myModel;
    int ships =0;

	public ContainerGenerator(Model owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
		myModel = (TerminalModel) owner;
	}

	public void lifeCycle() {
	    while (true) {     
	     double n = myModel.containerCountDistribution.sample();
	        for(int i =0; i< n ;i++) {
	            Container container = new Container(myModel, "Container", true);
	            container.activate(); 	            
	        }
	       ships++;
	       System.out.println(ships);
	        hold(new TimeSpan(myModel.shipInterarrivalTime.sample()));
	      }
	    
	}
}
