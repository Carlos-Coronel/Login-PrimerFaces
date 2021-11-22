/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Rol;
import org.hibernate.Session;
import util.HibernateUtil;

public class RolDaoImpl implements RolDao{

    @Override
    public List<Rol> selectItems() {
        List<Rol> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "FROM Rol";
        try {
            sesion.getTransaction().begin();
            listado =  sesion.createQuery(sql).list();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            sesion.getTransaction().rollback();
        }
        return listado;
    }
}
