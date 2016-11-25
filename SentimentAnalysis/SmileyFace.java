import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  Smiley face class shows different face according to the score
 *
 *  @author Zhennan Yao(yzhenn5)
 *  @version 2016.11.25
 */
public class SmileyFace extends Actor
{
    //~ Fields ................................................................
    private double score;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SmileyFace object.
     */


    public SmileyFace()
    {
        this.score = 2.0;
        this.setImage("2.png");
    }
    
    
    //~ Methods ...............................................................
    /**
     * @return the current score of sentiment
     */
    public double getSentimentScore()
    {
        return score;
    }
    /**
     * @param s judge the score to determine which face is shown.
     * set the current score of sentiment
     */
    public void setSentimentScore(double s)
    {
        this.score = s;
        switch ((int)Math.round(score))
        {
            case 0:
            {
                this.setImage("0.png");
                break;
            }
            case 1:
            {
                this.setImage("1.png");
                break;
            }
            case 2:
            {
                this.setImage("2.png");
                break;
            }
            case 3:
            {
                this.setImage("3.png");
                break;
            }
            case 4:
            {
                this.setImage("4.png");
                break;
            }
            //default set image 2.
            default :
            {
                this.setImage("2.png");
            }
        }
        //this.act();
    }
    
    /**
     * @return current score is positive
     */
    public boolean isPositive()
    {
        return score >= 2.5;
    }
    
    /**
     * @return current score is negative
     */
    public boolean isNegative()
    {
        return score < 1.5;
    }
    
    /**
     * @return current score is neutral
     */
    public boolean isNeutral()
    {
        return (score < 2.5 && score >= 1.5);
    }



}
