/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rendezveny;

import java.io.Serializable;

/**
 *
 * @author upzgvz
 */
public class Performer implements Serializable {
    private String Name;
    private String theme;
    private int time;
    
    public Performer() {
        this.Name = "konfer";
        this.theme = "átvezető";
        this.time = 1;
    }

    public Performer(String nev, String tema, int ido) {
        this.Name = nev;
        this.theme = tema;
        this.time = ido;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Eloado{" + "nev=" + Name + ", tema=" + theme + ", ido=" + time + " perc" + '}';
    }
    
    
    
}
