import geb.spock.GebReportingSpec
import org.openqa.selenium.Keys

class GebishOrgSpec extends GebReportingSpec {

    def "can get to the current Book of Geb"() {
        when: "I go to the Geb homepage"
        to GebishOrgHomePage

        and: "I hover over the manuals menu"//hover over to expand the menu
        interact {
            moveToElement(manualsMenu.toggle)
        }

        then: "The current manual link is shown"//first link is for the current manual
        manualsMenu.links[0].text().endsWith("- CURRENT")

        and: "I can see the sidebars section"
        sidebars[0].text() == "Highlights"
        waitFor {sidebars[1].text() == "Build status"}
        sleep(5000)
        footer.click()

        when: "I click the current manual link"
        manualsMenu.links[0].click()
        username = "david"
        password = "changeme"
        submitbutton.click()

        then: "I am at the book of geb"
        at TheBookOfGebPage
        //waitFor{title == "Craftsy"}
    }
}