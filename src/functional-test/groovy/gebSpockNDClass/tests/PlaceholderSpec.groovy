package gebSpockNDClass.tests

import geb.spock.GebSpec
import gebSpockNDClass.pages.PlaceholderPage

class PlaceholderSpec extends GebSpec {
    def "am I on the Google Home Page"() {
        when:
        to PlaceholderPage

        then:
        at PlaceholderPage

    }

    def "Entering text into the search page"() {
        given:
        to PlaceholderPage

        when:
        searchBoxValue("Geb")
        clickGoogleSearchButton()

        then:
        title.startsWith("Geb")
    }

}
