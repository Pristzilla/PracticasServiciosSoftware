
package es.unican.ss.SSEstimacionParadasTUS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.unican.ss.ssestimacionparadastus package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetEstimacionSiguienteBusResponse_QNAME = new QName("http://unican.es/ss/SSEstimacionParadasTUS", "getEstimacionSiguienteBusResponse");
    private final static QName _GetEstimacionSiguienteBus_QNAME = new QName("http://unican.es/ss/SSEstimacionParadasTUS", "getEstimacionSiguienteBus");
    private final static QName _DatosNoDisponiblesException_QNAME = new QName("http://unican.es/ss/SSEstimacionParadasTUS", "DatosNoDisponiblesException");
    private final static QName _ParadaNoValidaException_QNAME = new QName("http://unican.es/ss/SSEstimacionParadasTUS", "ParadaNoValidaException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.unican.ss.ssestimacionparadastus
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ParadaNoValidaException }
     * 
     */
    public ParadaNoValidaException createParadaNoValidaException() {
        return new ParadaNoValidaException();
    }

    /**
     * Create an instance of {@link GetEstimacionSiguienteBusResponse }
     * 
     */
    public GetEstimacionSiguienteBusResponse createGetEstimacionSiguienteBusResponse() {
        return new GetEstimacionSiguienteBusResponse();
    }

    /**
     * Create an instance of {@link GetEstimacionSiguienteBus }
     * 
     */
    public GetEstimacionSiguienteBus createGetEstimacionSiguienteBus() {
        return new GetEstimacionSiguienteBus();
    }

    /**
     * Create an instance of {@link DatosNoDisponiblesException }
     * 
     */
    public DatosNoDisponiblesException createDatosNoDisponiblesException() {
        return new DatosNoDisponiblesException();
    }

    /**
     * Create an instance of {@link EstimacionTUS }
     * 
     */
    public EstimacionTUS createEstimacionTUS() {
        return new EstimacionTUS();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEstimacionSiguienteBusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://unican.es/ss/SSEstimacionParadasTUS", name = "getEstimacionSiguienteBusResponse")
    public JAXBElement<GetEstimacionSiguienteBusResponse> createGetEstimacionSiguienteBusResponse(GetEstimacionSiguienteBusResponse value) {
        return new JAXBElement<GetEstimacionSiguienteBusResponse>(_GetEstimacionSiguienteBusResponse_QNAME, GetEstimacionSiguienteBusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEstimacionSiguienteBus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://unican.es/ss/SSEstimacionParadasTUS", name = "getEstimacionSiguienteBus")
    public JAXBElement<GetEstimacionSiguienteBus> createGetEstimacionSiguienteBus(GetEstimacionSiguienteBus value) {
        return new JAXBElement<GetEstimacionSiguienteBus>(_GetEstimacionSiguienteBus_QNAME, GetEstimacionSiguienteBus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosNoDisponiblesException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://unican.es/ss/SSEstimacionParadasTUS", name = "DatosNoDisponiblesException")
    public JAXBElement<DatosNoDisponiblesException> createDatosNoDisponiblesException(DatosNoDisponiblesException value) {
        return new JAXBElement<DatosNoDisponiblesException>(_DatosNoDisponiblesException_QNAME, DatosNoDisponiblesException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParadaNoValidaException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://unican.es/ss/SSEstimacionParadasTUS", name = "ParadaNoValidaException")
    public JAXBElement<ParadaNoValidaException> createParadaNoValidaException(ParadaNoValidaException value) {
        return new JAXBElement<ParadaNoValidaException>(_ParadaNoValidaException_QNAME, ParadaNoValidaException.class, null, value);
    }

}
