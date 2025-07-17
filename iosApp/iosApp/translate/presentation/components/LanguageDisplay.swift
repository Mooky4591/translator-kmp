//
//  LanguageDisplay.swift
//  iosApp
//
//  Created by Scott Robinson on 7/10/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct LanguageDisplay: View {
    var language: UiLanguage
    
    var body: some View {
        HStack {
            SmallLanguageIcon(language: language)
                .padding(.trailing, 5)
            Text(language.language.langName)
                .foregroundColor(.lightBlue)
        }
    }
}

#Preview {
    LanguageDisplay(
        language: UiLanguage(language: .german, imageName: "german")
    )
}
