package graph;

@SuppressWarnings("unchecked")
public class Trie<T>{

    /* Instance variables for the Trie class.
     * The root refers to the node  without a parent in the Trie.
     * The children represent a linked list that stores the children of every TrieNode.
     *
     */

    private TrieNode root;
    //public ListOfNames children = new ListOfNames();

    // --------------  NESTED TRIENODE CLASS THAT INITIALIZES THE NODES FOR THE TRIE CLASS ---------
    private class TrieNode<T>{
        private T data;
        public TrieNode leftChild;
        private TrieNode rightChild;
        private TrieNode middleChild;
        private GenericArrayList children = new GenericArrayList();
        //private List< TrieNode<T> > children;
        // Nested class constructor that takes a character as an input
        public TrieNode(T c){
            data = c;
            leftChild = null;
            rightChild = null;
            middleChild = null;


        }

        // constructor
        public TrieNode(T c, TrieNode firstChild, TrieNode secondChild, TrieNode thirdChild){
            data = c;
            leftChild = firstChild;
            middleChild = secondChild;
            rightChild = thirdChild;
        }
        public TrieNode(T c, Trie left, Trie mid, Trie right){
            data = c;
            leftChild = left.root;
            middleChild = mid.root;
            rightChild = right.root;
            root = new TrieNode(c, leftChild, middleChild, rightChild);
        }

        public boolean addChild(TrieNode child){
            if (child != null) {
                children.add(child.data);
                return true;
            }
            return false;
        }
    }
    //  -----------  END OF NESTED NODE CLASS -----------------------

    /* A constructor that accepts only a Tacter from the user and instantiates a new BinaryNode with the
     * Tacter as the root of the new tree.
     */
    public Trie(T character){
        root = new TrieNode(character);
        root.addChild(root);
    }

    // Default constructor that takes no parameter and initialises an empty trie.
    public Trie(){
        root = null;
        root.addChild(root);
    }
    // This method initialises a trie with subtries as children of the root
    public Trie(T c,Trie left, Trie mid, Trie right){
        root = new TrieNode(c, left, mid, right);
        root.addChild(root);
    }

    private boolean hasChildren(TrieNode current){
        return !current.children.isEmpty();
    }
    /*
    private boolean hasChildren(TrieNode<T> node){
         return (node.leftChild != null || node.middleChild != null || node.rightChild != null);
    }
    */
    // A method that adds characters to the root.
    public boolean addCharacter(T character){
        TrieNode node = new TrieNode(character);

        if (root.leftChild == null){
            root.leftChild = node;
            root.addChild(node);
            return true;
        }
        else if (root.middleChild == null){
            root.middleChild = node;
            root.children.add(node);
            return true;
        }
        else if (root.rightChild == null){
            root.rightChild = node;
            root.children.add(node);
            return true;
        }
        return false;
    }
    // Add subtries to the root
    public void addSubTries(T c,Trie trie1, Trie trie2, Trie trie3){
        root = null;
        root = new TrieNode(c, trie1, trie2, trie2);
    }

    public void drawTrie() {
        if (root != null)
            drawSubTrie(root, 0); // call the recursive helper method
        else
            System.out.println("The tree is empty");
    }
    public void deleteTrie() {
        // Laurrah is still editing this method
    }

    // FIND METHOD
    public int longestNumber(){
        return longestNumber(root);
    }
    public int longestNumber(TrieNode m){
        int count = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        if (m == null)
            return 0;

        if(m.leftChild == null && m.rightChild == null)
            count++;

        else if (m.leftChild != null)
            count1 = count1 + longestNumber(m.leftChild);

        else if (m.middleChild != null)
            count2 = count2 + longestNumber(m.middleChild);

        else if (m.rightChild != null)
            count3 = count3 + longestNumber(m.rightChild);

        int q = Math.max(count, count1);
        System.out.println(q);

        int p = Math.max(count2, count3);
        System.out.println(p);
        return Math.max(p, q);
    }

    // This is a delete method that removes the number in an array by converting it to null
    public boolean deleteNumber(String num){
        boolean hasDeleted = false;
        hasDeleted = deleteNumber(num, root);
        return hasDeleted;
    }

    private boolean deleteNumber(String num, TrieNode<T> node){
        boolean d = false;
        if (node.data.equals(num)){
            String deleted = "-1";
            node.data = (T) deleted;
            d = true;
            return d;
        }

        if (node.leftChild != null)
            d = deleteNumber(num, node.leftChild);

        if(node.middleChild != null)
            d = deleteNumber(num, node.middleChild);

        if(node.rightChild != null)
            d = deleteNumber(num, node.rightChild);

        return d;
    }

    public T getPossibleID(){
        T current = (T) getPossibleID(root);
        return current;
    }

    private T getPossibleID(TrieNode<T> node){
        if (node == null)
            return null;

        T number = node.data;
        System.out.print(number);

        if (hasChildren(node)){
            getPossibleID(node.leftChild);
            TrieNode<T> current = node;
            System.out.print(" ");
            if (current.middleChild !=null){
                getPossibleID(node.middleChild);
                System.out.println();
            }

            if (current.rightChild != null){
                getPossibleID(node.rightChild);
                System.out.println();
            }
        }
        else
            System.out.println();



//          getPossibleID(node.leftChild);
//          getPossibleID(node.middleChild);
//          getPossibleID(node.rightChild);
        return number;

    }

    //     public void printPreOrderTraversal() {
//        printPreOrderTraversal(root);
//        System.out.println(".");
//    }
//     public void printPreOrderTraversal(TrieNode<T> stRoot) {
//        if (stRoot != null) {
//            System.out.print(stRoot.data);
//            for (TrieNode<T> child : stRoot.children) {
//                System.out.print(", ");
//                printPreOrderTraversal(child);
//            }
//        }
//    }
    public boolean checkID(String input) {
        return checkID(root, input);

    }
    private boolean checkID(TrieNode j, String input){
        boolean idChecker = false;
        if (j == null)
            return idChecker;

        else if (j.data == input)
            idChecker = true; //return true;

        else if (j.leftChild == null && j.rightChild == null)
            return idChecker;

        else if(j.leftChild != null){
            if (j.leftChild.data == input)
                idChecker = true;
        }
        else if (j.middleChild != null){
            if (j.middleChild.data == input)
                idChecker = true;
        }
        else if (j.rightChild != null){
            if (j.rightChild.data == input)
                idChecker = true;
        }

        return idChecker;
    }










    // A private recursive helper method to draw a subtree as an
    // indented list of the descendants of this node (including itself)
    // The indentLevel parameter just tells us how much to indent when printing
    private void drawSubTrie(TrieNode curNode, int indentLevel){
        // The base case is that curNode is null, in which case we
        // don't want to do anything.  We only do something if curNode is
        // not null;
        if (curNode != null) {
            for (int i=0; i<indentLevel; i++)
                System.out.print("\t");
            System.out.println(curNode.data + " ");

            drawSubTrie(curNode.leftChild, indentLevel+1);
            drawSubTrie(curNode.middleChild, indentLevel+1);
            drawSubTrie(curNode.rightChild, indentLevel+1);
        }
    }






}
