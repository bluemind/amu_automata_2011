package pl.edu.amu.wmi.daut.re;

import java.util.regex.Pattern;
import junit.framework.TestCase;

/**
* Klasa służąca do testowania ExtendedPosixRegexp przez porównywanie
* z wyrażeniami regularnymi w Javie.
*/
public class CompareExtendedPosixRegexpWithJavaRegexp extends TestCase {

    /**
     * Metoda która określoną liczbę razy losuje napis nad alfabetem alphabet
     * i porównuje, czy ExtendedPosixRegexp zwróci tę samą odpowiedź,
     * co wyrażenia regularne z Javy odnośnie do pasowania/niepasowania napisu.
     */
    public static void testRegexp(String regexp, String alphabet) {

        int NUMBER_OF_DRAWS = 500;
        ExtendedPosixRegexp epRegexp = new ExtendedPosixRegexp(regexp);
        boolean epRegexpMatch, javaRegexpMatch;

        for (int i = 0; i < NUMBER_OF_DRAWS; i++) {

            String text = new RandomStringGenerator(alphabet).getRandomString();
            epRegexpMatch = epRegexp.accepts(text);
            javaRegexpMatch = Pattern.matches("^(" + regexp + ")$", text);

            assertEquals(epRegexpMatch, javaRegexpMatch);
        }
        
        return;
    }
}