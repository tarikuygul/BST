import java.nio.BufferUnderflowException;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    private static class BinaryNode<AnyType> {
        BinaryNode(AnyType theElement){
            this(theElement,null,null);
        }


        public BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt ) {
            element= theElement; left=lt; right=rt;
        }
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
    }
    private BinaryNode<AnyType> root;
    public BinarySearchTree(){
        root = null;
    }
    public void makeEmpty(){
        root = null;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public boolean contains(AnyType x){
        return contains(x , root );
    }
    private boolean contains(AnyType x, BinaryNode<AnyType> t ){
        if (t==null)
            return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult<0)
            return contains(x,t.left);
       else if (compareResult>0)
            return contains(x,t.right);

       else return true;
    }
    public AnyType findMin(){
        if (isEmpty() ) throw new BufferUnderflowException();
        return findMin( root ).element;
    }
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
        if (t== null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    public AnyType findMax() {
        if (isEmpty()) throw new BufferUnderflowException();
        return findMax(root).element;
    }
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
        if (t!=null)
            while (t.right!=null)
                t.right=t;
            return t;
    }
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t){
        if (t==null)
            return new BinaryNode<>(x,null,null);

        int compareResult = x.compareTo(t.element);
        if (compareResult<0)
            t.left= insert(x,t.left);
        else if (compareResult>0)
            t.right= insert(x,t.right);
        else ;
        return t;

    }
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t){
        if (t==null)
            return t;
        int compareResult = x.compareTo(t.element);
        if (compareResult<0)
            t.left= remove(x,t.left);
        else if (compareResult>0)
            t.right=remove(x,t.right);
        else if (t.left!=null && t.right!=null){
            t.element = findMax(t.right).element;
            t.right= remove(t.element,t.right);
        }
        else  t = (t.left != null) ? t.left:t.right;
        return t;




    }




}
