package br.com.alugueservice.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alugueservice.controller.PreAluguelController;
import br.com.alugueservice.dto.PreAluguelDTO;
import br.com.alugueservice.model.PreAluguel;

@Path("/PreAluguel")
public class PreAluguelWS
{
    @POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PreAluguelDTO cadastrar(PreAluguel pPreAluguel)
    {
        PreAluguelDTO tDto = PreAluguelController.cadastrar(pPreAluguel);
        // Retornando o resultado
        return tDto;
    }

    @POST
    @Path("/Atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PreAluguelDTO atualizar(PreAluguel pPreAluguel)
    {

        PreAluguelDTO tDto = PreAluguelController.atualizar(pPreAluguel);
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public PreAluguelDTO pesquisar()
    {
        PreAluguelDTO tDto = PreAluguelController.pesquisar();
        // Retornando o resultado
        return tDto;
    }
}
