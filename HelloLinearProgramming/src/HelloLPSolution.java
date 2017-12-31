public class HelloLPSolution {

    // private int nPlants;
    private int nProducts; // number of products
    private double[] batches; // number of batches to produce, it is double as unitialized
                              // values
    // are automatically set to 0.0

    private int solutionCount; // solution count

    private double optimalValue; // to store optimal value of objective function

    private double[] shadowPrice;
    private double[] slack;
    private double[] SARHSLow; // allowable range low
    private double[] SARHSUp; // allowable range up

    public HelloLPSolution(int nPlants, int nProducts) { // constructor

        // initialize arrays and set variables

        this.nProducts = nProducts; // set nProduct's value
        batches = new double[nProducts]; // create batch array of size nProducts
    } // constructor

    public void setOptimalValue(double optimalValue) {

        this.optimalValue = optimalValue; // pass optimalValue to object of this class
    } // setOptimalValue

    public double getOptimalValue() { // method to return optimal value

        return optimalValue; // return optimal value
    } // getOptimalValue

    public void setBatchQuantity(int product, double quantity) { // method to assign batch size
        // as calculated by optimization of our LP
        batches[product] = quantity; // assign optimal batch size
    } // setBatchQuantity

    public double getBatchQuantity(int product) {

        return batches[product]; // return optimal(maximizes/minimizes objective function)
                                 // batch
        // size
    } // getBatchQuantity

    public void setShadowPrice(int plant, double shadowPrice) {

        // TODO implement
        this.shadowPrice[plant] = shadowPrice;

    } // setShadowPrice

    public double getShadowPrice(int plant) {
        //
        // // TODO implement
        return this.shadowPrice[plant];
    } // getShadowPrice

    public void setSlack(int plant, double slack) {

        this.slack[plant] = slack;

    } // setSlack

    public double getSlack(int plant) {
        //
        // // TODO implement
        return this.slack[plant];
        //
    } // getSlack

    public void setSARHSLow(int plant, double slack) {

        // TODO implement
        this.SARHSLow[plant] = slack;

    } // setSARHSLow

     public double getSARHSLow ( int plant ) {
    //
    // // TODO implement
         return this.getSARHSLow(plant);
    
    } // getSARHSLow

    public void setSARHSUp(int plant, double slack) {

        // TODO implement

        this.SARHSUp[plant]= slack;

    } // setSARHSUp

    public double getSARHSUp(int plant) {
        //
        // // TODO implement

        return this.SARHSUp[plant];
        //
    } // getSARHSUp

    public void setSolutionCount(int solutionCount) {

        this.solutionCount = solutionCount; // set solution count as calculated by Gurobi opt.
    } // setSolutionCount

    public int getSolutionCount() {

        return solutionCount; // return solution count
    } // getSolutionCount

} // HelloLPSolution
