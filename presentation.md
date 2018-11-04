1. Introduction
1. Why am I doing this?
    1. My experience
    1. Helpful but possibly not known features
    1. It's up to you to decide if it is suitable for you
    1. i try to stay away from syntctical suger to make it easier to present
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
1. Mockito argument matchers
    1. __a.BikeServiceTest__
        1. if using mocks you might run in to the same issue
            1. not using argument matcher means that objects are comparied by reference
            1. lets create our own argument matcher
            1. simmialar to a custom hamcreast matcher but requires a bit more
            1. two ways of doing this
            1. first way is to report an argument matcher
            1. second way is to user argsThat
1. Paramttrized tests
    1. __a.BikeForTest__
        1. this is what we had in the beginning
        1. how can we make it easier to test for only input and expected out put mutations
        1. one thing that i did early in is using a loop
        1. that is obvously horrible due to teh fact that we don't know whivch iteration failed
    1. __a.BikeParametrizedTest__
        1. to solve this there is something called a parametrized test or data driven test
        1. data dirven tests require that you use a junit runner
        1. in this case a junit runner called Parametrized 
        1. the you need some way of specifying what data to test with
        1. to understand the return type we need a constructor and fields to use in the teste
        1. the retun type, every object array in the collection is used as input arguments to the constructor
        1. the collection describes how many times/which data to be looped over
        1. the fields are used to "pass" data to the test
        1. for every instance of the test that is created all test cases are run with that instances data
        1. this means that you can't mix regular test cases and parametrized test cases in on test class in junit 4
        1. there might be others where you can
        1. the report isn't much better than the for loop
        1. you can use a name variable to use for the test
        1. this i nice but don't over do it like __product - CreateBodyParametrizedTest__
    1. __b.PaintShopTest__
        1. hamcreast matcher in the data
        1. we don't need to bother about renaming test will break if we mess up
        1. but what about addition of new enum instances
    1. __b.FancyColourTest__
        1. create a new test like this, this will catch additions
        1. will not catch simultaneous additions and deletions
        1. why not do similar test for jpa annotation, by using reflection
1. Rules
    1. i have only used them a couple of times
    1. if you have lots of set up to do before a test
    1. try using rules or class rules
    1. a rule can be used instead of @before, @after, @beforeClass and @afterClass
    1. __c.ExperimentExternalResourceTest__
        1. lets start an externalResource
        1. first we must a class that extends from ExternalResource
        1. we have to implement a couple of methods
        1. creating an object of the rule
        1. has to be annotated with either @Rule or @ClassRule
        1. this tells junit to run this objects specified methods at bootstrapping time 
    1. __c.ExperimentMethodAndTestRuleTest__
        1. there are other rules like MethodRule and TestRule which only have and apply
        1. which is basically a @before
        1. There are acouple of rules provided for us to use like TemporaryRolder and TestName
1. More JunitRunners
    1. lets go back and explore a junit runner
    1. __d.FancyServiceTest__
        1. this one allowes us to annotatio a vcariable that we want ot be a mock
        1. runner will do mock=mock(FancyService.class) for us
        1. this might make the code a bit clearer for us
        1. what if we want to user the @Mocke in a data driven test
    1. __d.FancyServiceParametrizedTest__
        1. then we need to alter the test a bit
        1. we need to use the Parametrized runner for this to work
        1. of course we need our data
        1. in the @Before fixture we need to manually do what the Mockito runner does for us
    1. what about the SpringJUnit4ClassRunner in combination with parametrized and/or mockito runner
        1. there is a SpringClassRule and a SpringMethodRule for that 
        1. __product - GetSubCategoryIntegrationTest__
    