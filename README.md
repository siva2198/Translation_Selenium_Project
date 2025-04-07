# 📰 Web Scraper + Translator using Selenium & RapidAPI

This project demonstrates how to:

✅ **Scrape live news articles** from *El País* (a Spanish news website) using **Selenium WebDriver**  
✅ **Automatically detect and translate** Spanish content to English using **RapidAPI Translate**  
✅ **Handle cover image downloads**, **dynamic waits**, and common automation exceptions  
✅ **Run cross-browser tests** and validate **internationalized content**  

## 📦 Built with:
- **Java**
- **Selenium WebDriver**
- **TestNG**
- **RapidAPI**
- **Page Object Model (POM) Design Pattern**

## 🎯 Features:
- **Web Scraping**: Uses Selenium WebDriver to scrape live news articles from the *El País* website, extracting key details like the title, content, and cover image.
- **Translation**: Automatically translates the scraped Spanish content to English using the **RapidAPI Translate** API, offering an accurate translation of the text.
- **Cross-Browser Testing**: The automation script is configured to run across multiple browsers (like Chrome and Firefox) to ensure compatibility and consistent behavior.
- **Dynamic Waiting**: Uses **WebDriverWait** and **ExpectedConditions** to handle dynamic page content loading.
- **Exception Handling**: Handles common exceptions like `NoSuchElementException`, `TimeoutException`, and `StaleElementReferenceException` to ensure smooth scraping and interaction with the web page.

## 🚀 Setup & Installation:

### 1. **Clone this repository**:
```bash
git clone https://github.com/your-username/web-scraper-translator.git
cd web-scraper-translator
```

### 2. **Install Dependencies**:
Ensure you have **Java** and **Maven** installed. If not, you can download them here:

- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/install.html)

Then, install the required dependencies by running the following command:

```bash
mvn clean install
```
### 3. **Set up RapidAPI**:
1. Go to [RapidAPI](https://rapidapi.com/).
2. Search for **Translate API** and subscribe to a plan that fits your needs.
3. Get your **API Key** from the **RapidAPI Dashboard**.

### 4. **Configure API Key**:
1. Open `src/main/resources/config.properties` (create the file if it doesn't exist).
2. Add your RapidAPI key as follows:

```properties
rapidapi.key=YOUR_RAPIDAPI_KEY
```

### 5. **Set up WebDriver**:
1. Download the corresponding WebDriver for the browser you want to use:
   - [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/)
   - [GeckoDriver (for Firefox)](https://github.com/mozilla/geckodriver/releases)
2. Ensure the WebDriver is available in your system’s PATH or specify the path in the code.

### 6. **Run the Scraper**:
Open a terminal and run:

```bash
mvn test
```
- This will execute the tests and scrape news articles from the El País website, translating them into English.

### 💡 Contributing:
Feel free to clone the repository and make any improvements or bug fixes. Contributions are welcome!

1. Clone the repository:
   ```bash
   git clone https://github.com/siva2198/Translation_Selenium_Project.git
   ```

### 🤖 Thank you for checking out the project! We hope it helps with your web scraping and translation tasks. Happy coding! 🚀

