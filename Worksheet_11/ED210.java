// Colocar o seguinte código dentro do BSTree

// ED210 - Será uma árvore de pesquisa?
private boolean searchAllLeft(BSTNode<T> n, T k) {
    if (n == null) {return true;}
    if (k.compareTo(n.getValue()) < 0) {return false;}
    return searchAllLeft(n.getLeft(), k) && searchAllLeft(n.getRight(), k);
}

private boolean searchAllRight(BSTNode<T> n, T k) {
    if (n == null) {return true;}
    if (k.compareTo(n.getValue()) > 0) {return false;}
    return searchAllRight(n.getLeft(), k) && searchAllRight(n.getRight(), k);
}

public boolean valid() {
    return valid(root);
}

private boolean valid(BSTNode<T> n) {
    if (n == null) {return true;} //caso base

    T k = n.getValue();
    if (searchAllLeft(n.getLeft(), k) == false) {return false;}
    if (searchAllRight(n.getRight(), k) == false) {return false;}

    return valid(n.getLeft()) && valid(n.getRight());
}