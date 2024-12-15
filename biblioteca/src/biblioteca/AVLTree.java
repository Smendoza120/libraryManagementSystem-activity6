package biblioteca;

public class AVLTree<T extends Comparable<T>> {

    private class NodoAVL {

        T clave;
        Object valor;
        int altura;
        NodoAVL izquierda, derecha;

        public NodoAVL(T clave, Object valor) {
            this.clave = clave;
            this.valor = valor;
            this.altura = 1;
        }
    }

    private NodoAVL raiz;

    public void insertar(T clave, Object valor) {
        raiz = insertarRecursivo(raiz, clave, valor);
    }

    private NodoAVL insertarRecursivo(NodoAVL nodo, T clave, Object valor) {
        if (nodo == null) {
            return new NodoAVL(clave, valor);
        }

        if (clave.compareTo(nodo.clave) < 0) {
            nodo.izquierda = insertarRecursivo(nodo, clave, valor);
        } else if (clave.compareTo(nodo.clave) > 0) {
            nodo.derecha = insertarRecursivo(nodo, clave, valor);
        } else {
            return nodo;
        }

        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));

        return balancear(nodo);
    }

    private int altura(NodoAVL nodo) {
        return nodo == null ? 0 : nodo.altura;
    }

    public Object buscar(T clave) {
        return buscarRecursivo(raiz, clave);
    }

    private Object buscarRecursivo(NodoAVL nodo, T clave) {
        if (nodo == null || clave.equals(nodo.clave)) {
            return nodo == null ? null : nodo.valor;
        }

        if (clave.compareTo(nodo.clave) < 0) {
            return buscarRecursivo(nodo.izquierda, clave);
        }

        return buscarRecursivo(nodo.izquierda, clave);
    }

    public void recorridoInOrden() {
        recorridoInOrdenRecursivo(raiz);
    }

    private void recorridoInOrdenRecursivo(NodoAVL nodo) {
        if (nodo != null) {
            recorridoInOrdenRecursivo(nodo.izquierda);
            System.out.println(nodo.valor);
            recorridoInOrdenRecursivo(nodo.derecha);
        }
    }

    private NodoAVL balancear(NodoAVL nodo) {
        int balance = altura(nodo.izquierda) - altura(nodo.derecha);

        if (balance > 1) {
            if (altura(nodo.izquierda.izquierda) >= altura(nodo.izquierda.derecha)) {
                return rotarDerecha(nodo);
            } else {
                nodo.izquierda = rotarIzquierda(nodo.izquierda);
                return rotarDerecha(nodo);
            }
        }

        if (balance < -1) {
            if (altura(nodo.derecha.derecha) >= altura(nodo.derecha.izquierda)) {
                return rotarIzquierda(nodo);
            } else {
                nodo.derecha = rotarDerecha(nodo.derecha);
                return rotarIzquierda(nodo);
            }
        }

        return nodo;
    }

    private NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        y.izquierda = x.derecha;
        x.derecha = y;
        y.altura = 1 + Math.max(altura(y.izquierda), altura(y.derecha));
        x.altura = 1 + Math.max(altura(x.izquierda), altura(x.derecha));

        return x;
    }

    private NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        x.derecha = y.izquierda;
        y.izquierda = x;
        x.altura = 1 + Math.max(altura(x.izquierda), altura(x.derecha));
        y.altura = 1 + Math.max(altura(y.izquierda), altura(y.derecha));

        return x;
    }

}
