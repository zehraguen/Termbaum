public class Termbaum
{
    BinaryTree<String> kenntBinaryTree;
    public Termbaum(BinaryTree<String> pBinaerbaum)
    {
        kenntBinaryTree = pBinaerbaum;
    }
    //Der Inhalt der Wurzel des Binärbaums wird als Zeichenkette geliefert.
    private String wurzelString(BinaryTree<String> pBinaryTree)
    {
        return pBinaryTree.getContent();
    }
    //vorher: Die Wurzel des Binärbaums enthält einen Operator.
    //nachher: Der Inhalt der Wurzel des Binärbaums wurde als Zeichen geliefert.
    public char wurzelOperator(BinaryTree<String> pBinaryTree)
    {
        return this.wurzelString(pBinaryTree).charAt(0);
    }
    //vorher: Die Wurzel des Binärbaums enthält eine Zahl.
    //nachher: Der Inhalt der Wurzel des Binärbaums wurde als Zahl vom Typ double geliefert.
    public double wurzelZahl(BinaryTree<String> pBinaryTree)
    {
        return Double.parseDouble(this.wurzelString(pBinaryTree));
    }
    //Der Wert desTermbaums wirdgeliefert.
    public double wert()
    {
        return this.wert(kenntBinaryTree);
    }

    private double wert(BinaryTree<String> pBinaryTree)
    {
        // Euer Quelltext

        return 0;
    }
    //Die Darstellung des Termbaums in umgekehrter polnischer Notation wird geliefert.
    public String inUPN()
    {
        return this.inUPN(kenntBinaryTree);
    }

    private String inUPN(BinaryTree<String> pBinaryTree)
    {
        String rueckgabe = "";
        
        if (pBinaryTree.getLeftTree () == null && pBinaryTree.getRightTree() == null)
        {
            //pBinaryTree.getContent();
        }
        else
        {
            rueckgabe = rueckgabe + inUPN(pBinaryTree.getLeftTree());
            rueckgabe = rueckgabe + inUPN(pBinaryTree.getRightTree());
            rueckgabe = rueckgabe + pBinaryTree.getContent();
        }
        return rueckgabe;
    }

    public String alsTerm()
    {
        return this.alsTerm(kenntBinaryTree);
    }

    private String alsTerm(BinaryTree<String> pBinaryTree) //in-order Traversierung
    {
        String rueckgabe = "";
        
        if (pBinaryTree.getLeftTree () == null && pBinaryTree.getRightTree() == null)
        {
            //pBinaryTree.getContent();
        }
        else
        {
            rueckgabe = rueckgabe + alsTerm(pBinaryTree.getLeftTree());
            rueckgabe = rueckgabe + pBinaryTree.getContent();
            rueckgabe = rueckgabe + alsTerm(pBinaryTree.getRightTree());
        }
        return rueckgabe;
    }
}