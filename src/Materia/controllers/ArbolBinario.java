package Materia.controllers;

import Materia.models.Node;

public class ArbolBinario {

    private Node root;
    
    public ArbolBinario(){
        this.root= null;//arbol inicia sin valores
    }

    public void insert(int value){
        root= insertRec(root, value);
    }

    private Node insertRec(Node padre, int value){

        if(padre==null){
            return new Node(value);
        }

        if (value<padre.getValue()) {
            //Me voy a la izq
            //setar el nodo izquierdo para que sea padre ahora
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value>padre.getValue()) {
            //Me voy a la dere
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;//Por que tiene que retornar el padre, 2 razones preguna prueba.
        //Para una vez tenemos todos los valores puedan agregar nuevos valores, 
        //método recursivo, para que vuelva a integrarse en todos los nodos
    }
    public void imprimirArbol(){
        imprimir(root);
    }

    public void imprimir(Node node){//para imprimir en preorden
        if (node != null) {

            System.out.print(node.getValue()+",");
            imprimir(node.getLeft());
            imprimir(node.getRight());
        }
    }

    //public void imprimir(Node node){//para imprimir posorden
      //  if (node != null) {
//            imprimir(node.getLeft());
  //          System.out.print(node.getValue()+",");
      //      imprimir(node.getRight());
       // }
    //}
}
