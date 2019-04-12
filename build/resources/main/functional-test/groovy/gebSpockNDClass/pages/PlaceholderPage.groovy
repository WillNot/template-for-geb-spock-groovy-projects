package gebSpockNDClass.pages

import geb.Page

class PlaceholderPage extends Page{
    static url = "https://www.google.com"

    static content = {
        searchBox { $("input", name: "q") }
        googleSearchButton { $("input", name: "btnK", 1) }
    }

    static at = {
        searchBox && googleSearchButton && title == "Google"
    }

    //Value methods
    def searchBoxValue(String searchText) {
        searchBox.value(searchText)
    }

    // Click Methods
    def clickGoogleSearchButton = {googleSearchButton.click()}
}
