
package es.unican.ss.ssestimacionparadastus;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "EstimacionParadasTUSService", targetNamespace = "http://www.unican.es/ss/SSEstimacionParadasTUS", wsdlLocation = "http://localhost:8080/SSEstimacionParadasTUS?wsdl")
public class EstimacionParadasTUSService
    extends Service
{

    private final static URL ESTIMACIONPARADASTUSSERVICE_WSDL_LOCATION;
    private final static WebServiceException ESTIMACIONPARADASTUSSERVICE_EXCEPTION;
    private final static QName ESTIMACIONPARADASTUSSERVICE_QNAME = new QName("http://www.unican.es/ss/SSEstimacionParadasTUS", "EstimacionParadasTUSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/SSEstimacionParadasTUS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ESTIMACIONPARADASTUSSERVICE_WSDL_LOCATION = url;
        ESTIMACIONPARADASTUSSERVICE_EXCEPTION = e;
    }

    public EstimacionParadasTUSService() {
        super(__getWsdlLocation(), ESTIMACIONPARADASTUSSERVICE_QNAME);
    }

    public EstimacionParadasTUSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ESTIMACIONPARADASTUSSERVICE_QNAME, features);
    }

    public EstimacionParadasTUSService(URL wsdlLocation) {
        super(wsdlLocation, ESTIMACIONPARADASTUSSERVICE_QNAME);
    }

    public EstimacionParadasTUSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ESTIMACIONPARADASTUSSERVICE_QNAME, features);
    }

    public EstimacionParadasTUSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EstimacionParadasTUSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IEstimacionParadasTUS
     */
    @WebEndpoint(name = "EstimacionParadasTUSPort")
    public IEstimacionParadasTUS getEstimacionParadasTUSPort() {
        return super.getPort(new QName("http://www.unican.es/ss/SSEstimacionParadasTUS", "EstimacionParadasTUSPort"), IEstimacionParadasTUS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IEstimacionParadasTUS
     */
    @WebEndpoint(name = "EstimacionParadasTUSPort")
    public IEstimacionParadasTUS getEstimacionParadasTUSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.unican.es/ss/SSEstimacionParadasTUS", "EstimacionParadasTUSPort"), IEstimacionParadasTUS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ESTIMACIONPARADASTUSSERVICE_EXCEPTION!= null) {
            throw ESTIMACIONPARADASTUSSERVICE_EXCEPTION;
        }
        return ESTIMACIONPARADASTUSSERVICE_WSDL_LOCATION;
    }

}
