package br.com.alugueservice.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alugueservice.controller.OperadorController;
import br.com.alugueservice.dto.OperadorDTO;
import br.com.alugueservice.model.Operador;

@Path("/Operador")
public class OperadorWS
{

    @POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public OperadorDTO cadastrar(Operador pOperador)
    {

        OperadorDTO tDto = OperadorController.cadastrar(pOperador);
        // Retornando o resultado
        return tDto;
    }

    @POST
    @Path("/Autenticar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public OperadorDTO autenticar(Operador pOperador)
    {
        OperadorDTO tDto = OperadorController.autenticar(pOperador);
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/Recuperar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public OperadorDTO recuperar(@PathParam("id") int pId)
    {
        OperadorDTO tDto = OperadorController.recuperar(pId);
        // Retornando o resultado
        return tDto;
    }

    @PUT
    @Path("/Atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public OperadorDTO atualizar(Operador pOperador)
    {
        OperadorDTO tDto = OperadorController.atualizar(pOperador);
        // Retornando o resultado
        return tDto;
    }


    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public OperadorDTO pesquisar()
    {
        OperadorDTO tDto = OperadorController.pesquisar();
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/PesquisarPorNome/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public OperadorDTO pesquisarPorNome(@PathParam("nome") String pNome)
    {
        OperadorDTO tDto = OperadorController.pesquisarPorNome(pNome);
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/PesquisarPorCpf/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public OperadorDTO pesquisarPorCpf(@PathParam("cpf") String pCpf)
    {
        OperadorDTO tDto = OperadorController.pesquisarPorCpf(pCpf);
        // Retornando o resultado
        return tDto;
    }

}
