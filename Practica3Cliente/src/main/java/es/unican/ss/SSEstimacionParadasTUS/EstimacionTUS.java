
package es.unican.ss.ssestimacionparadastus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estimacionTUS complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="estimacionTUS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estimacion1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estimacion2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "estimacionTUS", propOrder = {
    "direccion",
    "estimacion1",
    "estimacion2"
})
public class EstimacionTUS {

    protected String direccion;
    protected String estimacion1;
    protected String estimacion2;

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Obtiene el valor de la propiedad estimacion1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstimacion1() {
        return estimacion1;
    }

    /**
     * Define el valor de la propiedad estimacion1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstimacion1(String value) {
        this.estimacion1 = value;
    }

    /**
     * Obtiene el valor de la propiedad estimacion2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstimacion2() {
        return estimacion2;
    }

    /**
     * Define el valor de la propiedad estimacion2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstimacion2(String value) {
        this.estimacion2 = value;
    }

}
