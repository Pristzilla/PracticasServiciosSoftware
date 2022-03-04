
package es.unican.ss.volumenArea;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "VolumenAreaInterface", targetNamespace = "http://www.unican.es/ss/VolumenArea/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface VolumenAreaInterface {


    /**
     * 
     * @param params
     * @return
     *     returns double
     * @throws DatosNoValidosException
     */
    @WebMethod(action = "http://www.unican.es/ss/VolumenArea/area")
    @WebResult(name = "areaResponse", targetNamespace = "http://www.unican.es/ss/VolumenArea/types/", partName = "params")
    @Action(input = "http://www.unican.es/ss/VolumenArea/area", output = "http://www.unican.es/ss/VolumenArea/VolumenAreaInterface/areaResponse", fault = {
        @FaultAction(className = DatosNoValidosException.class, value = "http://www.unican.es/ss/VolumenArea/VolumenAreaInterface/area/Fault/DatosNoValidosException")
    })
    public double area(
        @WebParam(name = "area", targetNamespace = "http://www.unican.es/ss/VolumenArea/types/", partName = "params")
        Dimensiones params)
        throws DatosNoValidosException
    ;

    /**
     * 
     * @param params
     * @return
     *     returns double
     * @throws DatosNoValidosException
     */
    @WebMethod(action = "http://www.unican.es/ss/VolumenArea/volumen")
    @WebResult(name = "volumenResponse", targetNamespace = "http://www.unican.es/ss/VolumenArea/types/", partName = "params")
    @Action(input = "http://www.unican.es/ss/VolumenArea/volumen", output = "http://www.unican.es/ss/VolumenArea/VolumenAreaInterface/volumenResponse", fault = {
        @FaultAction(className = DatosNoValidosException.class, value = "http://www.unican.es/ss/VolumenArea/VolumenAreaInterface/volumen/Fault/DatosNoValidosException")
    })
    public double volumen(
        @WebParam(name = "volumen", targetNamespace = "http://www.unican.es/ss/VolumenArea/types/", partName = "params")
        Dimensiones params)
        throws DatosNoValidosException
    ;

}
