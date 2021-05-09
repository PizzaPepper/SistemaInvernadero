/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import DAO.DAOSensor;
import Dominio.Sensor;
import java.util.Calendar;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("Sensor")
public class SensorResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SensorResource
     */
    public SensorResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSensores() {
        List<Sensor> us = new DAOSensor().consultarTodos();
        if (us != null) {
            return Response.status(200).entity(us).build();
        } else {
            return Response.status(404).entity("<h1>ERROR! hubo un error en la peticion</h1>").type(MediaType.TEXT_HTML).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getSensor(@PathParam("id") int id) {
        Sensor us = new DAOSensor().consultarID(id);
        if (us != null) {
            return Response.status(200).entity(us).build();
        } else {
            return Response.status(404).entity("<h1>ERROR! no existe la entidad</h1>").type(MediaType.TEXT_HTML).build();
        }
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSensor(Sensor json) {
        try {
            json.getFecha().add(Calendar.DAY_OF_MONTH, -1);
            new DAOSensor().guardar(json);
            return Response.status(200).entity("AGREGADO").build();
        } catch (Exception e) {
            return Response.status(404).entity("<h1>ERROR DE LA BASE DE DATOS</h1>").type(MediaType.TEXT_HTML).build();
        }

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uptdateSensor(Sensor json) {
         try {
            new DAOSensor().actualizar(json);
            return Response.status(200).entity("ACTUALIZADO").build();
        } catch (Exception e) {
            return Response.status(404).entity("<h1>ERROR DE LA BASE DE DATOS</h1>").type(MediaType.TEXT_HTML).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response deleteSensor(@PathParam("id") int id) {
         try {
            new DAOSensor().eliminar(id);
            return Response.status(200).entity("ELIMINADO").build();
        } catch (Exception e) {
            return Response.status(404).entity("<h1>ERROR DE LA BASE DE DATOS</h1>").type(MediaType.TEXT_HTML).build();
        }
    }
}
