1. Introduction
1. Why am I doing this?
    1. My experience
    1. Helpful but possibly not known features
1. My solutions might not be suitable for you
    1. It's up to you to decide if it is suitable for you
1. The point of this presentaion
    1. __presentation.PresentationTest__
    1. Lets start really basic
1. Hamcreast matchers
    1. __a.BikeTest__
        1. __Bike__ class looks like this
        1. assertTrue
            1. explicit argument
            1. RUN _firstBike_
            1. fail messages
        1. assertThat
            1. no need to specify argument, compares data types
            1. RUN _secondBike_
            1. better fail messages
            1. this looks really nice but what about more complex data structures
        1. other types of matchers
            1. _firstMatchers_
            1. _is_ uses _equals()_
            1. _contains_ looks att content of a list in a specific order
            1. _hasItem_ looks for a specific item in a list with no consideration to order
            1. we haven't reduced lines of code yet
        1. combinable matchers
            1. _secondMatchers_ 
            1. we can solve this with _combinableMatchers_
            1. they are type safe so we can't mix types e.g. _hasItem_ and _hasSize_
            1. they uses the builder pattern and can be combined
            1. isn't this a bit awkward to do for a large object 
        1. custom matcher
            1. _firstCustomMatchers_
            1. yes it is, lets use the _is_ matcher
            1. usually you will be able to do this, but our __Bike__ is a bit awkward with its manufacturingDate
            1. lets try to create our own matcher
        1. create custom matcher
            1. _secondCustomMatchers_
            1. i sprouted a method for the matcher
            1. lets look at the class hierarchy for a __Macther__
            1. there are a bunch of them but __TypeSafeMatcher__ sounds promising
            1. __CustomTypeSafeMatcher__ sounds like the one we want
            1. we need to provide a description and an implementation of how the matching is preformed
            1. lets look a an already finished implementation
        1. finished custom matcher
            1. this is what a finnshed matcher can look like
            1. usually the matcher uses _toString_ to print the item but that can be overridden
    1. __a.BikeServiceTest__
        1. if using mocks
            
