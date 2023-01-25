public class TermbaumPflanzer
{
    char STOP = 1;
    //als zusätzlichesEndezeichen des Eingabeterms: Keine Ziffer, kein 
    //Vorzeichen, kein Operator
    BinaryTree hatBinaryTree;
    int zPosition;
    String zTerm;
    //Konstruktor
    //Wenn der angegebene Term korrekt war, hat der TermbaumPflanzer einen
    //entsprechenden BinaryTree erstellt.
    public TermbaumPflanzer(String pTerm)
    {
        zTerm = pTerm + STOP;
        zPosition = 0;
        hatBinaryTree = this.baumAusTerm();
    }

    public BinaryTree<String> baum()
    {
        return hatBinaryTree;
    }
    // Der Rest erstellt den BinaryTree, ist daher privat.

    private char naechstesZeichen()
    {
        while(zTerm.charAt(zPosition) == ' ')
        {
            zPosition++;
        }
        return zTerm.charAt(zPosition);
    }

    private boolean istZiffer()
    {
        return this.naechstesZeichen() >= '0' && this.naechstesZeichen() <= '9';
    }

    private BinaryTree<String> baumAusTerm()
    {
        char lVorzeichen = this.naechstesZeichen();
        if (lVorzeichen== '+' || lVorzeichen == '-')
        {
            zPosition++;
        }
        BinaryTree<String> lLinkerBinaryTree = this.baumAusSummand();
        if (lVorzeichen == '-')
        {
            lLinkerBinaryTree = new BinaryTree<String>("-", new BinaryTree<String>("0"), lLinkerBinaryTree);
        }
        while (this.naechstesZeichen() == '+' || this.naechstesZeichen() == '-')
        {
            char lOperator = this.naechstesZeichen();
            zPosition++;
            BinaryTree<String> lrechterBinaryTree = this.baumAusSummand();
            if (lOperator == '+')
            {
                lLinkerBinaryTree = new BinaryTree<String>("+", lLinkerBinaryTree, lrechterBinaryTree);
            }
            else
            {
                lLinkerBinaryTree = new BinaryTree<String>("-", lLinkerBinaryTree, lrechterBinaryTree);
            }
        }
        return lLinkerBinaryTree;
    }

    private BinaryTree<String> baumAusSummand()
    {
        BinaryTree<String> lLinkerBinaryTree = this.baumAusFaktor();
        while (this.naechstesZeichen() == '*' || this.naechstesZeichen() == '/')
        {
            char lOperator = this.naechstesZeichen();
            zPosition++;
            BinaryTree<String> lrechterBinaryTree = this.baumAusFaktor();
            if (lOperator == '*')
            {
                lLinkerBinaryTree = new BinaryTree<String>("*", lLinkerBinaryTree, lrechterBinaryTree);
            }
            else
            {	
                lLinkerBinaryTree = new BinaryTree<String>("/", lLinkerBinaryTree, lrechterBinaryTree);
            }
        }
        return lLinkerBinaryTree;
    }

    private BinaryTree<String> baumAusFaktor()
    {
        if (this.istZiffer())
        {
            return new BinaryTree<String>(this.zahl());
        }
        if (this.naechstesZeichen() == '(')
        {
            zPosition++;
            BinaryTree<String> lBinaryTree = this.baumAusTerm();
            if (this.naechstesZeichen() == ')')
            {
                zPosition++;
                return lBinaryTree;
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }

    private String zahl() 
    {
        String lZahl = "";
        while(this.istZiffer())
        {
            lZahl = lZahl + this.naechstesZeichen();
            zPosition++;
        }
        if(this.naechstesZeichen() == '.')
        {
            lZahl = lZahl + this.naechstesZeichen();
            zPosition++;
            if(this.istZiffer())
            {
                while(this.istZiffer())
                {
                    lZahl = lZahl + this.naechstesZeichen();
                    zPosition++;
                }
            }
        }
        return lZahl;
    }
}