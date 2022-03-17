
package es.unican.ss.SSEstimacionParadasTUS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getEstimacionSiguienteBusResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getEstimacionSiguienteBusResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.unican.es/ss/SSEstimacionParadasTUS}estimacionTUS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEstimacionSiguienteBusResponse", propOrder = {
    "_return"
})
public class GetEstimacionSiguienteBusResponse {

    @XmlElement(name = "return")
    protected EstimacionTUS _return;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     * @return
     *     possible object is
     *     {@link EstimacionTUS }
     *     
     */
    public EstimacionTUS getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimacionTUS }
     *     
     */
    public void setReturn(EstimacionTUS value) {
        this._return = value;
    }

}
