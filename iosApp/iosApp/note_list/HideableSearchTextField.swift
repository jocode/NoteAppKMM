//
//  HideableSearchTextField.swift
//  iosApp
//
//  Created by Johan Mosquera on 12/10/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct HideableSearchTextField<Destination: View>: View {
    
    var onSearhToggle: () -> Void
    var destinationProvider: () -> Destination
    var isSearchActive: Bool
    @Binding var searchText: String
    
    var body: some View {
        HStack {
            TextField("Search...", text: $searchText)
                .textFieldStyle(.roundedBorder)
                .opacity(isSearchActive ? 1 : 0)
            
            if !isSearchActive {
                Spacer()
            }
            Button(action: onSearhToggle) {
                Image(systemName: isSearchActive ? "xmark" : "magnifyingglass")
                    .foregroundColor(.black)
            }
            NavigationLink(destination: destinationProvider) {
                Image(systemName: "plus")
                    .foregroundColor(.black)
            }
        }
    }
}

struct HideableSearchTextField_Previews: PreviewProvider {
    static var previews: some View {
        HideableSearchTextField(
            onSearhToggle: {},
            destinationProvider: { EmptyView() },
            isSearchActive: true,
            searchText: .constant("Hello World")
        )
    }
}
