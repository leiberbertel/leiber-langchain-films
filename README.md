# leiber-langchain-films

**An AI experimentation lab for film management, built with Spring Boot and LangChain4j.**  
Discover how to integrate language models into your applications to deliver interactive, personalized film-related experiences.

##  Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Configuration](#configuration)
  - [Running Locally](#running-locally)
- [Usage](#usage)
- [Architecture](#architecture)
- [Contributing](#contributing)
- [Contact](#contact)

## Overview

**leiber-langchain-films** is a REST API built with Java that uses Spring Boot and LangChain4j to demonstrate the integration of language models for handling movie data. This project serves as an experimental platform for exploring:

- Interactive film queries and recommendations **_(In progress)_**


## Features

- **Integration with Spring Boot** for RESTful APIs and backend logic
- **LangChain4j support** for chaining language model tasks

## Getting Started

### Prerequisites

Ensure you have the following installed:

- **Java JDK 17+**  
- **Gradle 8.14.3**  
- **Docker & Docker Compose** (if you want containerized deployment)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/leiberbertel/leiber-langchain-films.git
   cd leiber-langchain-films

2. Build the project:

   ```bash
   ./gradlew clean build
   ```

### Configuration

Copy the example environment file and update it with your settings:

```bash
cp .env.example .env
# Then open and edit .env as needed (e.g., API keys)
```

### Running Locally

You have two options to run the application:

**a) Using Gradle:**

```bash
./gradlew bootRun
```

**b) Using Docker Compose:**

```bash
docker-compose up --build
```

## Usage

Once running, you can access the application at:

```
http://localhost:8090
```

## Architecture

* **Spring Boot** — Handles application structure, REST endpoints, and configuration
* **LangChain4j** — Provides the framework for linking language model tasks
* **Film domain layer** — Manages ingestion, storage, and querying of film-related information

## Contributing

Contributions are welcome!

1. Fork the repository
2. Create a new feature branch (`git checkout -b feature/my-feature`)
3. Submit a pull request explaining your changes

Please ensure code is well-formatted, documented, and includes tests when possible.

## Contact

For questions or discussions, feel free to reach out!

* GitHub: [leiberbertel](https://github.com/leiberbertel)
* Email: *leiberbertel777@gmail.com*
