

public class SmallBucketCLSPSolution {

    private int nProducts;
    private int T;

    private double optimalValue;

    private double[][] q;
    private double[][] z;
    private double[][] y;
    private double[][] I;

    public SmallBucketCLSPSolution(int nProducts, int T) {
        this.nProducts = nProducts;
        this.T = T;

        this.q = new double[nProducts][T];
        this.z = new double[nProducts][T];
        this.y = new double[nProducts][T];
        this.I = new double[nProducts][T];
    } // constructor

    public void setOptimalValue(double optimalValue) {
        this.optimalValue = optimalValue;
    } // setOptimalValue

    public double getOptimalValue() {
        return this.optimalValue;
    } // getOptimalValue;

    public void setQ(int k, int t, double q) {
        this.q[k][t] = q;
    }

    public double getQ(int k, int t) {
        return this.q[k][t];
    }

    public void setZ(int k, int t, double z) {
        this.z[k][t] = z;
    }

    public double getZ(int k, int t) {
        return this.z[k][t];
    }

    public void setY(int k, int t, double y) {
        this.y[k][t] = y;
    }

    public double getY(int k, int t) {
        return this.y[k][t];
    }

    public void setI(int k, int t, double I) {
        this.I[k][t] = I;
    }

    public double getI(int k, int t) {
        return this.I[k][t];
    }

} // SmallBucketCLSPSolution
