import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import com.sun.jdi.InterfaceType;
import org.junit.Assert;
import org.junit.Test;

class BinarySearchTreeTest {
    @org.junit.jupiter.api.Test
    void add() {
        BinarySearchTree<Integer> test = new BinarySearchTree<>();
        test.add(4);
        Assert.assertEquals(true, test.contains(4));
    }
    @org.junit.jupiter.api.Test
    void locate() {
        BinaryTree<String> right = new BinaryTree<String>("Derecha");
        BinaryTree<String> left = new BinaryTree<>("Izquierda");
        BinaryTree<String> parent = new BinaryTree<>("Padre", left, right);
        BinarySearchTree<String> local = new BinarySearchTree<>();
        BinaryTree<String> cos = local.locate(parent, "Izquierda");
        Assert.assertEquals("Izquierda", cos.value());
    }


}