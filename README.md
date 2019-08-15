# Moneybox Techical Task

## Part A - Fix current bugs

### Bug 1 - Layout does not look as expected
I fixed this bug by adding contraints as well as layout margins to the edittext views so that they are in the position like the solution.

### Bug 2 - Validation is incorrect
This was fixed by changing the allFIeldsValid method; 3 boolean variables were created for their respective edittext texts (email, password, name). The value to these variables were set to whether the pattern matches their respective regex. If all variables were true, the method would return true; else an error would be set to edittexts if the result was false.

### Bug 3 - Animation is looping incorrectly
This bug was addressed by first setting the min and max frame of the animation to the firstAnim pair values. I then added an animator listener to the animation; when the animation ended, i would set the min and max frame of the pig animation to the secondAnim pair values. And i would also set the repeat count to indefinite and play the animation.

## Part B - Add 2 new screens
For part B, I first used the Retrofit Library to use the moneybox api, the rerofit library enabled me to post the login details provided so i could get the session key and access the investor products. Created data classes for the response bodies to make the process easier. I used the Databinding Library to avoid using boilerplate code when initialising views. I applied the MVVM architecture to seperate business logic with the ui logic. All the business logic such as api calls occurred in the viewmodel classes and the ui logic occurred in the activity classes. I also used RxJava to run asynchronous methods and observe events; this enabled me to update the ui as soon as I successfully got data from the api or automatically show an error if something went wrong. I also used the Gson library for Retrofit so that I can convert the json response from the api to data class objects. Dagger2 was also implemented so that the dependecy injection was generated for me.
