/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author CarlosJein
 */
@Named(value = "menuBean")
@RequestScoped
public class menuBean {

    /**
     * Creates a new instance of menuBean
     */
    public menuBean() {
        
    }
    public  void save(){
        addMessage("Data saved");
    }
     public  void update(){
        addMessage("Data update");
    }
      public  void delete(){
        addMessage("Data deleted");
    }

    private void addMessage(String summary) {
       FacesMessage message = new  FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
       FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
