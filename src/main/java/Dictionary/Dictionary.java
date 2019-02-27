package Dictionary;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dictionary
{
    public static void main( String[] args ) throws IOException {
        isEnglishWord("working");
    }


    public static ArrayList isEnglishWord(String str) throws IOException {

        List<String> list = Files.readAllLines( new File( "..//REI/src/main/java/Dictionary/words.txt" ).toPath(), Charset.defaultCharset() );

        List<String> lowercase = list.stream().map( s -> s.toLowerCase() ).filter( s->s.chars().allMatch(Character::isLetter)).collect( Collectors.toList() );

        System.out.println( "Read " + lowercase.size() + " words" );

        ArrayList a = new ArrayList();
        a = findOptions( str, lowercase );
        return a;

    }


    private static ArrayList findOptions( String string, List<String> lowercase ) {
        int[] freq = toFreq( string );
        ArrayList words = new ArrayList();
        for ( String l : lowercase )
        {
            int[] freqIn = toFreq( l );
            if ( matches( freq, freqIn ) )
            {
                words.add(l);
                System.out.println( l );
            }
        }
        return words;
    }

    /**
     * Returns true if all the frequencies of the letters match.
     *
     * @param freq
     * @param freqIn
     * @return
     */
    private static boolean matches( int[] freq, int[] freqIn ) {
        for ( int i = 0; i < 26; i++ )
        {
            if ( freq[i] == 0 && freqIn[i]>0)
            {
                return false;
            }
            else if (freq[i] < freqIn[i])
            {
                return false;
            }

        }
        return true;
    }

    /**
     * Encode a word in to a freqceny array. int[0] = #a's, int[1] = #b's etc.
     *
     * @param string
     * @return
     */
    private static int[] toFreq( String string ) {
        int[] freq = new int[26];
        for ( char c : string.toCharArray() )
        {
            if ( ( c - 'a' ) >= 0 && ( c - 'a' ) < 26 )
            {
                freq[c - 'a']++;
            }
        }
        return freq;
    }
}