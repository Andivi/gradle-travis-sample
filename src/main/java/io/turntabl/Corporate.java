package io.turntabl;

public class Corporate extends Client{
    private String accountManager;
    private String corporateName;
    private String corporateID;
    private ServiceLevel corporateServiceLevel;

    public Corporate(String corporateName, String corporateID, ServiceLevel corporateServiceLevel,String accountManager) {
        this.accountManager = accountManager;
        this.corporateName = corporateName;
        this.corporateID = corporateID;
        this.corporateServiceLevel = corporateServiceLevel;
    }


    public String getAccountManager() {
        return accountManager;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public String getCorporateID() {
        return corporateID;
    }

    public ServiceLevel getCorporateServiceLevel() {
        return corporateServiceLevel;
    }

    @Override
    public String toString() {
        return "Corporate{" +
                "accountManager='" + accountManager + '\'' +
                ", corporateName='" + corporateName + '\'' +
                ", corporateID='" + corporateID + '\'' +
                ", corporateServiceLevel=" + corporateServiceLevel +
                '}';
    }
}
