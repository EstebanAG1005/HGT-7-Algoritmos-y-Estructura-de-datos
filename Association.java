/**
 * Association
 * HDT#7 - Estructura de Datos
 * @author Esteban Aldana Guerra 20591
 * Referencia:
 * BTS.zip, Este fue el ejemplo dado el clase por nuestro catedratico
 */
import java.util.Map;
import java.io.*;


public class Association<K,V> implements Map.Entry<K,V>
{

    protected K theKey; //Key de la pareja Key-Value
    protected V theValor; //Value de la paraja Key-Value
    
    /**
     * 
     * @param key objeto que no es nulo
     * @param valor objeto (posiblemente nulo)
     */
    public Association(K key, V valor)
    {
        theKey = key;
        theValor = valor;
    }

    /**
     * 
     * @param key Valor de key que no es null
     */
    public Association(K key)
    {
        this(key,null);
    }

    public Association() {
    }

    /**
     * Standard comparison function.  Comparison based on keys only.
     *
     * @pre other no es nulo
     * @post regresa true si son iguales
     * @param other otra asociacion
     * @return true si los valores son iguales
     */
    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }
    
     /**
     * Funcion Standard de Hashcode
     *
     * @post Regresa la asociacion de Hashcode
     * @return Hashcode para la asociacion 
     * @see Hashtable
     */
    public int hashCode()
    {
        return getKey().hashCode();
    }
    
    /**
     * @post regresa el valor de la asociacion
     * @return el valor de la asociacion
     */
    public V getValue()
    {
        return theValor;
    }

    /**
     * @post regresa key de la asociacion
     * @return key de la pareja key-value
     */
    public K getKey()
    {
        return theKey;
    }

    /**
     * @post pone al valor de la asociacion como valor
     * @param value el nuevo valor
     */
    public V setValue(V value)
    {
        V oldValue = theValor;
        theValor = value;
        return oldValue;
    }

    /**
     * @return String representando la pareja key-value
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+getKey()+"="+getValue()+">");
        return s.toString();
    }
}