
package es.unican.ss.SSEstimacionParadasTUS;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "DatosNoDisponiblesException", targetNamespace = "http://unican.es/ss/SSEstimacionParadasTUS")
public class DatosNoDisponiblesException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private DatosNoDisponiblesException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public DatosNoDisponiblesException_Exception(String message, DatosNoDisponiblesException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public DatosNoDisponiblesException_Exception(String message, DatosNoDisponiblesException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: es.unican.ss.ssestimacionparadastus.DatosNoDisponiblesException
     */
    public DatosNoDisponiblesException getFaultInfo() {
        return faultInfo;
    }

}