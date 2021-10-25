# Stock-Market-App
View investor sentiments of a stock and perform horizontal financial statement analysis

Technologies
- Jetpack Compose. This is my first investigation into Jetpack Compose.
- MVVM with the Loading Content Error pattern via a sealed class.
- Kotlin
- Coroutines
- Dagger Hilt
- AndroidX Crypto for Encryption

Technical Highlights
- Caching behaviour
- Single module clean architecture

Known issues
- The stock with ticker BENE fails to parse due to not handling the particular string from the api
- It is unclear (to me) what is the benefit of the Sentiment Score
- Possible smooth scrolling performance issue, at least seen on a low end device
- The ThumbsUp ThumbsDown icons are unclear that they represent whether the sentiment is Bullish or Bearish
- Stock Price and Day Change are not correctly formatted on the Stock Details screen
- The date on the Stock Details screen may be unclear that it is the year ending on the income statement
- Scrolling issue on the Stock Details screen, noticeable on smaller devices or when View Company Overview is expanded
- The APIs on the Stock Details screen have quota limits, though this is mitigated by front end caching.
- The Stock Price and Day Change is cached, which means it is unfortunately not live.
