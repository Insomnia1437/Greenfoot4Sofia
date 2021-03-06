

//-------------------------------------------------------------------------
/**
 *  a word is associated with  score and  counts
 *
 *  @author Zhennan Yao(yzhenn5)
 *  @version 2016.11.25
 */
public class WordSentiment 
{
    //~ Fields ................................................................

    // instance fields--replace the example below with your own
   
    private int count;
    private int accumulator;
    private double score;
    private int[] occurrence;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WordSentiment object.
     */

    public WordSentiment()
    {
        this.count = 0;
        this.accumulator = 0;
        occurrence = new int[5];
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * @return count
     */
    public int getCount()
    {
        count = 0;
        for (int i = 0; i < 5; i++)
        {
            count += occurrence[i];
        }
        return count;
    }

    /**
     * @return accumulator
     */
    public int getSumOfReviewScores()
    {
        accumulator = 0;
        for (int i = 0; i < 5; i++)
        {
            accumulator += i * occurrence[i];
        }
        return accumulator;
    }
    /**
     * @return sentimentscore
     */
    public double getSentimentScore()
    {
        count = getCount();
        accumulator = getSumOfReviewScores();
        if (count == 0)
        {
            score = 2.0;
        }
        else
        {
            score = accumulator / (double)count;
        }
        return score;
    }
    /**
     * @param s the score of occurrence
     * record the occurance
     */
    public void recordOccurrence(int s)
    {
        occurrence[s] += 1;

    }
    /**
     * @param s the score of occurrence
     * @return the record the occurrence
     */
    public int getRecord(int s)
    {
        return occurrence[s];
    }
}
