# API for Currency Exchange

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=black)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=black)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=black)


This project was created based on this challenge: https://github.com/Apiki/back-end-challenge?tab=readme-ov-file 


## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Swagger](#swagger)
- [API Endpoints](#api-endpoints)
- [Conversions](#conversions)
- [Values of Conversion](#values)

## Installation
1. Clone the repository:

```bash
git clone https://github.com/LeonardoSnows/ConversaoDeMoedas.git
```

2. Install dependencies with Maven


## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080

## Swagger
- To use the Swagger, access the url: http://localhost:8080/swagger-ui/index.html#/

## API Endpoints
The API provides the following endpoints:

```markdown
POST /exchange/{amount}/{from}/{to}/{rate} - converts the value passed based on the quote passed into the rate

```

## Conversions
- From Real to Dollar;
- From Dollar to Real;
- From Real to Euro;
- From Euro to Real;

## Values
- Real  =  BRL
- Dolar =  USD
- Euro  =  EUR

