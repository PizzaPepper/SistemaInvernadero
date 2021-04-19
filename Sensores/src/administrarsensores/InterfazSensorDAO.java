/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrarsensores;

import Dominio.Sensor;
import java.util.ArrayList;

public interface InterfazSensorDAO {
    public ArrayList<Sensor> listar();
    public Sensor getId(int id);
    public void Agregar(Sensor s);
    public void Actualizar(Sensor s);
    public void Eliminar(Sensor s);
}
