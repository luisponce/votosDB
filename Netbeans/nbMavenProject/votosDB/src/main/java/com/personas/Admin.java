
package com.personas;

/**
 *
 */
public abstract class Admin {

    public Admin(int tipo, String correo, String pass, String nombre) {
    }
    
    public abstract void IngresarAdmin(int id) throws Exception;
    
    public abstract void RetirarAdmin();
    
}
