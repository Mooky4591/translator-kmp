import SwiftUI
import shared

struct ContentView: View {
    private let appModule = AppModule()
	var body: some View {
        ZStack {
            Color.background
                .ignoresSafeArea()
            TranslateScreen(
                historyDataSource: appModule.historyDao,
                translateUseCase: appModule.translate
            )
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
