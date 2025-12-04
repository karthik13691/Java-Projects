# Java Alarm Clock

A simple console-based alarm clock application that plays an audio file when the alarm time is reached.

## Features
- Set alarm time in HH:mm:ss format
- Plays audio file when alarm triggers
- Real-time clock display
- Fallback to system beep if audio file not found

## Usage

```bash
# Compile
javac src/*.java

# Run with default audio file (alarm.wav)
java -cp src Main

# Run with custom audio file
java -cp src Main "path/to/your/audio.wav"
```

## Requirements
- Java 8 or higher
- Audio file in supported format (WAV, AIFF, AU)

## Example
```
Enter an alarm time (HH:mm:ss):
14:30:00
Alarm set for: 14:30
14:29:58
14:29:59
14:30:00
Alarm! Wake up!
```