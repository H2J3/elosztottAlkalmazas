/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rendezveny;

/**
 *
 * @author upzgvz
 */
public class EventApp {
    public static void main(String[] args) {
        Event europaiCsucs = new Event("EuropaiCsucs");
        
        europaiCsucs.addPerformer(new Performer("Nagy Lajos", "Geopolitika", 60));
        europaiCsucs.addPerformer(new Performer());
        europaiCsucs.addPerformer(new Performer("Joseph Borrel", "Külügyek Tanácsa védelem", 30));
        System.out.println(europaiCsucs);    
        europaiCsucs.writeObjectToFile();
        
        Event csucs = new Event("EuropaiCsucs");
        csucs.modifyPerformer("Nagy Lajos", "Geopolitika", 10);
        csucs.bySort = "theme";
        System.out.println(csucs);
        europaiCsucs.writeObjectToFile();

    }
}
