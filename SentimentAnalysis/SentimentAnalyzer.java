import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import sofia.graphics.*;
import sofia.micro.*;
import android.graphics.*;
//-------------------------------------------------------------------------
/**
 *  A world to give a specified score of a text or word.

 *
 *  @author Zhennan Yao(yzhenn5)
 *  @version 2016.11.25
 */
public class SentimentAnalyzer extends World
{
    //~ Fields ................................................................
    private HashMap<String, WordSentiment> map;
    private SmileyFace sf = new SmileyFace();
    private TextShape ts = new TextShape("2.0");


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SentimentAnaylzer object.
     */
    public SentimentAnalyzer()
    {
        super(8, 5, 72);
        map = new HashMap<String, WordSentiment>();
        //sf.setGridX(2);
        //sf.setGridY(2);
        ts.setTypeSize(40);
        
        this.add(sf, 1, 2);
        this.add(ts, 4, 2);
    }


    //~ Methods ...............................................................
    /**
     * @return object of SmileyFace
     */
    public SmileyFace getFace()
    {
        return sf;
    }
    /**
     * @return object of TextSahpe
     */
    public TextShape getText()
    {
        return ts;
    }
    
        /**
     * @param input A scanner
     * load Reviews from a Scanner
     */
    public void loadReviews(Scanner input)
    {
        int scoresperline = 0;
        while (input.hasNextLine())
        {
            String line = input.nextLine();
            String[] temp = line.split("\\s+");
            for (int i = 0; i < temp.length; i++) 
            {
                if (i == 0)
                {
                    scoresperline = Integer.valueOf(temp[i]);
                }
                if (Character.isLetter(temp[i].charAt(0)))
                {
                    String word = temp[i];
                    if (map.containsKey(word))
                    {
                        WordSentiment ws = map.get(word);
                        ws.setCount(ws.getCount() + 1);
                        ws.setAccumulator(ws.getSumOfReviewScores() 
                            + scoresperline);
                        ws.recordOccurrence(scoresperline);
                        map.put(word, ws);
                    }
                    else 
                    {
                        WordSentiment ws = new WordSentiment();
                        ws.setCount(1);
                        ws.setAccumulator(scoresperline);
                        ws.recordOccurrence(scoresperline);
                        map.put(word, ws);
                    }
                }
            }
        }
    }
    /**
     * load reviews from default file
     */
    public void loadReviews() throws FileNotFoundException 
    {
        File fp = new File("movieReviews.txt");
        Scanner input;
        input = new Scanner(fp);
        int scoresperline = 0;
        while (input.hasNextLine())
        {
            String line = input.nextLine();
            String[] temp = line.split("\\s+");
            for (int i = 0; i < temp.length; i++) 
            {
                if (i == 0)
                {
                    scoresperline = Integer.valueOf(temp[i]);
                }
                if (Character.isLetter(temp[i].charAt(0)))
                {
                    String word = temp[i];
                    if (map.containsKey(word))
                    {
                        WordSentiment ws = map.get(word);
                        ws.setCount(ws.getCount() + 1);
                        ws.setAccumulator(ws.getSumOfReviewScores() 
                            + scoresperline);
                        ws.recordOccurrence(scoresperline);
                        map.put(word, ws);
                    }
                    else 
                    {
                        WordSentiment ws = new WordSentiment();
                        ws.setCount(1);
                        ws.setAccumulator(scoresperline);
                        ws.recordOccurrence(scoresperline);
                        map.put(word, ws);
                    }
                }
            }
        }
    }
    /**
     * @param word the word to be assessed for giving a score
     * @return Sentiment score of a word
     */
    public double sentimentOfWord(String word)
    {
        double score = 2.0;
        if (map.containsKey(word))
        {
            score = map.get(word).getSentimentScore();
        }
        return score;
    }
    /**
     * @param text a text contains some words
     * @return Sentiment score of a text
     */
    public double sentimentOf(String text)
    {
        double score = 0;
        String[] temp = text.split("\\s+");
        for (int i = 0; i < temp.length; i++) 
        {
            if (Character.isLetter(temp[i].charAt(0)))
            {
                String word = temp[i];
                score += sentimentOfWord(word);
            }
        }
        return score / temp.length;
    }
    /**
     * @param text the text is to be calculated for scores.
     * show text and smileyface on the world
     */
    public void show(String text)
    {
        double res = sentimentOf(text);
        sf.setSentimentScore(res);
        ts.setText(Double.toString(res));
    }

}
