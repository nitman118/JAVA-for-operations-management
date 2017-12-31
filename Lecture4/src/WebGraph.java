import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

 public class WebGraph {
	 
	 int nodeSize=0;
	 
	 public void setNodeSize(int size){
		 this.nodeSize=size;
	 }
	 
	 public int getNodeSize(){
		 return nodeSize;
	 }
    
    public static WebGraph initFromScanner(Scanner scan) {
      
        
        WebGraph wg = new WebGraph();
        
        int n = scan.nextInt();
 
        wg.setNodeSize(n);
        
        int[][] node = new int[n+1][n+1];
        int counter=0;
         
        
        int g=0;
        
        while(g!=1){
        StringTokenizer st = new StringTokenizer(scan.nextLine());
        
        if(st.countTokens()==0)
        	g=1;
        
        int i=0;        
        while(st.hasMoreTokens()){
        	node[counter][i]=Integer.parseInt(st.nextToken());
      //  System.out.print(node[counter][i]);
        i++;
        }
             counter++;
           
           //  System.out.print("\n");
        

        }
        
        
        return wg;
        

      
    }


    
}
        
        