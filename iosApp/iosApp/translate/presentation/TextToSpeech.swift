//
//  TextToSpeech.swift
//  iosApp
//
//  Created by Scott Robinson on 7/10/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import AVFoundation

struct TexttoSpeech {
    
    private let sytheziser: AVSpeechSynthesizer = AVSpeechSynthesizer()
    
    func speak(text: String, language: String){
        let utterance: AVSpeechUtterance = AVSpeechUtterance(string: text)
        utterance.voice = AVSpeechSynthesisVoice(language: language)
        utterance.volume = 1
        sytheziser.speak(utterance)
    }
}
