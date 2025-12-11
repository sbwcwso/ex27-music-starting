# Music Language

A Java implementation of a little language for music composition using a variant of ABC notation. This project is based on MIT 6.031 Software Construction course materials.

## Overview

This project demonstrates the concept of "little languages" - domain-specific languages designed for a particular problem domain. The Music Language allows you to compose music using a simple text-based notation that gets compiled into playable MIDI sequences.

## Project Origin

This project is derived from MIT 6.031 Software Construction course:
- [Lecture 27: Little Languages Part 1](https://web.mit.edu/6.031/www/sp21/classes/27-little-languages-1/)

## Features

- **ABC Notation Parsing**: Parse a variant of ABC music notation
- **Music Composition**: Construct music programmatically using Java
- **MIDI Playback**: Play composed music through MIDI
- **Multiple Instruments**: Support for different musical instruments
- **Music Operations**: Concatenate, transpose, and manipulate musical pieces

## Requirements

- Java 25 or higher
- Maven 3.6+

## Building the Project

To compile the project:

```bash
mvn clean compile
```

To package the project as a JAR:

```bash
mvn package
```

## Running Examples

The project includes several example programs:

### Scale Sequence Example

```bash
mvn exec:java -Dexec.mainClass="music.examples.ScaleSequence"
```

### Scale Music Example

```bash
mvn exec:java -Dexec.mainClass="music.examples.ScaleMusic"
```

### Row Your Boat Example

```bash
mvn exec:java -Dexec.mainClass="music.examples.RowYourBoatInitial"
```

## Project Structure

```
src/main/java/music/
├── Music.java              # Main music interface
├── MusicLanguage.java      # Factory methods and notation parser
├── Note.java               # Represents a musical note
├── Rest.java               # Represents a rest (silence)
├── Concat.java             # Concatenates music pieces
├── Pitch.java              # Represents musical pitches
├── Instrument.java         # Musical instruments enumeration
├── SequencePlayer.java     # Interface for playing music sequences
├── examples/               # Example programs
│   ├── ScaleSequence.java
│   ├── ScaleMusic.java
│   └── RowYourBoatInitial.java
└── midi/                   # MIDI implementation
    ├── MidiSequencePlayer.java
    └── MusicPlayer.java
```

## Music Notation

The language supports a simplified ABC notation format:

- Notes: `C`, `D`, `E`, `F`, `G`, `A`, `B`
- Accidentals: `^` (sharp), `_` (flat), `=` (natural)
- Octaves: `,` (lower octave), `'` (higher octave)
- Duration: Numeric multipliers (e.g., `C2` for a half note, `C/2` for an eighth note)
- Rest: `z` followed by optional duration
- Measure delimiter: `|` (treated as whitespace)

### Example

```java
Music music = MusicLanguage.notes("C D E F | G A B c |", Instrument.PIANO);
```

## API Usage

### Creating Music

```java
// Create notes using the notation parser
Music scale = MusicLanguage.notes("C D E F G A B c", Instrument.PIANO);

// Or create notes programmatically
Music note = new Note(1.0, new Pitch('C'), Instrument.PIANO);
Music rest = new Rest(0.5);

// Concatenate music pieces
Music song = new Concat(note, rest);
```

### Playing Music

```java
SequencePlayer player = new MidiSequencePlayer(120, 12); // tempo=120, ticks per beat=12
music.play(player, 0.0);
player.play();
```

## License

Educational project based on MIT 6.031 course materials.

## Acknowledgments

- MIT 6.031 Software Construction course staff
- ABC notation community
