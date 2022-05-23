/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rendezveny;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author upzgvz
 */
public class Event implements Serializable {
    
    private String eventName;
    private List<Performer> performerList = new ArrayList<>();
    public String bySort = "time";
  
    public Event(String rendezvenyNeve) {
        this.eventName = rendezvenyNeve;
        readObjectFromFile(); 
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public List<Performer> getPerformerList() {
        return performerList;
    }

    public void setPerformerList(List<Performer> performerList) {
        this.performerList = performerList;
    }
   
    public void addPerformer(Performer performer) {
        performerList.add(performer);
    }
    
    public void modifyPerformer(String name, String theme, int time) {
        performerList.stream().filter((p) -> (p.getName().equals(name))).map((p) -> {
            p.setTheme(theme);
            return p;
        }).forEachOrdered((p) -> {
            p.setTime(time);
        });
    }
    
    public void writeObjectToFile() {
        String fileName = eventName + ".txt";
        try {
            FileOutputStream fous = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fous);
            os.writeObject(performerList);
            os.close();
            System.out.println("The Object was succesfully written to a file");
        } catch (IOException ex) {
            System.out.println("The Object was unsuccesfull written to a file");
        }
    }
    
    public void readObjectFromFile() {
        String fileName = eventName + ".txt";
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream is = new ObjectInputStream(fis);
            performerList = (ArrayList<Performer>) is.readObject();
            is.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("the load file does not exist. Create a new file");
        }
    }

    @Override
    public String toString() {
        switch(bySort) {
            case "time"  : Collections.sort(performerList, Comparator.comparing(Performer::getTime)); break;
            case "name"  : Collections.sort(performerList, Comparator.comparing(Performer::getName)); break;
            case "theme" : Collections.sort(performerList, Comparator.comparing(Performer::getTheme)); break;
        }
        return "Event{" + "eventName=" + eventName + ", performerList=" + performerList + '}';
    }
    
}
