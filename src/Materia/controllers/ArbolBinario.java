package Materia.controllers;

import Materia.models.Node;

public class ArbolBinario {
    
    private Node root;
    private int weight;

    public ArbolBinario(){
        this.root = null;
        this.weight = 0;
    }

    public void insert(int value){
        root = insertRec(root, value);
        weight++;
    }

    private Node insertRec(Node padre, int value){
        if(padre == null){
            return new Node(value);
        }
        if(value < padre.getValue()){ 
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if(value > padre.getValue()){
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    } 

    public void imprimirArbol(){
        imprimirPreOrder(root);
        System.out.println();
        imprimirInOrder(root);
        System.out.println();
    }

    private void imprimirInOrder(Node node){
        if(node != null){
            imprimirInOrder(node.getLeft());
            System.out.print(node.getValue() + ", ");
            imprimirInOrder(node.getRight());
        }
    }

    public void imprimirInOrder() {
        imprimirInOrder(root);
        System.out.println();
    }

    private void imprimirPreOrder(Node node){
        if(node != null){
            System.out.print(node.getValue() + ", ");
            imprimirPreOrder(node.getLeft());
            imprimirPreOrder(node.getRight());
        }
    }

    public boolean buscar(int value){
        return buscarRec(root, value);
    }

    private boolean buscarRec(Node node, int value){
        if(node == null) return false;
        if(node.getValue() == value) return true;
        if(value < node.getValue()) return buscarRec(node.getLeft(), value);
        if(value > node.getValue()) return buscarRec(node.getRight(), value);
        return false;
    }

    public int getWeith(){
        return weight;
    }

    public int getHeight(){
        return getHeightRec(root);
    }

    private int getHeightRec(Node node){
        if(node == null) return 0;
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;        
    }

    public void imprimirInOrderConAlturas() {
        imprimirInOrderConAlturas(root);
        System.out.println();
    }

    private void imprimirInOrderConAlturas(Node node) {
        if (node != null) {
            imprimirInOrderConAlturas(node.getLeft());
            System.out.print(node.getValue() + "(h=" + getHeightRec(node) + "), ");
            imprimirInOrderConAlturas(node.getRight());
        }
    }

    public void imprimirInOrderConFactorEquilibrio() {
        imprimirInOrderConFactorEquilibrio(root);
        System.out.println();
    }

    private void imprimirInOrderConFactorEquilibrio(Node node) {
        if (node != null) {
            imprimirInOrderConFactorEquilibrio(node.getLeft());
            int bf = getBalanceFactor(node);
            System.out.print(node.getValue() + "(bf=" + bf + "), ");
            imprimirInOrderConFactorEquilibrio(node.getRight());
        }
    }

    private int getBalanceFactor(Node node) {
        if (node == null) return 0;
        return getHeightRec(node.getRight()) - getHeightRec(node.getLeft());
    }

    public boolean estaEquilibrado() {
        return estaEquilibrado(root);
    }

    private boolean estaEquilibrado(Node node) {
        if (node == null) return true;
        int bf = getBalanceFactor(node);
        if (Math.abs(bf) > 1) return false;
        return estaEquilibrado(node.getLeft()) && estaEquilibrado(node.getRight());
    }

    public void imprimirNodosDesequilibrados() {
        System.out.print("Nodos desequilibrados ");
        imprimirNodosDesequilibrados(root);
        System.out.println();
    }

    private void imprimirNodosDesequilibrados(Node node) {
        if (node != null) {
            imprimirNodosDesequilibrados(node.getLeft());
            int bf = getBalanceFactor(node);
            if (Math.abs(bf) > 1) {
                System.out.print(node.getValue() + "(fE = " + bf + ") ");
            }
            imprimirNodosDesequilibrados(node.getRight());
        }
    }
}
