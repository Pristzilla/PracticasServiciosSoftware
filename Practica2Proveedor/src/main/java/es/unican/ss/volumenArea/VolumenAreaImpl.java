
package es.unican.ss.volumenArea;

import javax.jws.WebService;
import javax.xml.ws.BindingType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(portName = "SOAPPort", serviceName = "VolumenArea", targetNamespace = "http://www.unican.es/ss/VolumenArea/", wsdlLocation = "http://localhost:8080/VolumenArea?wsdl", endpointInterface = "es.unican.ss.volumenArea.VolumenAreaInterface")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
public class VolumenAreaImpl
    implements VolumenAreaInterface
{


    public VolumenAreaImpl() {
    }

    /**
     * Retorna el area del objeto dado
     * 
     * @param params
     * @return
     *     returns double
     * @throws DatosNoValidosException
     */
    public double area(Dimensiones params)
        throws DatosNoValidosException
    {
        return params.getAlto()*params.getLargo();
    }

    /**
     * Retorna el volumen del objeto dado 
     * 
     * @param params
     * @return
     *     returns double
     * @throws DatosNoValidosException
     */
    public double volumen(Dimensiones params)
        throws DatosNoValidosException
    {
        return params.getAlto()*params.getAncho()*params.getLargo();
    }

}
