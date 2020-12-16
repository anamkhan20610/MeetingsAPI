# REST API Creation, Junit Testing, Logging, Swagger

The test contain creation of 5 API's its testing, Swagger file, Logging(database and Spring).
Database used = Postgres 
Follow below steps to run.

## Setup the Application

1. Create a database named `postgres`.

2. Open `src/main/resources/application.properties` and change `spring.datasource.username` and `spring.datasource.password` properties as per your MySQL installation.

3. Type `mvn spring-boot:run` from the root directory of the project to run the application.

4. Swagger URL : "http://localhost:8080/swagger-ui.html"

### API 1 : 
####  API to register attendee at the conference(name, title, company)
1. post API to save data, path = "http://localhost:8080/register/conference" 
2. table = AttendeeAtConference(id, attendeeName, company, conferenceTitle)

### API 2 :
####   API to register attendee for a specific talk  
1. post API to save data, path = "http://localhost:8080/register/specificTalk"
2. table = specificMeeting(attendeeName, talk)

### API 3 :
####  API to register as a session presenter(title, date, presenter) 
1. post API to save data, path = "http://localhost:8080/register/presenter"
2. table = presenter(talkPresenter, talkTitle, talkDate, location)
3. location is embedded => Address(h_number, street, city)

### API 4 :
####  API to get attendees for a specific talk
1. get API to fetch data, path = "http://localhost:8080/attendee/{meetingName}"

### API 5 :
####  Get attendee schedule (talks to attend, dates/times, location, etc)
1. get API to fetch data, path = "http://localhost:8080/schedule/{attendeeName}"
