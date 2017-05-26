/**
 *
 */
package br.com.alugueservice.model;

public class StatusCliente
{

    public int idStatus;
    public String descricaoStatus;

    /**
     * @return the idStatus
     */
    public int getIdStatus()
    {
        return idStatus;
    }
    /**
     * @param pIdStatus the idStatus to set
     */
    public void setIdStatus(int pIdStatus)
    {
        idStatus = pIdStatus;
    }
    /**
     * @return the descricaoStatus
     */
    public String getDescricaoStatus()
    {
        return descricaoStatus;
    }
    /**
     * @param pDescricaoStatus the descricaoStatus to set
     */
    public void setDescricaoStatus(String pDescricaoStatus)
    {
        descricaoStatus = pDescricaoStatus;
    }
}
