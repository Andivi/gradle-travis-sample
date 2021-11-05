package io.turntabl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Corporate c1 = new Corporate("Stanbic","Stanbic2021",ServiceLevel.Gold,"John");
        Corporate c2 = new Corporate("ADB","ADB2021",ServiceLevel.Platinum,"Jane");
        Corporate c3 = new Corporate("CBG","CBG2021",ServiceLevel.Premium,"Judah");
        Corporate c4 = new Corporate("DataBank","Data2021",ServiceLevel.Gold,"Jon");
        Corporate c5 = new Corporate("Ecobank","Eco2021",ServiceLevel.Platinum,"Lily");
        Corporate c6 = new Corporate("GCB","GCB2021",ServiceLevel.Premium,"Linda");

        Private p1 = new Private("Ronaldo","CR072021",ServiceLevel.Premium);
        Private p2 = new Private("Messi","LM102021",ServiceLevel.Platinum);
        Private p3 = new Private("Suarez","LS092021",ServiceLevel.Premium);
        Private p4 = new Private("Neymar","NEY102021",ServiceLevel.Gold);
        Private p5 = new Private("Lewandowski","LEWAN102021",ServiceLevel.Platinum);
        Private p6 = new Private("Pogba","PP062021",ServiceLevel.Premium);

        List<Corporate> cR = Collections.EMPTY_LIST;
        Collections.addAll(cR = new ArrayList<>(),c1,c2,c3,c4,c5,c6 );
        List<Private>pR = Collections.EMPTY_LIST;
        Collections.addAll(pR = new ArrayList<>(),p1,p2,p3,p4,p5,p6);
        ClientRegister r1 = new ClientRegister(cR,pR);

        System.out.println(r1.getClientName("PP062021"));
        r1.countClientServiceLevel();
        System.out.println(r1.getNamesOfGoldClients());
    }
}
