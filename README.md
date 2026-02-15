# FreqENC 🔊

FreqENC is an Android application that encodes text messages into audio tones (FSK-style).
The generated sound can be transmitted over speakers and decoded using an ESP32-based receiver.

## 🚀 Features
- Encode text into audio frequencies
- Simple Android UI (Kotlin)
- Designed for ESP32 decoding via microphone + ADC
- Offline, no internet required

## 🛠️ Tech Stack
- Android Studio
- Kotlin
- AudioTrack API
- ESP32 (decoder – work in progress)
- LM358 microphone amplifier

## 📱 App Status
- Encoder: ✅ Working
- Decoder (ESP32): 🚧 In progress

## 🔗 Repository
GitHub: https://github.com/Akshith4976/freqENC

## 🧠 Concept
Each character is converted into binary and transmitted using two audio frequencies:
- `0` → low frequency
- `1` → high frequency

The ESP32 listens, detects frequencies, and reconstructs the text.

## 📌 Future Plans
- Error correction
- Better



## 📦 Download APK
Latest build:
https://github.com/Akshith4976/FreqENC/releases
