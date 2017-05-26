package br.com.alugueservice.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alugueservice.controller.CupomController;
import br.com.alugueservice.dto.CupomDTO;
import br.com.alugueservice.model.Cliente;
import br.com.alugueservice.model.Cupom;
import br.com.alugueservice.model.Operador;
@Path("/Cupom")
public class CupomWS
{
    @POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CupomDTO cadastrar(Cupom pCupom)
    {
        CupomDTO tDto = CupomController.cadastrar(pCupom);
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/Recuperar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CupomDTO recuperar(@PathParam("id") int pId)
    {
        CupomDTO tDto = CupomController.recuperar(pId);
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public CupomDTO pesquisar()
    {
        CupomDTO tDto = CupomController.pesquisar();
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/PesquisarPorCliente")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CupomDTO pesquisarPorNome(Cliente pCliente)
    {
        CupomDTO tDto = CupomController.pesquisarPorCliente(pCliente);
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/PesquisarPorOperador")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CupomDTO pesquisarPorOperador(Operador pOperador)
    {
        CupomDTO tDto = CupomController.pesquisarPorOperador(pOperador);
        // Retornando o resultado
        return tDto;
    }

    @PUT
    @Path("/UsarCupom")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CupomDTO alterarStatus(Cliente pCliente)
    {
        CupomDTO tDto = CupomController.usarCupom(pCliente);
        // Retornando o resultado
        return tDto;
    }
}
