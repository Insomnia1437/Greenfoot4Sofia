import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  test SmileyFace class
 *
 *  @author Zhennan Yao(yzhenn5)
 *  @version 2016.11.25
 */
public class SmileyFaceTest extends TestCase
{
    //~ Fields ................................................................
    private SmileyFace sf;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SmileyFaceTest test object.
     */
    public SmileyFaceTest()
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
        sf = new SmileyFace();
    }


    // ----------------------------------------------------------
    /**
     * @test getSentimentScore
     */
    public void testgetSentimentScore()
    {
        assertEquals(2.0, sf.getSentimentScore(), 0.1);
    }
    
    /**
     * @test setSentimentScore
     */
    public void testsetSentimentScore()
    {
        sf.setSentimentScore(0.1);
        assertEquals(0.1, sf.getSentimentScore(), 0.1);
        sf.setSentimentScore(1.1);
        assertEquals(1.1, sf.getSentimentScore(), 0.1);
        sf.setSentimentScore(2.1);
        assertEquals(2.1, sf.getSentimentScore(), 0.1);
        sf.setSentimentScore(3.1);
        assertEquals(3.1, sf.getSentimentScore(), 0.1);
        sf.setSentimentScore(4.1);
        assertEquals(4.1, sf.getSentimentScore(), 0.1);
        sf.setSentimentScore(5.1);
        assertEquals(5.1, sf.getSentimentScore(), 0.1);
    }
    /**
     * @test isPositive
     */
    public void testisPositive()
    {
        sf.setSentimentScore(3.0);
        assertTrue(sf.isPositive());
        sf.setSentimentScore(1.0);
        assertFalse(sf.isPositive());
        sf.setSentimentScore(2.5);
        assertTrue(sf.isPositive());
    }
    
    /**
     * @test isNegative
     */
    public void testisNegative()
    {
        sf.setSentimentScore(1.0);
        assertTrue(sf.isNegative());
        sf.setSentimentScore(2.5);
        assertFalse(sf.isNegative());
        sf.setSentimentScore(3.0);
        assertFalse(sf.isNegative());
    }
    /**
     * @test isNeutral
     */
    public void testisNeutral()
    {
        sf.setSentimentScore(1.0);
        assertFalse(sf.isNeutral());
        sf.setSentimentScore(2.0);
        assertTrue(sf.isNeutral());
        sf.setSentimentScore(3.0);
        assertFalse(sf.isNeutral());
    }
}
