# Stock-Market-App
The aim of this app is to demonstrate a multi module architecture that is powered by a m3 design library module.

My intention was to first build the design library before even starting the features.

I have removed the Stock details screen as I need to change the endpoints, and google finance has done an amazing job at creating a stock details screen.

# To Build the Project

- Please run the redDebug build variant. 
- blueDebug has been removed due to the multi module navigation not being set up yet; the app module is not yet agnostic to which features the build variant supports. 

## Architecture

There are two kinds of module, named: feature_ and library_. A feature cannot depend on a feature. A feature can depend on a library. A library can depend on a library. A feature module has one or more user journeys. Libraries lack user journeys.

- feature_red contains a variety of mocked journeys, which will act as the basis for later features.
- feature_sentiments uses MVVM with LiveData with the Loading Success Error pattern via a sealed class.
- feature_red illustrate how to have a build variants with different features. The navigation is not yet fully set up to support this though.
- feature_test_core_utils exists to resolve a circular dependency issue by providing DispatcherProvider, which is needed by both library_core and library_core_testing.

## For reviewers
- I was not quite sure what kind of feature I wanted to build, and my idea changed a few times while working on the codebase. I was more interested in getting a design library set up that I could use for features.
- The codebase is pretty work in progress, but I think there are a variety of things that may be interesting in the project.
- There are places where I took ideas from, and credit is clearly stated in the comments within the code.
- I actually did not get time to implement a ViewModel/UseCase pattern that is my current preference. The approach taken in the codebase, in particular for the StockDetails is an older one that I have moved away from. 
- I have marked as @Deprecated or TODO areas where I want to do improvement.
- I have used more comments than I normally would in a production project, because the purpose of this codebase is mainly for educational purposes.

# Technologies
- Jetpack Compose using BoM (however I have overridden one of the compose UI libraries in order to use a feature that exists in alpha)
- MVVM with LiveData
- Kotlin
- Coroutines
- Dagger Hilt
- AndroidX Crypto for Encryption
- Intent based navigation (I plan to migrate to Jetpack Navigation)
- Coin for AsyncImage
- GraphQL WIP implementation has been removed until ready

## Technical Highlights
- Multi modular architecture that can scale to become brand agnostic as a white label product
- Feature modules that are independent from the network/data layer used
- Working towards a Design System first approach to building a mobile app
- Working towards making sure to think about how Date and Currency is handled from the get go

# Known issues
- The APIs on the Stock Details screen have quota limits, though this is mitigated by front end caching.
- The Stock Price and Day Change is cached, which means it is unfortunately not live.

# TODO
- Get the blue build variant working with alternative features
- Make the app module agnostic to which build variant is being run
- Standardise all version numbers in the project
- Fully implement multi module jetpack navigation
- Build up the library_core module using an agile approach
- Demonstrate the use of graphQL in one of the implemented features
- Get the colour scheme fully working with Android 12+ m3 Dynamic Colours