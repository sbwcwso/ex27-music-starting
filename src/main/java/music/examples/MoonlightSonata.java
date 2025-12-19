package music.examples;

import music.*;
import music.midi.MusicPlayer;
import static music.Instrument.*;
import static music.MusicLanguage.*;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

/**
 * A short, simplified example of Beethoven's "Moonlight Sonata" (1st movement)
 * phrase.
 * This is not a full or strictly accurate transcription — it's an illustrative
 * fragment
 * written to demonstrate the MusicLanguage notation used in the course
 * examples.
 */
public class MoonlightSonata {

    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException {
        // A longer, simplified transcription of the opening of Beethoven's Moonlight
        // Sonata (1st movement).
        // This remains an approximation suitable for the simplified abc-like parser
        // used in this project.
        // Durations: 1 = quarter note. Use '/2' for eighth, '/4' for sixteenth, etc.
        Music moonlight = notes(
                // Opening arpeggiated triplet-like figure (approximated as sub-divisions)
                "^C,,/2 ^G,/4 ^C,/4 E/2 | "
                        + "^C,,/2 ^G,/4 ^C,/4 E/2 | "
                        + "^C,,/2 ^G,/4 ^C,/4 E/2 | "
                        + "^C,,/2 ^G,/4 ^C,/4 E/2 | "

                        // Continue with repeated arpeggio pattern and the famous rising melody
                        + "^C,,/2 ^G,/4 ^C,/4 E/2 | "
                        + "^C,,/2 ^G,/4 ^C,/4 E/2 | "
                        + "^C,,/2 ^G,/4 ^C,/4 E/2 | "
                        + "^C,,/2 ^G,/4 ^C,/4 E/2 | "

                        // Melody line simplified and stretched across measures
                        + "E/2 E/4 ^D3/4 ^C/4 B,/1 | "
                        + "E/2 E/4 ^D3/4 ^C/4 B,/1 | "
                        + "^G/2 ^G/4 ^F3/4 ^E/4 ^D/1 | "
                        + "E/2 E/4 ^D3/4 ^C/4 B,/1 | "

                        // A little modulation and return fragment
                        + "^C,,/2 ^G,/4 ^C,/4 E/2 | "
                        + "^C,,/2 ^G,/4 ^C,/4 E/2 | "
                        + "E/2 E/4 ^D3/4 ^C/4 B,/1 | "
                        + "E/2 E/4 ^D3/4 ^C/4 B,/1",
                PIANO);

        System.out.println(moonlight);

        MusicPlayer.play(moonlight);
    }
}
