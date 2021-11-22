package model;
// Generated 15-nov-2021 16:17:38 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Menu generated by hbm2java
 */
@Entity
@Table(name="menu"
    ,catalog="aprendiendojsf"
)
public class Menu  implements java.io.Serializable {


     private Integer id;
     private Menu menu;
     private int nivel;
     private int orden;
     private String nombre;
     private String url;
     private String icono;
     private Boolean estado;
     private Set menus = new HashSet(0);
     private Set rolmenus = new HashSet(0);

    public Menu() {
    }

	
    public Menu(int nivel, int orden, String nombre) {
        this.nivel = nivel;
        this.orden = orden;
        this.nombre = nombre;
    }
    public Menu(Menu menu, int nivel, int orden, String nombre, String url, String icono, Boolean estado, Set menus, Set rolmenus) {
       this.menu = menu;
       this.nivel = nivel;
       this.orden = orden;
       this.nombre = nombre;
       this.url = url;
       this.icono = icono;
       this.estado = estado;
       this.menus = menus;
       this.rolmenus = rolmenus;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="menu_id")
    public Menu getMenu() {
        return this.menu;
    }
    
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    
    @Column(name="nivel", nullable=false)
    public int getNivel() {
        return this.nivel;
    }
    
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    
    @Column(name="orden", nullable=false)
    public int getOrden() {
        return this.orden;
    }
    
    public void setOrden(int orden) {
        this.orden = orden;
    }

    
    @Column(name="nombre", nullable=false, length=80)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="url", length=120)
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    
    @Column(name="icono", length=30)
    public String getIcono() {
        return this.icono;
    }
    
    public void setIcono(String icono) {
        this.icono = icono;
    }

    
    @Column(name="estado")
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="menu")
    public Set getMenus() {
        return this.menus;
    }
    
    public void setMenus(Set menus) {
        this.menus = menus;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="menu")
    public Set getRolmenus() {
        return this.rolmenus;
    }
    
    public void setRolmenus(Set rolmenus) {
        this.rolmenus = rolmenus;
    }




}


