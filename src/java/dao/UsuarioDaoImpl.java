/*
  * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Usuario;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author lude
 */
public class UsuarioDaoImpl implements UsuarioDao{

    @Override
    public Usuario findByUsuario(Usuario usuario) {
        Usuario model = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "FROM Usuario Where usuario = '"+usuario.getUsuario()+"'";
        try { 
            sesion.getTransaction().begin();
            model = (Usuario) sesion.createQuery(sql).uniqueResult();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            sesion.getTransaction().rollback();
        }
        return model;
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario model = this.findByUsuario(usuario);
        if (model != null) {
            if (!usuario.getClave().equals(model.getClave())) {
                model = null;
            }
        }
        return model;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "FROM Usuario u left join fetch u.rol";
        try {
            sesion.getTransaction().begin();
            listado = sesion.createQuery(sql).list();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            sesion.getTransaction().rollback();
        }
        return listado;
    }

   @Override
    public boolean create(Usuario usuario) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.getTransaction().begin();
            sesion.save(usuario);
            sesion.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            sesion.getTransaction().rollback();
        }
        return flag;
    }

    @Override
    public boolean update(Usuario usuario) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.getTransaction().begin();
            Usuario usuariodb = (Usuario) sesion.load(Usuario.class, usuario.getId());
            usuariodb.setEmail(usuario.getEmail());
            usuariodb.setUsuario(usuario.getUsuario());
            usuariodb.setRol(usuario.getRol());
            usuariodb.setEstado(usuario.getEstado());
            sesion.update(usuariodb);
            sesion.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            sesion.getTransaction().rollback();
        }
        return flag;
    }
    @Override
    public boolean delete(Integer id) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.getTransaction().begin(); 
            Usuario usuario = (Usuario) sesion.load(Usuario.class, id);
            sesion.delete(usuario);
            sesion.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            sesion.getTransaction().rollback();
        }
        return flag;
    }
}