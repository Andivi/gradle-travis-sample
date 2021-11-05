package io.turntabl;

import java.rmi.server.Operation;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientRegister {

    private List<Corporate> corporateClientRegister;
    private List<Private> privateClientRegister;



    public ClientRegister(List<Corporate> corporateClientRegister, List<Private> privateClientRegister) {
        this.corporateClientRegister = corporateClientRegister;
        this.privateClientRegister = privateClientRegister;
    }

    public List<Corporate> getCorporateClientRegister() {
        return corporateClientRegister;
    }

    public List<Private> getPrivateClientRegister() {
        return privateClientRegister;
    }

    public List<Client> getNamesOfGoldClients(){
        List<Client> corporates = corporateClientRegister.stream()
                .filter(s -> s.getCorporateServiceLevel().equals(ServiceLevel.Gold))
                .collect(Collectors.toList());
        List<Client> privates = privateClientRegister.stream()
                .filter(x -> x.getPrivateServiceLevel().equals(ServiceLevel.Gold))
                .collect(Collectors.toList());
        List<Client> combinedGoldClients = Stream.of(corporates,privates)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    return combinedGoldClients;
    }

    public Optional<String> getClientName(String id){
        Optional <String> corpName= corporateClientRegister.stream().filter(s -> s.getCorporateID().equals(id)).map(Corporate::getCorporateName).findAny();
        Optional<String> privateName = privateClientRegister.stream().filter(s->s.getPrivateID().equals(id)).map(Private::getPrivateName).findAny();

        return  corpName.map(Optional::of).orElse(privateName);
    }

    public void countClientServiceLevel() {

        long corpGoldCount = corporateClientRegister.stream().filter(s -> s.getCorporateServiceLevel().equals(ServiceLevel.Gold)).count();
        long corpPlatinumCount = corporateClientRegister.stream().filter(s -> s.getCorporateServiceLevel().equals(ServiceLevel.Platinum)).count();
        long corpPremiumCount = corporateClientRegister.stream().filter(s -> s.getCorporateServiceLevel().equals(ServiceLevel.Premium)).count();
        long privateGoldCount = privateClientRegister.stream().filter(s -> s.getPrivateServiceLevel().equals(ServiceLevel.Gold)).count();
        long privatePlatinumCount = privateClientRegister.stream().filter(s -> s.getPrivateServiceLevel().equals(ServiceLevel.Platinum)).count();
        long privatePremiumCount = privateClientRegister.stream().filter(s -> s.getPrivateServiceLevel().equals(ServiceLevel.Premium)).count();
        long totalGold = corpGoldCount + privateGoldCount;
        long totalPremium = corpPremiumCount + privatePremiumCount;
        long totalPlatinum = corpPlatinumCount + privatePlatinumCount;

        System.out.println("There may be "+totalGold+" Gold clients, "+totalPlatinum+" Platinum clients, and  "+totalPremium+" Premium clients");

    }


    @Override
    public String toString() {
        return "ClientRegister{" +
                "corporateClientRegister=" + corporateClientRegister +
                ", privateClientRegister=" + privateClientRegister +
                '}';
    }
}
