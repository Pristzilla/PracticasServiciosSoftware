
package es.unican.ss.SSEstimacionParadasTUS;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ParadaNoValidaException", targetNamespace = "http://unican.es/ss/SSEstimacionParadasTUS")
public class ParadaNoValidaException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ParadaNoValidaException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ParadaNoValidaException_Exception(String message, ParadaNoValidaException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ParadaNoValidaException_Exception(String message, ParadaNoValidaException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: es.unican.ss.ssestimacionparadastus.ParadaNoValidaException
     */
    public ParadaNoValidaException getFaultInfo() {
        return faultInfo;
    }

}