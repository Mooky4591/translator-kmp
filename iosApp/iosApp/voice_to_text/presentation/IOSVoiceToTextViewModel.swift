//
//  IOSVoiceToTextViewModel.swift
//  iosApp
//
//  Created by Scott Robinson on 7/16/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import shared
import Combine

@MainActor class IOSVoiceToTextViewModel: ObservableObject {
    private var parser: any VoiceToTextParser
    private let languageCode: String
    
    private let viewModel: VoiceToTextViewModel
    @Published var state = VoiceToTextState(powerRatios: [], spokenText: "", canRecord: false, recordError: nil, displayState: nil)
    private var handle: DisposableHandle?
    
    init(parser: VoiceToTextParser, languageCode: String) {
        self.parser = parser
        self.languageCode = languageCode
        self.viewModel = VoiceToTextViewModel(parser: parser, coroutineScope: nil)
    }
    
    func onEvent(event: VoiceToTextEvent) {
        viewModel.onEvent(event: event)
    }
    
    func startObserving() {
        handle = viewModel.state.subscribe { [weak self] state in
            if let state {
                self?.state = state
            }
        }
    }
    
    func dispose() {
        handle?.dispose()
        onEvent(event: VoiceToTextEvent.Reset())
    }
    
}
