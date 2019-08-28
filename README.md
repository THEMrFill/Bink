# Bink
Coding test for Bink, requested in Java

Normally I work in Kotlin, but the request was for Java, so I had to "forget" some of the functionality that is so simple in Kotlin...

Using Retrofit2 for calls to themealdb APIs.
I started to add in ViewModels, but there isn't much need for the functionality, so it's left "empty".

Got the app working initially, then decided to add Dagger2 for helping with the mocking and stop re-loading of the factory... I had it working "simply", and tried to incorporate some extra features and managed to destroy my work, and I hadn't committed it, so couldn't roll-back.
As I had "destroyed" my work with Dagger, I had to remove the functionality to get the APIs working again - all because I wanted to wait until I had Dagger right before I committed... that'll teach me to not commit!

After the main screen (list of categories) was working, added in the menu list for the chosen category.
Followed this up with the recipe details, including some extra logic for the ingredients as they're not an array of objects, instead they're numbered strings, so some "ugly logic" in the functionality.
To add in some extra readability, some "HTML" formatting by converting the carriage returns to &lt;p&gt;, otherwise it's one big block of text, which isn't that readable.

There isn't much actual "business logic", so there aren't a lot of tests - the functionality is "call API, display entries" or "call API, display single entry", meaning it's a very simple bit of functionality.
Unit tests & Espresso tests committed late as I originally had the HTML formatting tests in unit tests, and they NEED to run in automation (as the HTML part is part of the runtime).
No tests of the API/response/display as they require the calls & responses.

Note that I've separated the RecyclerView.Adapter and the RecyclerView.Holder as it makes re-use easier, although I ended up reusing the whole adapter for the category list into the menu list, and rather than incorporating again, left them separate.

If I had something to play with further, I'd add in a menu drawer to swap between Category, Area, Ingredient, and a search, but the request was just for category, so that's what is done.

Enjoy! 😊
