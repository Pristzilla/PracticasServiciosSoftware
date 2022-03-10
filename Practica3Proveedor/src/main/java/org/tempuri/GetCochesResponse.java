
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetCochesResult" type="{http://tempuri.org/}ArrayOfInfoCoche" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCochesResult"
})
@XmlRootElement(name = "GetCochesResponse")
public class GetCochesResponse {

    @XmlElement(name = "GetCochesResult")
    protected ArrayOfInfoCoche getCochesResult;

    /**
     * Obtiene el valor de la propiedad getCochesResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInfoCoche }
     *     
     */
    public ArrayOfInfoCoche getGetCochesResult() {
        return getCochesResult;
    }

    /**
     * Define el valor de la propiedad getCochesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInfoCoche }
     *     
     */
    public void setGetCochesResult(ArrayOfInfoCoche value) {
        this.getCochesResult = value;
    }

}
