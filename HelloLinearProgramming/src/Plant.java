public class Plant { // programmer-defined class

    private int nProducts; // number of products for production
    private double APT; // available production time in plant, in the model denoted as c_f
    private double[] PTPB; // production time per batch, in the model denoted as t_i,f

    public Plant(int nProducts, double APT) { // constructor

        assert (nProducts > 0); // check for non-negativity for number of products
        this.nProducts = nProducts; // assigning passed value to instantiated object's parameter
        this.APT = APT; // assigning passed value to instantiated object's parameter
        PTPB = new double[nProducts]; // create a new array of size = number of products
    } // constructor

    public void setAvailableProductionTime(double APT) {
        assert (APT > 0); // check for non-negativity for APT
        this.APT = APT; // assigning passed value to instantiated object's parameter

    } // setAvailableProductionTime

    public double getAvailableProductionTime() {
        assert (APT > 0); // check for non-negativity for APT
        return APT; // return APT

    } // setAvailableProductionTime

    public void setProductionTimePerBatch(int product, double PT) { // sets prod time
        assert (this.nProducts > product); // check for non-negativity for number of products
        PTPB[product] = PT; // assign production time per batch, unitialized times are
        // automatically set to 0.0
    } // setProductionTimePerBatch

    public double getProductionTimePerBatch(int product) {
        assert (this.nProducts > product); // assertion
        return PTPB[product]; // return PTPB

    } // getProductionTimePerBatch

} // Plant
