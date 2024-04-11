# GitHub Search App

GitHub Search App is an Android application built using Jetpack Compose, Dagger Hilt, Coroutine Flow, Paging 3, Retrofit, Navigation Controller, Room, Coil, and MVVM architecture. It allows users to search for repositories on GitHub and view detailed information about them.

# Search Optimization
For improving search functionality, debounce and distinctUntilChanged operators are utilized.
Debounce ensures that the search query is triggered only after a specified time interval of user inactivity, thus reducing unnecessary API calls and enhancing user experience.
DistinctUntilChanged ensures that only distinct consecutive search queries are processed, preventing redundant network requests for identical queries.

## Features

### Home Page
- Search bar to search repositories from the GitHub API.
- Recycler view using card view to display search results.
- Results limited to 10 per page with pagination.
- Ability to save the first 15 items' data offline for offline viewing.

### Repo Details Page
- Detailed description of the selected repository.
- Display of repository image, name, project link, description, and contributors.
- Clicking on the "project link" section opens a web view to show the content of the link.

## Usage

1. Clone the repository to your local machine:

 - https://github.com/Bhupendrapatel98/Search-Github-Repository.git

2. Open the project in Android Studio.

3. Build and run the project on an Android device or emulator.

## Dependencies

- Jetpack Compose: For building the UI of the app.
- Dagger Hilt: For dependency injection.
- Coroutine Flow: For asynchronous programming and data streams.
- Paging 3: For pagination of search results.
- Retrofit: For making network requests to the GitHub API.
- Navigation Controller: For handling navigation between screens.
- Room: For offline data persistence.
- Coil: For loading and displaying images.
- MVVM Architecture: For separating concerns and managing app data.

## Dependencies
Contributions are welcome! If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.