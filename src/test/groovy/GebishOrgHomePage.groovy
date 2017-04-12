import geb.Page

class GebishOrgHomePage extends Page {

    static at = { title == "Geb - Very Groovy Browser Automation" }

    static content = {
        sidebars(required:false) { $("#sidebar h1") }
        footer { $("#footer-wrap")}
        manualsMenu { $("#header-content ul li", 0).module(MenuModule) }
    }
}
