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
}
    