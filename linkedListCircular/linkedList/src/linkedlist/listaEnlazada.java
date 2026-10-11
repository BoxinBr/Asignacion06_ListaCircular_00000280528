package linkedlist;

import java.util.Iterator;

public class listaEnlazada<T> implements iList<T>, Iterable<T> {

    protected nodoDoble<T> inicio;
    protected nodoDoble<T> fin;
    protected nodoDoble<T> puntero;
    protected int nElementos;

    public listaEnlazada() {
        inicio = null;
        fin = null;
        puntero = null;
        nElementos = 0;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private class nodoDoble<T> {
        
        private T dato;
        private nodoDoble<T> sig;
        private nodoDoble<T> pre;

        public nodoDoble(T dato) {
            this.dato = dato;
            this.sig = null;
            this.pre = null;
        }
    }

    @Override
    public void append(T elemento) throws ListException {
        nodoDoble<T> nodoNuevo = new nodoDoble<>(elemento);
        if (inicio == null) {
            inicio = nodoNuevo;
            fin = nodoNuevo;
            inicio.sig = inicio;
            inicio.pre = inicio;
            
        } else {
            nodoNuevo.pre = fin;
            nodoNuevo.sig = inicio;
            fin.sig = nodoNuevo;
            inicio.pre = nodoNuevo;
            fin = nodoNuevo;
        }
        
        nElementos++;
    }

    @Override
    public void insert(T elemento, int index) throws ListException {
        if (index < 0 || index > nElementos) {
            throw new ListException("El indice esta fuera del limite");
        }
        
        if (index == nElementos) {
            append(elemento);
            return;
        }
        
        nodoDoble<T> nodoNuevo = new nodoDoble<>(elemento);
        if (index == 0) {
            
            nodoNuevo.sig = inicio;
            nodoNuevo.pre = fin;
            inicio.pre = nodoNuevo;
            fin.sig = nodoNuevo;
            inicio = nodoNuevo;
            
        } else {
            nodoDoble<T> actual = inicio;
            
            for (int i = 0; i < index; i++) {
                actual = actual.sig;
            }
            
            nodoNuevo.sig = actual;
            nodoNuevo.pre = actual.pre;
            actual.pre.sig = nodoNuevo;
            actual.pre = nodoNuevo;
        }
        nElementos++;
    }

    @Override
    public T get(int index) throws ListException {
        if (index < 0 || index >= nElementos) {
            throw new ListException("El indice esta fuera del limite");
        }
        
        nodoDoble<T> actual = inicio;
        
        for (int i = 0; i < index; i++) {
            actual = actual.sig;
        }
        
        return actual.dato;
    }

    @Override
    public T remove(int index) throws ListException {
        if (index < 0 || index >= nElementos) {
            throw new ListException("El indice esta fuera del limite");
        }
        
        T elemRemovido;
        
        if (nElementos == 1) {
            elemRemovido = inicio.dato;
            inicio = null;
            fin = null;
            puntero = null;
            
        } else if (index == 0) {
            elemRemovido = inicio.dato;
            inicio = inicio.sig;
            inicio.pre = fin;
            fin.sig = inicio;
            
            if (puntero == fin.sig) {
                puntero = inicio;
            } 
            
        } else if (index == nElementos - 1) {
            elemRemovido = fin.dato;
            fin = fin.pre;
            fin.sig = inicio;
            inicio.pre = fin;
            
            if (puntero == fin.sig) {
                puntero = fin;
            } 
            
        } else {
            nodoDoble<T> actual = inicio;
            for (int i = 0; i < index; i++) {
                actual = actual.sig;
            }
            
            elemRemovido = actual.dato;
            actual.pre.sig = actual.sig;
            actual.sig.pre = actual.pre;
            
            if (puntero == actual) {
                puntero = actual.pre;
            }
        }
        
        nElementos--;
        return elemRemovido;
    }

    @Override
    public boolean empty() {
        return nElementos == 0;
    }

    @Override
    public int size() {
        return nElementos;
    }

    @Override
    public void clear() {
        inicio = null;
        fin = null;
        puntero = null;
        nElementos = 0;
    }

    @Override
    public void reverse() {
        if (nElementos <= 1) return;

        nodoDoble<T> actual = inicio;
        nodoDoble<T> temp = null;

        do {
            temp = actual.sig;
            actual.sig = actual.pre;
            actual.pre = temp;
            actual = temp;
        } while (actual != inicio);

        temp = inicio;
        inicio = fin;
        fin = temp;
    }

    @Override
    public void concatenar(listaEnlazada<T> otraLista) {
        if (otraLista == null || otraLista.nElementos == 0) {
            return;
        }

        if (this.inicio == null) {
            this.inicio = otraLista.inicio;
            this.fin = otraLista.fin;
            this.nElementos = otraLista.nElementos;
            
        } else {
            this.fin.sig = otraLista.inicio;
            otraLista.inicio.pre = this.fin;

            otraLista.fin.sig = this.inicio;
            this.inicio.pre = otraLista.fin;

            this.fin = otraLista.fin;
            this.nElementos += otraLista.nElementos;
        }

        otraLista.inicio = null;
        otraLista.fin = null;
        otraLista.nElementos = 0;
    }

    @Override
    public void irInicio() {
        puntero = inicio;
    }

    @Override
    public void irFinal() {
        puntero = fin;
    }

    @Override
    public void previo() {
        if (puntero != null) {
            puntero = puntero.pre;
        }
    }
}