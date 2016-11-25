import sofia.micro.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
// -------------------------------------------------------------------------
/**
 *  test SentimentAnaylzer
 *
 *  @author Zhennan Yao(yzhenn5)
 *  @version 2016.11.25
 */
public class SentimentAnalyzerTest extends TestCase
{
    //~ Fields ................................................................
    private SentimentAnalyzer sa;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SentimentAnaylzerTest test object.
     */
    public SentimentAnalyzerTest()
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
        sa = new SentimentAnalyzer();
    }


    // ----------------------------------------------------------
    /**
     * @test sentimentOfWord
     */
    public void testloadReviews()
    {
        Scanner s = new Scanner("4 The film has the courage of its convictions "
            + "and excellent performances on its side ."); 
        sa.loadReviews(s);
        assertEquals(4.0, sa.sentimentOfWord("excellent"), 0.1);
    }
    
    
    /**
     * @test sentimentOfWord
     */
    public void testsentimentOfWord() throws FileNotFoundException 
    {
        sa.loadReviews();
        assertEquals(3.0, sa.sentimentOfWord("excellent"), 0.1);
        assertEquals(2.0, sa.sentimentOfWord("asdasdasdsa"), 0.1);
    }
    
    /**
     * @test sentimentOf
     */
    public void testsentimentOf() throws FileNotFoundException 
    {
        sa.loadReviews();
        double temp = sa.sentimentOf("excellent excellent excellent");
        assertEquals(3.0, temp, 0.1);
        assertEquals(1.0, sa.sentimentOf("'s 123 excellent"), 0.1);
    }
    /**
     * @test show
     */
    public void testshow() throws FileNotFoundException
    {
        sa.loadReviews();
        sa.show("excellent excellent excellent");
        double  temp = sa.sentimentOf("excellent excellent excellent");
        assertEquals(3.0, temp, 0.1);
    }

}
