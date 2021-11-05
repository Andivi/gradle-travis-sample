package io.turntabl;

public class Private extends Client{
    private String privateName;
    private String privateID;
    private ServiceLevel privateServiceLevel;


    public Private(String privateName, String privateID, ServiceLevel privateServiceLevel) {
        this.privateName = privateName;
        this.privateID = privateID;
        this.privateServiceLevel = privateServiceLevel;
    }

    public String getPrivateName() {
        return privateName;
    }

    public String getPrivateID() {
        return privateID;
    }

    public ServiceLevel getPrivateServiceLevel() {
        return privateServiceLevel;
    }

    @Override
    public String toString() {
        return "Private{" +
                "privateName='" + privateName + '\'' +
                ", privateID='" + privateID + '\'' +
                ", privateServiceLevel=" + privateServiceLevel +
                '}';
    }
}
