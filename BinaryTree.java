/**
 * BinaryTree
 * HDT#7 - Estructura de Datos
 * @author Esteban Aldana Guerra 20591
 * Refrencia de codigo:
 * BTS.zip, Este fue el ejemplo dado el clase por nuestro catedratico
 */

public class BinaryTree<E> {
     /**
     * Valor asociado al nodo
     */
    protected E val;
    /**
     * Padre del nodo (parent), los hijos del nodo (left, right)
     */
    protected BinaryTree<E> parent,left,right;
    public Object root;

    /**
     * Se crea Un arbol vacio
     */
	public BinaryTree() {
		// Se genera un nodo vacio.
		
		val = null;
		parent = null;
		left=right=this;
	}
	/**
     * 
     * @post Regresa un arbol con referencia al valor y dos sub arboles vacios
     * @param valor Valor de referencia al nodo (puede ser null)
     */
	public BinaryTree(E valor) {
		val = valor;
		right=left= new BinaryTree<E>();
		setLeft(left);
		setRight(right);
		
	}
    /**
     * 
     * @param valor Valor de referencia al nodo (puede ser null)
     * @param left Sub-Arbol a la izquierda del nodo
     * @param right Sub-arbol a la derecha del nodo
     */
	public BinaryTree(E valor, BinaryTree<E> left, BinaryTree<E> right) {
		val=valor;
		if(left==null){
			left = new BinaryTree<E>();
		}
		
		setLeft(left);
		
		if(right == null){
			right = new BinaryTree<E>();
		}
		
		setRight(right);
		
	}
	/**
     * 
     * @return el lado izquierdo del nodo
     */
	public BinaryTree<E> left(){
		
		return left;
		
	}
	/**
     * 
     * @return referencia al padre del nodo
     */
	public BinaryTree<E> parent(){
		
		return parent;
	}
	/**
     * 
     * @return el lado derecho del nodo
     */
	public BinaryTree<E> right(){
		
		return right;
		
	}
	/**
     * 
     * @param newLeft el path del nuevo sub arbol a la izquierda 
     */
	public void setLeft(BinaryTree<E> newLeft){
		
		if(isEmpty()){
			return;
		}
		if (left != null && left.parent() == this){
			left.setParent(null);
			left = newLeft;
			left.setParent(this);
		}
	}
	/**
     * 
     * @param newRight el path del nuevo sub arbol a la derecha
     */
	public void setRight(BinaryTree<E> newRight){
		
		if(isEmpty()){
			return;
		}
		if (right != null && right.parent() == this){
			right.setParent(null);
			right = newRight;
			right.setParent(this);
		}
	}
	/**
     * 
     * @param newParent referencia al nuevo padre del nodo
     */
	public void setParent(BinaryTree<E> newParent){
		if (!isEmpty()){
			parent=newParent;
		}
	}
	/**
     * Returns the number of descendants of node
     *
     * @post Returns the size of the subtree
     * @return Size of subtree
     */
    public int size()
    {
        if (isEmpty()) return 0;
        return left().size() + right().size() + 1;
    }

    /**
     * Returns reference to root of tree containing n
     *
     * @post Returns the root of the tree node n
     * @return Root of tree
     */
    public BinaryTree<E> root()
    {
        if (parent() == null) return this;
        else return parent().root();
    }
	/**
     * Determine if this node is a left child
     *
     * @post Returns true if this is a left child of parent
     * 
     * @return True iff this node is a left child of parent
     */
    public boolean isLeftChild()
    {
        if (parent() == null) return false;
        return this == parent().left();
    }

    /**
     * Determine if this node is a right child
     *
     * @post Returns true if this is a right child of parent
     * 
     * @return True iff this node is a right child of parent
     */
    public boolean isRightChild()
    {
        if (parent() == null) return false;
        return this == parent().right();
    }
	
	/**
     * 
     * @return valor del nodo
     */
	public E value(){
		return val;
		
	}
    /**
     * 
     * @param valor nuevo valor del nodo
     */
	public void setValue(E valor){
		val=valor;
	}
	public int depth()
    {
        if (parent() == null) return 0;
        return 1 + parent.depth();
    }
	/**
	 * 
	 * @return
	 */
	public String treeString(){
        String s = "";
        for (int i=0; i < this.depth(); i++){
            s += "\t|";
        }
        
        s += ("<" + val + " : " + getHand() + ">\n");
        
        if (!left.isEmpty()) s += left.treeString();
        if (!right.isEmpty()) s += right.treeString();

        return s;
    }
	/**
     * Support method for {@link #toString}. Returns R if this is node 
     * is a right child, L if this node is a left child and Root if this
     * node is the root.
     * 
     * @return R if this is node 
     * is a right child, L if this node is a left child and Root if this
     * node is the root.
     */
    private String getHand(){
        if (isRightChild()) return "R";
        if (isLeftChild()) return "L";
        return "Root";  
    }
	/**
     * Returns a representation the subtree rooted at this node
     *
     * @post Returns string representation
     * 
     * @return String representing this subtree
     */
    public String toString()
    {
        if (isEmpty()) return "<BinaryTree: empty>";
        StringBuffer s = new StringBuffer();
        s.append("<BinaryTree "+value());
        if (!left().isEmpty()) s.append(" "+left());
        else s.append(" -");
        if (!right().isEmpty()) s.append(" "+right());
        else s.append(" -");
        s.append('>');
        return s.toString();
    }
    /**
     * 
     * @return true si el arbol esta vacio 
     */
	public boolean isEmpty(){
		boolean empty=false;
		if(parent==null)
			empty=true;
		else
			return empty;
		return empty;
		
	}
	public void inorderIterator(BinaryTree<E> nod) {
        if (nod.isEmpty())
            return;

        /* recorrer todos los del lado derecho */
        inorderIterator(nod.left());

        /* imprimir la información del nodo */
        System.out.print(nod.value() + " ");

        /* recorrer todos los del lado derecho */
        inorderIterator(nod.right());
    }
}
    