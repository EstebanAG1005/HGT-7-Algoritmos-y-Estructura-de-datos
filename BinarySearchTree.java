import java.util.Iterator;
import java.util.Comparator;

public class BinarySearchTree<E extends Comparable<E>> {

     /**
     * A reference to the root of the tree
     */
    protected BinaryTree<E> root;

    /**
     * The node used as all leaves, in this implementation.
     */
    protected final BinaryTree<E> EMPTY = new BinaryTree<E>();

     /**
     * The number of nodes in the tree
     */ 
    protected int count;
    /**
     * The ordering used on this search tree.
     */
    protected Comparator<E> ordering;

    /**
     * Constructs a binary search tree with no data
     *
     * @post Constructs an empty binary search tree
     */
    public BinarySearchTree()
    {
        this(new NaturalComparator<E>());
    }

    /**
     * Constructs a binary search tree with no data
     *
     * @post Constructs an empty binary search tree
     */
    public BinarySearchTree(Comparator<E> alternateOrder)
    {
        root = EMPTY;
        count = 0;
        ordering = alternateOrder;
    }

    /**
     * Checks for an empty binary search tree
     *
     * @post Returns true iff the binary search tree is empty
     * 
     * @return True iff the tree contains no data
     */
    public boolean isEmpty()
    {
        return root == EMPTY;
    }
    /**
     * Removes all data from the binary search tree
     *
     * @post Removes all elements from binary search tree
     */
    public void clear()
    {
        root = new BinaryTree<E>();
        count = 0;
    }

    /**
     * Determines the number of data values within the tree
     *
     * @post Returns the number of elements in binary search tree
     * 
     * @return The number of nodes in the binary search tree
     */
    public int size()
    {
        return count;
    }
    /**
     * @pre root and value are non-null
     * @post returned: 1 - existing tree node with the desired value, or
     *                 2 - the node to which value should be added
     */
    protected BinaryTree<E> locate(BinaryTree<E> root, E value)
    {
        E rootValue = root.value();
        BinaryTree<E> child;

        // found at root: done
        if (rootValue.equals(value)) return root;
        // look left if less-than, right if greater-than
        if (ordering.compare(rootValue,value) < 0)
        {
            child = root.right();
        } else {
            child = root.left();
        }
        // no child there: not in tree, return this node,
        // else keep searching
        if (child.isEmpty()) {
            return root;
        } else {
            return locate(child, value);
        }
    }
    protected BinaryTree<E> predecessor(BinaryTree<E> root) {
        // Assert.pre(!root.isEmpty(), "No predecessor to middle value.");
        // Assert.pre(!root.left().isEmpty(), "Root has left child.");
        BinaryTree<E> result = root.left();
        while (!result.right().isEmpty()) {
            result = result.right();
        }
        return result;
    }

    protected BinaryTree<E> successor(BinaryTree<E> root) {
        // Assert.pre(!root.isEmpty(), "Tree is non-null.");
        // Assert.pre(!root.right().isEmpty(), "Root has right child.");
        BinaryTree<E> result = root.right();
        while (!result.left().isEmpty()) {
            result = result.left();
        }
        return result;
    }
    
    /**
     * Add a (possibly duplicate) value to binary search tree
     *
     * @post Adds a value to binary search tree
     * 
     * @param val A reference to non-null object
     */
    public void add(E value)
    {
        BinaryTree<E> newNode = new BinaryTree<E>(value,EMPTY,EMPTY);

        // add value to binary search tree 
        // if there's no root, create value at root
        if (root.isEmpty())
        {
            root = newNode;
        } else {
            BinaryTree<E> insertLocation = locate(root,value);
            E nodeValue = insertLocation.value();
            // The location returned is the successor or predecessor
            // of the to-be-inserted value
            if (ordering.compare(nodeValue,value) < 0) {
                insertLocation.setRight(newNode);
            } else {
                if (!insertLocation.left().isEmpty()) {
                    // if value is in tree, we insert just before
                    predecessor(insertLocation).setRight(newNode);
                } else {
                    insertLocation.setLeft(newNode);
                }
            }
        }
        count++;
    }

    public void iterator()
    {
        root.inorderIterator(this.root);
    }


}
