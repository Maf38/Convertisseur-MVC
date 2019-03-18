/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import beans.BeanFormulaire;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gai
 */
public class Validation implements ICommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        BeanFormulaire bean = new BeanFormulaire();
        String url="";
        
        bean.setDepart(request.getParameter("depart"));
        bean.setArrivee(request.getParameter("arrivee"));
        bean.setMontant(request.getParameter("montant"));
        request.setAttribute("valider",bean);
        
        if (bean.validate()){
            url="page-resultat.jsp";
        }else{
            url="page-conversion.jsp";
        }
                
        return url;
    }
    
}
