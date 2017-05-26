package br.com.alugueservice.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alugueservice.controller.AluguelController;
import br.com.alugueservice.dto.AluguelDTO;
import br.com.alugueservice.model.Aluguel;

@Path("/Aluguel")
public class AluguelWS
{

    @POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AluguelDTO cadastrar(Aluguel pAluguel)
    {
        AluguelDTO tDto = AluguelController.cadastrar(pAluguel);
        // Retornando o resultado
        return tDto;
    }

    @POST
    @Path("/Finalizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AluguelDTO finalizar(Aluguel pAluguel)
    {
        AluguelDTO tDto = AluguelController.finalizar(pAluguel);
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public AluguelDTO pesquisar()
    {
        AluguelDTO tDto = AluguelController.pesquisar();
        // Retornando o resultado
        return tDto;
    }

}
