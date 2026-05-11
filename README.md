A simple Spring Boot application that shortens long URLs into short codes and redirects them back to the original link.
It includes both REST APIs and a Thymeleaf UI.

Features
- Shorten any long URL into a short code (Base62 encoding).

- Redirect short URLs to their original destination.

- REST API endpoints for programmatic use.

- Thymeleaf UI for user‑friendly interaction.

- Basic validation for URL format.

REST APIs
Shorten URL
POST /api/shorten

Request:

json
{
  "longUrl": "https://www.geeksforgeeks.org/system-design/how-to-design-a-tiny-url-or-url-shortener/"
}
Response:

json
{
  "longUrl": "https://www.geeksforgeeks.org/system-design/how-to-design-a-tiny-url-or-url-shortener/",
  "shortUrl": "http://localhost:8080/bO",
  "message": "URL shortened successfully"
}


Redirect
GET /{code}

Example:

Code
GET http://localhost:8080/bN



