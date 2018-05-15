#PowerReviews Project
Thank you for your interest in PowerReviews and taking the time to complete this project. The requirements should take less than a week to complete.

## Purpose of this Project
The purpose of this project is to demonstrate best coding practices while implementing a small Spring Boot application. 

## Background
As a SaaS company, I'd like to have a web application that can return ratings and reviews for restaurants. A review should contain
user information, comments, a rating, a date and should support an optional response from the restaurant. The responses from this application
will be consumed by either frontend or server applications.

## Requirements
Provided in this repo is a json of restaurants (resources/json/restaurants.json) that have a name and a type. The app should support importing the 
sample json dataset into an in-memory Database. An H2 Database has been provided in this project, but feel free to use others.

The requirements ask to implement the following endpoints:

- Return reviews for a single restaurant in a sortable order.
    - example: I want the highest rated reviews for a given restaurant.
- Return restaurants in a sortable order.
    - example: I want a list of the highest average rated restaurants that serve Burgers.
- Return reviews for a given user.
    - example: I want to read more reviews from a given user.
- Add a review to a restaurant
    - example: I did not like my meal from Jimmy John's, so I want to leave bad feedback.

Your code should be version controlled and publicly accessible by someone on our team for review (github/bit-bucket/gitlab/etc)

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

There are two extra credit endpoints that you can implement if you choose to: 
- Allow a user to update his/her review.
- Allow a restaurant to respond to a review.
    
## Constraints 
We need to perform data validations on the reviews we are receiving. 
Error messages from the application should clearly identify any data constraint/integrity issues.
- Review comments should not exceed 200 characters and cannot contain any of the following words:
    - lit, hella, chill, bro
- Ratings should be between 1-5.
- We should not accept reviews from users with the names Darth Vader and/or AC Slater.
- We cannot accept reviews from users from the state of Florida.
- Restaurants must exist in the database.
