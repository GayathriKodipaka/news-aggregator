<img width="1916" height="881" alt="image" src="https://github.com/user-attachments/assets/839b59c1-5795-4a44-9213-0a69da438695" />📰 News Aggregator – Spring Boot
A Spring Boot application that fetches Top Headlines from the NewsAPI and serves them via REST and a simple HTML view.
Perfect for demonstrating Java, Spring Boot, and API integration skills.

🚀 Features
Fetches live top headlines from NewsAPI.

REST endpoint returning JSON.

Browser-friendly HTML view.

Built with WebClient for modern non-blocking HTTP calls.

Easily configurable API key via application.properties.

🛠 Tech Stack
Java 17+

Spring Boot (Web, WebFlux)

Maven

NewsAPI

📦 Installation & Setup

Clone the repository:
git clone https://github.com/GayathriKodipaka/news-aggregator.git
cd news-aggregator
Get your free API key from NewsAPI.

Build & run the application:
mvn spring-boot:run

🌐 API Endpoints
Method	Endpoint	Description
GET	/news	Returns top headlines in JSON
GET	/news/html	Returns headlines as HTML page

📷 Example HTML Output
<img width="1916" height="881" alt="image" src="https://github.com/user-attachments/assets/10523775-9209-4c6a-991e-95f6a3e9c715" />
