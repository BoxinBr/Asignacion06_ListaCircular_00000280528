package linkedlist;

public class LinkedList {

    public static void main(String[] args) {
        listaEnlazada listaCosas = new listaEnlazada<>();
        
        listaCosas.append("Poster");
        listaCosas.insert("Pelota", 0);
        listaCosas.append("Gorra");
        listaCosas.append("Lentes");
        
        System.out.println("Elementos en la lista: " + listaCosas.size());
        for (int i = 0; i < listaCosas.size(); i++) {
            System.out.println("- " + listaCosas.get(i));
        }

        System.out.println("\nElemento removido: ");
        System.out.println(listaCosas.remove(0));
        
        System.out.println("\nTamaño de la lista: ");
        System.out.println(listaCosas.size());
        
        System.out.println("\nLista de cosas al reverso: ");
        listaCosas.reverse();
        for (int i = 0; i < listaCosas.size(); i++) {
            System.out.println("- " + listaCosas.get(i));
        }
        
        System.out.println("\nLista de frutas: ");
        listaEnlazada listaFrutas = new listaEnlazada<>();
        
        listaFrutas.append("Pera");
        listaFrutas.append("Manzana");
        listaFrutas.append("Platano");
        listaFrutas.append("Sandia");
        
        for (int i = 0; i < listaFrutas.size(); i++) {
            System.out.println("- " + listaFrutas.get(i));
        }
        
        System.out.println("\nLista de cosas concatenada con lista de frutas");
        
        listaCosas.concatenar(listaFrutas);
        
        for (int i = 0; i < listaCosas.size(); i++) {
            System.out.println("- " + listaCosas.get(i));
        }
        
        listaCosas.irInicio();
        listaCosas.irFinal();
        
        listaFrutas.irInicio();
        listaFrutas.irFinal();
        
        listaCosas.previo();
    }
    
}
