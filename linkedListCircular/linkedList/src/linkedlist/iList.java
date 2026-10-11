package linkedlist;

import java.util.Iterator;

public interface iList<T> {
    
    public void append(T elemento) throws ListException;
    public void insert(T elemento, int index) throws ListException;
    public T get(int index) throws ListException;
    public T remove(int index) throws ListException;
    public boolean empty();
    public int size();
    public void clear();
    public void reverse();
    public void concatenar(listaEnlazada<T> otraLista);
    public void irInicio();
    public void irFinal();
    public void previo();
}
