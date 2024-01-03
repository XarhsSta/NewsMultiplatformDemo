import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        KoinInitializerKt.initKoin()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}