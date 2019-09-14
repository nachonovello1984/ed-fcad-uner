package ar.edu.uner.fcad.ed.mapeosdiccionarios;

import java.util.Objects;

/**
 *
 * @author nacho
 * @param <K>
 * @param <V>
 */
public class Entrada <K, V> {
    protected K key;
    protected V value;
    
    public Entrada(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.key);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entrada<?, ?> other = (Entrada<?, ?>) obj;
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return '(' + key.toString() + ',' + value.toString() + ')';
    }
}
