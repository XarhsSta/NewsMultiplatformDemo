import shared
import SwiftUI

struct DetailsListView: View {
    private struct RowItem: Hashable {
        let title: String
        let subtitle: String
    }

    private let items: [RowItem] = {
        let platform = Platform()
        platform.logPlatformSystemInfo()

        var result: [RowItem] = [
            .init(
                title: "Operating System",
                subtitle: "\(platform.osName) \(platform.osVersions)"
            ),
            .init(
                title: "Device",
                subtitle: platform.deviceModel
             ),
             .init(
                title: "Screen Density",
                subtitle: "@\(platform.density)x"
             )
        ]
        return result
    }()

      var body: some View {
        List {
          ForEach(items, id: \.self) { item in
            VStack(alignment: .leading) {
              Text(item.title)
                .font(.footnote)
                .foregroundStyle(.secondary)
              Text(item.subtitle)
                .font(.body)
                .foregroundStyle(.primary)
            }
            .padding(.vertical, 4)
          }
        }
      }
    }

    #Preview {
        DetailsListView()
    }
}