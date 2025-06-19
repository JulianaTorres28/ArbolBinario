import Materia.controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Nombre: Juliana Torres");

        ArbolBinario ab = new ArbolBinario();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);

        System.out.println("Peso del arbol = " + ab.getWeith());
        System.out.println("Altura es = " + ab.getHeight());

        System.out.print("Arbol InOrder\n");
        ab.imprimirInOrder(); 

        System.out.print("\n\nArbol InOrder con alturas\n");
        ab.imprimirInOrderConAlturas();

        System.out.print("\nArbol InOrder con factor de equilibrio\n");
        ab.imprimirInOrderConFE();

        System.out.println("\nArbol esta equilibrado = " + ab.estaEquilibrado());

        System.out.println("Agregamos valor = 15");
        ab.insert(15);

        System.out.print("\nArbol InOrder con factor de equilibrio\n");
        ab.imprimirInOrderConFE();

        ab.imprimirNodosDesequilibrados();
    }
}
