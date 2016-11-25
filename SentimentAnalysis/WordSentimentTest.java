import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  test WordSentiment
 *
 *  @author Zhennan Yao(yzhenn5)
 *  @version 2016.11.25
 */
public class WordSentimentTest extends TestCase
{
    //~ Fields ................................................................
    private WordSentiment ws;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WordSentimentTest test object.
     */
    public WordSentimentTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        ws = new WordSentiment();
    }


    // ----------------------------------------------------------
    /**
     * @test getCount
     */
    public void testgetCount()
    {
        assertEquals(0, ws.getCount(), 0.1);
    }

    /**
     * @test getSumOfReviewScores
     */
    public void testgetSumOfReviewScores()
    {
        ws.recordOccurrence(3);
        assertEquals(3, ws.getSumOfReviewScores(), 0.1);
    }

    /**
     * @test getSentimentScore
     */
    public void testgetSentimentScore()
    {
        assertEquals(2.0, ws.getSentimentScore(), 0.1);
        ws.recordOccurrence(3);
        assertEquals(3.0, ws.getSentimentScore(), 0.1);
    }
    
    /**
     * @test getSentimentScore
     */
    public void testgetRecord()
    {
        ws.recordOccurrence(1);
        assertEquals(1, ws.getRecord(1), 0.1);
        ws.recordOccurrence(1);
        assertEquals(0, ws.getRecord(0), 0.1);
        ws.recordOccurrence(2);
        assertEquals(1, ws.getRecord(2), 0.1);
        ws.recordOccurrence(3);
        assertEquals(1, ws.getRecord(3), 0.1);
        ws.recordOccurrence(4);
        assertEquals(1, ws.getRecord(4), 0.1);
        ws.recordOccurrence(0);
        assertEquals(1, ws.getRecord(0), 0.1);
        
        assertEquals(2, ws.getRecord(1), 0.1);
    }
}
