import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by surendar on 25/07/2017.
 */
public class ReverseWordFinderTest extends TestCase {

    public void testProcessMessage() throws Exception {
        ReverseWordFinder reverseWordFinder = new ReverseWordFinder();
        List<String> stringList = reverseWordFinder.processMessage();
        Assert.assertEquals("was",stringList.get(4));

    }


}