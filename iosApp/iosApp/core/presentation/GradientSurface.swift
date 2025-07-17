//
//  GradientSurface.swift
//  iosApp
//
//  Created by Scott Robinson on 7/10/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct GradientSurface: ViewModifier {
    @Environment(\.colorScheme) var colorScheme

    @ViewBuilder
    func body(content: Content) -> some View {
        if colorScheme == .dark {
            content.background(
                LinearGradient(
                    gradient: Gradient(colors: [
                        Color(hex: 0xFF23262E),
                        Color(hex: 0xFF212329)
                    ]),
                    startPoint: .top,
                    endPoint: .bottom
                )
            )
        } else {
            content.background(Color.surface)
        }
    }
}


extension View {
    func gradientSurface () -> some View {
        modifier(GradientSurface())
    }
}
