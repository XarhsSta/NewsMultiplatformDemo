import SwiftUI

struct DetailsScreen: View {
    @Environment(\.dismiss)
    private var dismiss

    var body: some View {
        NavigationStack {
            DetailsListView()
                .navigationTitle("Device Details")
                .toolbar {
                    ToolbarItem(placement: .primaryAction) {
                        Button {
                            dismiss()
                        } label: {
                            Text("Done")
                                .bold()
                        }
                    }
                }
        }
    }
}

#Preview {
    DetailsScreen()
}