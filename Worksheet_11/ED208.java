// código a acrescentar em BSTree

// ED208: máximo e mínimo
// minímo
public T minValue() {
    return minValue(root);
}

private T minValue(BSTNode<T> n) {
    T ans = n.getValue();
    while (n != null) {
        ans = n.getValue();
        n = n.getLeft();
    }
    return ans;
}

// máximo
public T maxValue() {
    return maxValue(root);
}

private T maxValue(BSTNode<T> n) {
    T ans = n.getValue();
    while (n != null) {
        ans = n.getValue();
        n = n.getRight();
    }
    return ans;
}