# PowerReviews Project
Thank you for your interest in PowerReviews and for taking the time to complete this assignment. Please return your work to us within 48 hours.

## Purpose of this Project
The purpose of this project is to demonstrate best coding practices while implementing a small Spring Boot application.

## Background
As a SaaS company, I'd like to have a web application that can return ratings and reviews for restaurants. A review contains user information, comments, a rating and a date. The responses from this application will be consumed by either front-end or server applications.

## Requirements
Provided in this repo are json files to represent an initial set of restaurants and users, and code to import these into an in-memory database (H2 has been provided but feel free to use another one if you like). A fraction of the app has already been put in place as a way to get started.

#### Functionality
Please look over what is already in the repo and then build out the following endpoints:

##### Endpoints
- Return reviews for a single restaurant, sorted by date from newest to oldest.
- Return restaurants that serve a particular type of food (e.g, Burgers), sorted from highest to lowest average rating.
- Add a review to a restaurant

##### Validation

Perform data validation on the reviews that are received. Error messages from the application should clearly identify any data constraint/integrity issues:

- Review comments should not exceed 200 characters and cannot contain any of the following words:
    - lit, hella, chill, bro
- Ratings should be between 1-5.
- We should not accept reviews from users with the names Darth Vader and/or AC Slater.
- Restaurants must exist in the database.

##### Runtime

The application should support curl requests against any of the API endpoints. Please provide example curl requests with 
the data you used to test/run the application.

Example:
```bash
curl -XPOST http://localhost:8080/your/review/endpoint
-H 'accept: application/json'
-d '{
    your_review_json: your_review_json_data
}'
```

#### Identify problems
The starting code may not be accurate, and it is certainly not complete. Identify anything that stands out as problematic that should be fixed before going live, even if you don't have time to fix the issues.

#### Extra credit
Return restaurants based on how close they are to the user. For example, given latitude and longitude, return a list of restaurants that are ordered by distance away.

#### How to return the project ot us
Your code should be version controlled and publicly accessible for us to review (github/bit-bucket/gitlab/etc)
